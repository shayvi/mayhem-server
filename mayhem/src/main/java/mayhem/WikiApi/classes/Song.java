package mayhem.WikiApi.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"num", "name", "rate"})
public class Song {

    private String name;
    private int num;
    private int rate;
    private String albumName;

    /**
     * an empty constructor for REST
     */
    public Song(){

    }

    public Song(int num,String name, String albumName){
        this(num, name,0,albumName);
    }

    public Song(int num, String name, int rate, String albumName) {
        this.num = num;
        this.name = name;
        this.rate = rate;
        this.albumName = albumName;
    }

    @Override
    public String toString() {
        return "   " + num + ". " + name;
    }

    /**
     * Song factory method
     */
    public static Song getSong(int num, String name, String albumName){
        return new Song(num, name, albumName);
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

	/* functions */

}
