package repo;

import entity.Albums;
import util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clasa care insereaza albume in baza de date prin JDBC
 */
public class AlbumDaoJDBC implements AbstractFactory<Albums> {
    private final Database db;

    public AlbumDaoJDBC() throws SQLException {
        db = Database.getConnection();
    }

    public void create(Albums album) throws SQLException {
        Statement stmt = db.conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id_seq2.nextval as nval from dual");
        rs.next();
        String sql = "insert into albums (id, name, artist_id, release_year, genre) values (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = db.conn.prepareStatement(sql);
        System.out.println(album.getArtist_id().getId());

        pstmt.setInt(1, rs.getInt("nval"));
        pstmt.setString(2, album.getName());
        pstmt.setInt(3, album.getArtist_id().getId());
        pstmt.setInt(4, album.getRelease_year());
        pstmt.setString(5, album.getGenre());
        pstmt.executeUpdate();

        album.setId(rs.getInt("nval"));
    }
}
