package mayhem.WikiApi.controllers;

/**
 * Created by Shay Vikel on 19/05/2017.
 */

import mayhem.WikiApi.classes.Song;
import mayhem.WikiApi.parsing.ParserController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Path("/band")

@RestController
@CrossOrigin(origins = "http://localhost:7200")
@RequestMapping(value = "/wiki")
public class WikiBandController {

    //return all band songs
    @CrossOrigin(origins = "http://localhost:7200")
    @RequestMapping(value = "/{bandName}", method = RequestMethod.GET)
    public List<Song> getBandByName(@PathVariable String bandName) {
        bandName  = bandName.replaceAll(" ", "_").toLowerCase();

        long startTime = System.nanoTime();

        List <Song> songs = ParserController.getArtistSongs(bandName);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        double seconds = (double)totalTime / 1000000000.0;

        System.out.println(seconds);

        return songs;
    }


//    @RequestMapping(value = "/{bandName}/{albumName}", method = RequestMethod.GET)
//    public Album getAlbum(@PathVariable String bandName,
//                          @PathVariable String albumName) {
//        Band band = ParserController.getBand(bandName);  //TODO error handling : noSuchAlbum noSuchSong etc.
//        Album album = band.getAlbumByName(albumName);
//        return album;
//    }
//
//
//    @RequestMapping(value = "/{bandName}/{albumName}/{songName}", method = RequestMethod.GET)
//    public Song getSongByName(@PathVariable String bandName,
//                              @PathVariable String albumName,
//                              @PathVariable String songName) {
//        return new Song(3, "Somewhere I Belong", "Meteora");
//    }

}