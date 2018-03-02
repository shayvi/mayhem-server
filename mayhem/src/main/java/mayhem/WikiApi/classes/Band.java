package mayhem.WikiApi.classes;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder={"name", "origin"})
public class Band {

    private String name;
    private String origin;


    /**
     * an empty constructor for REST
     */
    public Band(){

    }

    /**
     *
     * @param name
     * @param origin
     */
    public Band(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

//    @Override
//    public String toString() {
//        String s = name + "[origin=" + origin + "]"  + "\n" + "Albums: " + "\n";
//        int i = 1;
//        for (Album album : albums){
//            s += i +"." + album + "\n";
//            i ++;
//        }
//        return s;
//    }

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


	/* functions */

    /**
     * Search for a album with a given name in the band's albums list
     *
     * @param albumName	(usually from uri, for example reroute_to_remain)
     * @return album if found, null otherwise
     */
//    public Album getAlbumByName(String albumName){
//        for(Album album : this.albums){
//            if(album.getName().toLowerCase().replaceAll(" ", "_").equals(albumName.toLowerCase())){	//TODO
//                return album;
//            }
//        }
//        return null;
//    }

}
