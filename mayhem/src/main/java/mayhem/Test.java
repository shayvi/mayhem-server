import mayhem.classes.Album;
import mayhem.classes.Band;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Test {

    static List<String> bands = Arrays.asList("alestorm", "in_flames", "ensiferum", "the_amity_affliction", "destruction",
            "bring_me_the_horizon", "disturbed", "green_day", "fall_out_boy", "betzefer",
            "limp_bizkit", "The_Black_Dahlia_Murder", "slipknot", "lamb_of_god", "the_ghost_inside",
            "kreator", "norther", "pantera", "megadeth", "metallica","slayer", "linkin_park" );



    public static void main(String [] args) throws IOException {
        for(String band : bands){
            Band bandObject = Band.getBand(band);
            for(Album alb : bandObject.getAlbums()){
                int size = alb.getGenres().size();
                //System.out.println(size);
                if(size > 4) System.out.println(alb.getName() + "	" + alb.getGenres());

            }

            //System.out.println(bandObject);
        }

    }
}

//TODO
//private static final String BANDNAME = "architects";

