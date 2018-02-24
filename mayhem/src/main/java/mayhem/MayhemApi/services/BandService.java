package mayhem.MayhemApi.services;

import mayhem.MayhemApi.classesForMayhemApi.Song;

import java.util.List;

public interface BandService {
    void add(Song song);
    List<Song> listSongs();
}
