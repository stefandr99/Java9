package repo;

import entity.Artists;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ArtistDaoJPA implements AbstractFactory<Artists>{
    private final EntityManager entityManager;

    /**
     * constructor unde se intializeaza entityManager cu ajutorul clasei singleton PersistenceUtil
     */
    public ArtistDaoJPA() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    /**
     * Functie ce adauga un artist in baza de date
     * @param artist artistul care se va introduce in baza de date
     */
    public void create(Artists artist) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(artist);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
