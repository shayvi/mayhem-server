package mayhem.MayhemApi.dao;

import mayhem.MayhemApi.classesForMayhemApi.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
@Repository
public class BandDaoImpl implements BandDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Song song) {
        entityManager.persist(song);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> listSongs() {
        CriteriaQuery<Song> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Song.class);
        Root<Song> root = criteriaQuery.from(Song.class);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}