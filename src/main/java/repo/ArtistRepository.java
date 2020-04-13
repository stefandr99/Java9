package repo;

import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ArtistRepository {
    private EntityManager entityManager;

    /**
     * constructor unde se intializeaza entityManager cu ajutorul clasei singleton PersistenceUtil
     */
    public ArtistRepository() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    /**
     * Functie ce adauga un artist in baza de date
     * @param artist artistul care se va introduce in baza de date
     * @return true - succes, false altfel
     */
    public boolean create(Artist artist) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(artist);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Functie ce cauta in baza de date un artist dupa un id primit ca parametru
     * @param id id-ul artistului pe care il voi returna din baza de date
     * @return artistul gasit
     */
    public Artist findById(int id) {
        Artist artist = entityManager.find(Artist.class, id);
        return artist;
    }

    /**
     * Cautarea unui artist in baza de date dupa numele acestuia
     * Aici cautarea s-a facut cu ajutorul unui NamedQuery
     * @param name numele artistului pe care il cautam in baza de date
     * @return artistul gasit dupa nume
     */
    public Artist findByName(String name) {
        Artist artist = entityManager.createNamedQuery("Artist.findByName", Artist.class)
                .setParameter("name", name)
                .getSingleResult();
        return artist;
    }

}
