package mayhem.MayhemApi.dao;

import mayhem.MayhemApi.classesForMayhemApi.Album;

import java.util.List;


public interface AlbumDao {
    void add(Album album);
    List<Album> listAlbums();
}