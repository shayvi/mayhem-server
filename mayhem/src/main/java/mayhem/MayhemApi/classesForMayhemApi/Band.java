package mayhem.MayhemApi.classesForMayhemApi;

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

}
