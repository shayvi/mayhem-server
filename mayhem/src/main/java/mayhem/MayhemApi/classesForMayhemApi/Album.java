package mayhem.MayhemApi.classesForMayhemApi;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "ALBUMS")
@XmlRootElement
//@XmlType(propOrder={"name", "year", "genres", "band"})
@XmlType(propOrder={"name", "year", "band"})
public class Album {



    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private int year;

//    private List<String> genres;

    @Column(name = "BAND_ID")
    private int band;

    /**
     * an empty constructor for REST
     */
    public Album(){

    }

//    /**
//     *
//     * @param name
//     * @param year
//     * @param genres
//     * @param band
//     */
//    public Album(String name, int year, List<String> genres, Band band) {
//        this.name = name;
//        this.year = year;
//        this.genres = genres;
//        this.band = band;
//    }

    /**
     *
     * @param name
     * @param year
     * @param band
     */
    public Album(String name, int year, int band) {
        this.name = name;
        this.year = year;
        this.band = band;
    }


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


//    public List<String> getGenres() {
//        return genres;
//    }


//    public void setGenres(List<String> genres) {
//        this.genres = genres;
//    }


    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

	/* functions */

}
