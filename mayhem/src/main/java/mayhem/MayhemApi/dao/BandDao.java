package mayhem.MayhemApi.dao;

import mayhem.MayhemApi.classesForMayhemApi.Song;

import java.util.List;


public interface BandDao {
    void add(Song song);
    List<Song> listSongs();
}