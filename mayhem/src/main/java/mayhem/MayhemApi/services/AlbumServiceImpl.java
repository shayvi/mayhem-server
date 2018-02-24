package mayhem.MayhemApi.services;

import mayhem.MayhemApi.classesForMayhemApi.Album;
import mayhem.MayhemApi.dao.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    @Transactional
    @Override
    public void add(Album album) {
        albumDao.add(album);
    }

    @Transactional()
    @Override
    public List<Album> listAlbums() {
        return albumDao.listAlbums();
    }

}
