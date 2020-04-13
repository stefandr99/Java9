package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Clasa singleton care va returna EntityManagerFactory
 */
public class PersistenceUtil {

    public static EntityManagerFactory getFactory() {
        return Persistence
                .createEntityManagerFactory("MusicAlbumsPU");
    }

}
