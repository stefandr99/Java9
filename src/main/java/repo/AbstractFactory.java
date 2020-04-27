package repo;

import java.sql.SQLException;

/**
 * Interfata pentru adaugarea in baza de date a artistilor, albumelor sau chart-urilor
 * @param <T>
 */
public interface AbstractFactory <T> {
    void create(T object) throws SQLException;
}
