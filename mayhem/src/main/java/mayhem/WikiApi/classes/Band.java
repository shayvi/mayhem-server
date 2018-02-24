package mayhem.WikiApi.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;


@XmlRootElement
@XmlType(propOrder={"name", "origin", "albums"})
public class Band {

    private String name;
    private String origin;
    private List<Album> albums;

    /**
     * an empty constructor for REST
     */
    public Band(){

    }

    /**
     *
     * @param name
     * @param origin
     * @param albums
     */
    public Band(String name, String origin, List<Album> albums) {
        this.name = name;
        this.origin = origin;
        this.albums = albums;
    }

    @Override
    public String toString() {
        String s = name + "[origin=" + origin + "]"  + "\n" + "Albums: " + "\n";
        int i = 1;
        for (Album album : albums){
            s += i +"." + album + "\n";
            i ++;
        }
        return s;
    }

	/* Getters and Setters */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

	/* functions */

    /**
     * Search for a album with a given name in the band's albums list
     *
     * @param albumName	(usually from uri, for example reroute_to_remain)
     * @return album if found, null otherwise
     */
    public Album getAlbumByName(String albumName){
        for(Album album : this.albums){
            if(album.getName().toLowerCase().replaceAll(" ", "_").equals(albumName.toLowerCase())){	//TODO
                return album;
            }
        }
        return null;
    }

}
