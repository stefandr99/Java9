package repo;

import entity.Charts;
import util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChartDaoJDBC implements AbstractFactory<Charts> {
    private final Database db;

    public ChartDaoJDBC() throws SQLException {
        db = Database.getConnection();
    }

    /**
     * Functie ce va introduce un chart in baza de date prin intermediul JDBC
     * @param chart chart-ul care se va introduce
     * @throws SQLException
     */
    public void create(Charts chart) throws SQLException {
        Statement stmt = db.conn.createStatement();
        ResultSet rs = stmt.executeQuery("select hibernate_sequence.nextval as nval from dual");
        rs.next();
        String sql = "insert into charts (id, album_id, criteria, rank) values (?, ?, ?, ?)";
        PreparedStatement pstmt = db.conn.prepareStatement(sql);
        pstmt.setInt(1, rs.getInt("nval"));
        pstmt.setInt(2, chart.getAlbum_id().getId());
        pstmt.setString(3, chart.getCriteria());
        pstmt.setInt(4, chart.getRank());
        pstmt.executeUpdate();

    }
}
