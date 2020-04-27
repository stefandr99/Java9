package repo;

import entity.Artists;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

/**
 * Repository abstract pentru a putea insera orice fel de date in baza de date printr-un singur obiect
 * Foloseste generics, de aceea putem introduce si artisti, si albume si chart-uri prin intremediul unui astfel de obiect
 * @param <T>
 */
public class AbstractRepository <T> {
    private final EntityManager entityManager;

    public AbstractRepository() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    public void create(T object) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
