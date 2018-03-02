package mayhem.WikiApi.parsing;

import mayhem.WikiApi.classes.Song;

import java.util.ArrayList;
import java.util.List;

public class ParserController {

    public static List<Song> getArtistSongs(String artistName){
        List<Song> songs = new ArrayList<Song>();

        BandParser bandParser = new BandParser(artistName);

        return bandParser.getSongs();
    }




}
