package mayhem.MayhemApi.controllers;

/**
 * Created by Shay Vikel on 19/05/2017.
 */

import mayhem.WikiApi.classes.Album;
import mayhem.WikiApi.classes.Band;
import mayhem.WikiApi.classes.Song;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/mayhem")
public class BandController {

    @RequestMapping(value = "/{bandName}", method = RequestMethod.GET)
    public Band getBandByName(@PathVariable String bandName) {
        return new Band(bandName,"USA",null);
    }


    @RequestMapping(value = "/{bandName}/{albumName}", method = RequestMethod.GET)
    public Album getAlbum(@PathVariable String bandName,
                          @PathVariable String albumName) {
        return new Album(albumName,  2000 , null , null, bandName);
    }


    @RequestMapping(value = "/{bandName}/{albumName}/{songName}", method = RequestMethod.GET)
    public Song getSongByName(@PathVariable String bandName,
                              @PathVariable String albumName,
                              @PathVariable String songName) {
        return new Song();
    }

}