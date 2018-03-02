package mayhem.WikiApi.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlRootElement
@XmlType(propOrder={"name", "year", "genres", "bandName"})
public class Album {

    private String name;
    private int year;
    private List<String> genres;
    private Band band;

    /**
     * an empty constructor for REST
     */
    public Album(){

    }

    /**
     *
     * @param name
     * @param year
     * @param genres
     * @param band
     */
    public Album(String name, int year, List<String> genres, Band band) {
        this.name = name;
        this.year = year;
        this.genres = genres;
        this.band = band;
    }


//    @Override
//    public String toString() {
//        String s = bandName + ": " + name + " [year=" + year + ", genres=" + genres + "]" +"\n";
//        for(Song song : songs){
//            s += song + "\n";
//        }
//
//        return s;
//    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getYear() {
        return year;
    }


    public void setYear(int year) {
        this.year = year;
    }


    public List<String> getGenres() {
        return genres;
    }


    public void setGenres(List<String> genres) {
        this.genres = genres;
    }


    public Band getBand() {
        return band;
    }

    public void setBandName(Band band) {
        this.band = band;
    }

	/* functions */

    /**
     * Search for a song with a given name in the album's songs list
     *
     * @param songName
     * @return song if found, null otherwise
     */
//    public Song getSongByName(String songName) {
//
//        for(Song song : this.songs){
//            if(song.getName().toLowerCase().replaceAll(" ", "_").equals(songName)){
//                return song;
//            }
//        }
//        return null;
//    }

}
