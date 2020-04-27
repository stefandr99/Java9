package repo;

import entity.Albums;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

/**
 * Clasa unde se insereaza albume prin intermediul JPA (cu implementarea AbstractFactory)
 */
public class AlbumDaoJPA implements AbstractFactory<Albums> {
    private final EntityManager entityManager;


    public AlbumDaoJPA() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    public void create(Albums album) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(album);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
