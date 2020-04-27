package repo;

import entity.Albums;
import entity.Artists;
import entity.Charts;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class ChartRepository {
    private final EntityManager entityManager;

    public ChartRepository() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    /**
     * Introducerea unui chart in baza de date prin intermediul JPA
     * @param chart
     */
    public void create(Charts chart) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(chart);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Selectarea albumelor din chart dupa un anumit criteriu
     * Selectarea se face cu ajutorul unui NamedQuery
     * @param criteria criteriul dupa care se cere clasamentul
     * @return clasamentul dupa acel criteriu
     */
    public List<Charts> findByCriteria(String criteria) {
        return entityManager.createNamedQuery("Charts.findByCriteria", Charts.class)
                .setParameter("criteria", criteria).getResultList();
    }
}


