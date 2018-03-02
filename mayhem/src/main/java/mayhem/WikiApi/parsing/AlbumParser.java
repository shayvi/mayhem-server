package mayhem.WikiApi.parsing;

import mayhem.WikiApi.classes.Album;
import mayhem.WikiApi.classes.Band;
import mayhem.WikiApi.classes.Song;
import mayhem.WikiApi.config.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlbumParser {

    private Document albumDoc;
    private Album album;

    public AlbumParser(String albumName, String albumLink, Band band){

        try {
            this.albumDoc = Jsoup.connect(albumLink).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.album = new Album(albumName,this.getAlbumYear(),this.getAlbumGenres(),band);
    }


    /**
     * @return the year of the album release
     */
    public int getAlbumYear(){
        Element release =  albumDoc.select("th:contains(Released) ~ td").first();
        //System.out.println(release.text());
        return Config.extractYear(release.text());
    }


    /**
     * @return the genres of the album
     */
    public List<String> getAlbumGenres(){
        List <String> genres = new ArrayList<String>();
        Elements genreElements = null;

        //because there are cases genres are not mentioned
        if(albumDoc.select("tr:contains(Genre)").first() != null){
            genreElements = albumDoc.select("tr:contains(Genre)").first()
                    .select("a").not("a:contains([1]), a:contains([2]), a:contains([3]),"
                            + "a:contains([4]), a:contains([5]), a:contains([6]),"
                            + "a:contains([7]), a:contains([8]), a:contains([9]),"
                            + "a:contains([10]), a:contains(Genre)");
        }

		/*
		Elements genreElements =  albumDoc.select("tr:contains(Genre) a")
								  .not("a:contains([1]), a:contains([2]),a:contains([3]) ,"
								  		+ "a:contains([4]), a:contains(Genre)");
		*/

        if (genreElements != null){
            for(Element genreElement : genreElements){
                String genreText = genreElement.text().toLowerCase();
                genres.add(genreText);
            }
        }

        return  genres;
    }

    /**
     * @return the list of songs of the album
     */
    public List<Song> getAlbumSongs() {
        List<Song> songs = new ArrayList<Song>();

        Elements tables =  albumDoc.select("h2:contains(Track listing) ~ table");
        Elements firstTable = tables.first().select("tr").not("tr:has(th)").not("tr:contains(Total length)");
        Elements secondTable = null;
        if(tables.size() > 1){
            secondTable = tables.get(1).select("table:contains(bonus)").select("tr")
                    .not("tr:has(th)").not("tr:contains(Total length)");
        }


        for(Element song : firstTable){
            songs = addSongToList(songs,song);
        }

        if(secondTable != null){
            for(Element song : secondTable){
                songs = addSongToList(songs,song);
            }
        }

        return songs;
    }

    /**
     *
     * @param songs
     * @param song
     * @return
     */
    public List<Song> addSongToList(List<Song> songs, Element song){
        String idString;
        String songName;
        Elements songParts = song.select("td");
        idString = songParts.first().text();//song id
        songName = songParts.get(1).text();//song name
        //System.out.println(song);

        // "name" ---> name
        if(songName.startsWith("\"") && songName.endsWith("\"")){
            songName = songName.substring(1, songName.length() - 1);
        }


        songs.add(Song.getSong(Config.extractId(idString), songName, this.album));
        return songs;
    }


    public static Album getAlbum(String albumName, String albumLink, Band band){
        AlbumParser parser = new AlbumParser(albumName, albumLink, band);

        int year = parser.getAlbumYear();
        List<String> genres = parser.getAlbumGenres();
        return new Album(albumName, year, genres, band);
    }



}
