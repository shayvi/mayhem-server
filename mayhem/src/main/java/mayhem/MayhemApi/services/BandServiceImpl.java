package mayhem.MayhemApi.services;

import mayhem.MayhemApi.classesForMayhemApi.Song;
import mayhem.MayhemApi.dao.SongDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BandServiceImpl implements BandService {

    @Autowired
    private SongDao songDao;

    @Transactional
    @Override
    public void add(Song song) {
        songDao.add(song);
    }

    @Transactional()
    @Override
    public List<Song> listSongs() {
        return songDao.listSongs();
    }

}
