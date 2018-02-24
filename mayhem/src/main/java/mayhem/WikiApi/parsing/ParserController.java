package mayhem.WikiApi.parsing;

import mayhem.WikiApi.classes.Album;
import mayhem.WikiApi.classes.Band;
import mayhem.WikiApi.classes.Song;

import java.util.List;

public class ParserController {


    /**
     * Band factory method
     */
    public static Band getBand(String bandName){
        BandParser parser = new BandParser(bandName);
        String origin = parser.getOrigin();
        List<Album> albums = parser.getAlbums();
        return new Band(bandName, origin, albums);
    }


    /**
     * Album factory method
     */
    public static Album getAlbum(String albumName, String albumLink, String bandName){
        AlbumParser parser = new AlbumParser(albumName, albumLink);

        int year = parser.getAlbumYear();
        List<String> genres = parser.getAlbumGenres();
        List<Song> songs = parser.getAlbumSongs();

        return new Album(albumName, year, genres, songs, bandName);
    }

    public static List<Song> getArtistSongs(String bandName){
     return null;
    }
}
