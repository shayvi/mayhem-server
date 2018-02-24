package mayhem.MayhemApi.classesForMayhemApi;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@Table(name = "SONGS")

@XmlRootElement
@XmlType(propOrder={"num", "name", "rate", "album"})
public class Song implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NUMBER")

    private int num;
    @Column(name = "NAME")
    private String name;

    @Column(name = "RATE")
    private int rate;

    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name="ALBUM_ID", referencedColumnName="ID", foreignKey=@ForeignKey(name="ALBUM_ID"))
    private Album album;

    /**
     * an empty constructor for REST
     */
    public Song(){

    }

    public Song(int num,String name, Album album){
        this(num, name,0, album);
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
