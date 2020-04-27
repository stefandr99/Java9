package repo;

import entity.Albums;
import entity.Artists;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class AlbumRepository {
    private final EntityManager entityManager;

    /**
     * constructor unde se intializeaza entityManager cu ajutorul clasei singleton PersistenceUtil
     */
    public AlbumRepository() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    /**
     * Functie ce adauga un album in baza de date
     * @param album albumul care va fi introdus in baza de date
     */
    public void create(Albums album) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(album);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Functie ce cauta in baza de date un album dupa un id primit ca parametru
     * @param id id-ul albumului pe care il voi returna din baza de date
     * @return albumul gasit
     */
    public Albums findById(int id) {
        return entityManager.find(Albums.class, id);
    }

    /**
     * Cautarea unui album in baza de date dupa numele acestuia
     * Aici cautarea s-a facut cu ajutorul unui NamedQuery
     * @param name numele albumului pe care il cautam in baza de date
     * @return albumul gasit dupa nume
     */
    public Albums findByName(String name) {
        return entityManager.createNamedQuery("Album.findByName", Albums.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public List<Albums> findByArtist(Artists artist) {
        return entityManager.createNamedQuery("Album.findByArtist", Albums.class)
                .setParameter("artist", artist.getId()).getResultList();
    }

}
