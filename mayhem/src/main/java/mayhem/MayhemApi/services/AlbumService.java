package mayhem.MayhemApi.services;

import mayhem.MayhemApi.classesForMayhemApi.Album;

import java.util.List;

public interface AlbumService {
    void add(Album album);
    List<Album> listAlbums();
}
