package mayhem.MayhemApi.dao;
import mayhem.MayhemApi.classesForMayhemApi.Song;
import java.util.List;


public interface SongDao {
    void add(Song song);
    List<Song> listSongs();
}