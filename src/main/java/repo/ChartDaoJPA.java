package repo;

import entity.Charts;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ChartDaoJPA implements AbstractFactory<Charts> {
    private final EntityManager entityManager;

    /**
     * constructor unde se intializeaza entityManager cu ajutorul clasei singleton PersistenceUtil
     */
    public ChartDaoJPA() {
        entityManager = PersistenceUtil.getFactory().createEntityManager();
    }

    /**
     * Functie ce va introduce un chart prin intermediul JPA
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
}
