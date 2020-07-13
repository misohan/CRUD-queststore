package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.model.Codecooler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodecoolerJDBCDAO implements CodecoolerDAO {
    private final UserSQLConnection dbConn = new UserSQLConnection();

    @Override
    public void createCodecooler(Codecooler codecooler) {
        String sql = "INSERT INTO codecoolers (id, firstname, lastname, age) " +
                "VALUES (?,?,?,?);";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, codecooler.getId());
            pst.setString(2, codecooler.getFirstName());
            pst.setString(3, codecooler.getLastName());
            pst.setInt(4, codecooler.getAge());

            System.out.println(sql);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Codecooler> listAllCodecoolers() {
        ResultSet resultSet = null;
        List<Codecooler> listCodecooler = new ArrayList<>();

        String sql = "SELECT * FROM codecoolers";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Codecooler codecooler = new Codecooler();

                codecooler.setId(resultSet.getInt("id"));
                codecooler.setFirstName(resultSet.getString("firstname"));
                codecooler.setLastName(resultSet.getString("lastname"));
                codecooler.setAge(resultSet.getInt("age"));

                listCodecooler.add(codecooler);
            }
            return listCodecooler;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeCodecooler(Codecooler codecooler) {
        String sql = "DELETE FROM codecoolers WHERE id=?";
        try
                (Connection con = dbConn.connect();
                 PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, codecooler.getId());
            pst.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCodecooler(Codecooler codecooler) {

    }
}