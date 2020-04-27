package repo;

import entity.Artists;
import util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clasa prin care se introduc artisti in baza de date prin intermediul JDBC
 */
public class ArtistDaoJDBC implements AbstractFactory<Artists> {
    private final Database db;

    public ArtistDaoJDBC() throws SQLException {
        db = Database.getConnection();
    }

    public void create(Artists artist) throws SQLException {
        Statement stmt = db.conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id_seq.nextval as nval from dual");
        rs.next();

        String sql = "insert into artists (id, name, country) values (?, ?, ?)";
        PreparedStatement pstmt = db.conn.prepareStatement(sql);
        pstmt.setInt(1, rs.getInt("nval"));
        pstmt.setString(2, artist.getName());
        pstmt.setString(3, artist.getCountry());
        pstmt.executeUpdate();

        artist.setId(rs.getInt("nval"));
    }
}
