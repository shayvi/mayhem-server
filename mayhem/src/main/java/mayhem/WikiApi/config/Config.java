package mayhem.WikiApi.config;

public class Config {
    public static final String WIKI = "http://en.wikipedia.org/wiki/";
    public static final String WIKIPEDIA = "http://en.wikipedia.org";

    /**
     * Extract the year integer out of a given String
     */
    public static int extractYear(String string){
        string = string.replaceAll("\\[[1-9]\\]", "");	//remove [1] etc..
        String [] out = string.split("[\\s\\xA0]+");

        int x = -1;
        for(String a : out){
            //System.out.println(a);
            try{
                x = Integer.parseInt(a);
            }
            catch(NumberFormatException e){
                //System.out.println(a);;
            }
        }

        //System.out.println(x);
        return x;
    }

    public static int extractId(String idString) {
        idString = idString.replaceAll("\\.", "");
        int id = -1;
        try{
            id = Integer.parseInt(idString);
        }
        catch(NumberFormatException e){

        }

        return id;
    }
}
