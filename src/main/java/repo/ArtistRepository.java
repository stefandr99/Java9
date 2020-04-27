package repo;

import entity.Artists;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ArtistRepository {
    private final EntityManager entityManager;

    /**
     * constructor unde se intializeaza entityManager cu ajutorul clasei singleton PersistenceUtil
     */
    public ArtistRepository() {
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

    /**
     * Functie ce cauta in baza de date un artist dupa un id primit ca parametru
     * @param id id-ul artistului pe care il voi returna din baza de date
     * @return artistul gasit
     */
    public Artists findById(int id) {
        return entityManager.find(Artists.class, id);
    }

    /**
     * Cautarea unui artist in baza de date dupa numele acestuia
     * Aici cautarea s-a facut cu ajutorul unui NamedQuery
     * @param name numele artistului pe care il cautam in baza de date
     * @return artistul gasit dupa nume
     */
    public Artists findByName(String name) {
        return entityManager.createNamedQuery("Artist.findByName", Artists.class)
                .setParameter("name", name)
                .getSingleResult();
    }

}
