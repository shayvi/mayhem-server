package mayhem.MayhemApi.dao;

import mayhem.MayhemApi.classesForMayhemApi.Album;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class AlbumDaoImpl implements AlbumDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Album album) {
        entityManager.persist(album);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Album> listAlbums() {
        CriteriaQuery<Album> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Album.class);
        Root<Album> root = criteriaQuery.from(Album.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}