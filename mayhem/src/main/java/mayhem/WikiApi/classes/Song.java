package mayhem.WikiApi.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"num", "name", "rate", "album"})
public class Song {

    private String name;
    private int num;
    private int rate;
    private Album album;

    /**
     * an empty constructor for REST
     */
    public Song(){

    }

    public Song(int num,String name, Album album){
        this(num, name,0,album);
    }

    public Song(int num, String name, int rate, Album album) {
        this.num = num;
        this.name = name;
        this.rate = rate;
        this.album = album;
    }

    @Override
    public String toString() {
        return "   " + num + ". " + name;
    }

    /**
     * Song factory method
     */
    public static Song getSong(int num, String name, Album album){
        return new Song(num, name, album);
    }

    /* Getters and Setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

	/* functions */

}
