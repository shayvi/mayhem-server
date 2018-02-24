package mayhem.WikiApi.parsing;

import mayhem.WikiApi.classes.Album;
import mayhem.WikiApi.config.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BandParser {

    private Document bandDoc;
    private String bandName;

    public BandParser(String bandName){
        this.bandName = bandName;
        this.bandDoc = getBandDoc(bandName);
    }

    /**
     *
     * @param bandname
     * @return the Wikipedia's Document of the band.
     * @throws IOException
     *
     * There is a chance that the band name is a "generic" name, such as "kiss".
     * In this case we need to add to the URL the extension "_(band)".
     * for example:
     * en.wikipedia.org/wiki/Lamb_of_God will lead us to --->
     * "Lamb of God is a title for Jesus that appears in the Gospel of John..."
     *
     * Although what we meant for is:
     * en.wikipedia.org/wiki/Lamb_of_God_(band) --->
     * "Lamb of God is an American groove metal ***band***..."
     *
     * So we have to look for the word "band" in the first <p> of the doc.
     *
     */
    private static Document getBandDoc(String bandname){
        Document doc = null;
        try {
            doc = Jsoup.connect(Config.WIKI+bandname).get();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("Error connecting to Wikipedia");
            return doc;
        }

        Element el = doc.select("p").first();
        if(!el.text().contains("band")){
            String formattedBandName = bandname + ("_(band)");
            try {
                doc = Jsoup.connect(Config.WIKI+formattedBandName).get();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                System.out.println("Error connecting to Wikipedia");
                return doc;
            }
        }
        //TODO in case we have more than 1 band in the disambiguation page
        //for exanple : architects ---> american band, british band

        return doc;
    }


    /**
     *
     * @return the origin country of the band
     *
     * In wikipedia, origin is given in the following manner:
     * City, State/County, Country or City, Country
     * Examples:
     * Los Angeles, California, U.S.
     * Helsinki, Finland
     *
     */
    public String getOrigin(){
        Elements origin =  bandDoc.select("tr:has(th:containsOwn(Origin)) > td");
        String originText = origin.text();

        String [] origins = originText.split(",");
        String country  = origins.length == 3 ?  origins[2].trim() : origins[1].trim();

        country = country.contains("U.S") || country.contains("United States") ?  "USA" : country;
        return  country;
    }


    /**
     *
     * @return list of band albums
     * @throws IOException
     */
    public List<Album> getAlbums() {

        Album albumObject = null;
        String albumName;
        String albumLink;
        List<Album> albums = new ArrayList<Album>();

        Elements albumsElements = this.getAlbumsElements();

        for(Element albumElement : albumsElements){
            albumName = albumElement.text();
            albumLink = Config.WIKIPEDIA + albumElement.attr("href");

            //because there is a case that "Wikipedia does not have an article with this exact name"
            try{
                albumObject = ParserController.getAlbum(albumName, albumLink, this.bandName);
            }
            catch(NullPointerException e){};

            albums.add(albumObject);
        }

        return albums;
    }


    /**
     *
     * @return band albums Elements
     */
    private Elements getAlbumsElements(){
        Elements albumsElements =  bandDoc.select( "tr:contains(Studio albums) i a");

        if(albumsElements.size() == 0){
            Element albumsList = bandDoc.select("h2:contains(Discography) ~ ul ").first();
            albumsElements = albumsList.select("a");

        }
        if(albumsElements.size() == 0){
            albumsElements =  bandDoc.select( "dl:contains(Studio albums) ~ table i a");
        }

        //beacuse some times the headline "studio albums" is also given in <a> element.
        albumsElements = albumsElements.not("a:contains(Studio albums)");

        return albumsElements;
    }



}
