package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Codecooler;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodecoolerJDBCDAO implements CodecoolerDAO {
    private UserSQLConnection connection;

    public CodecoolerJDBCDAO(UserSQLConnection connection) {
        this.connection = connection;
    }

    @Override
    public void createCodecooler(Codecooler codecooler) {
        String sql = "INSERT INTO codecoolers (id, firstname, lastname, age, email) " +
                "VALUES (?,?,?,?,?);";


        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, codecooler.getId());
            pst.setString(2, codecooler.getFirstName());
            pst.setString(3, codecooler.getLastName());
            pst.setInt(4, codecooler.getAge());
            pst.setString(5, codecooler.getEmail());

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

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Codecooler codecooler = new Codecooler();

                codecooler.setId(resultSet.getInt("id"));
                codecooler.setFirstName(resultSet.getString("firstname"));
                codecooler.setLastName(resultSet.getString("lastname"));
                codecooler.setAge(resultSet.getInt("age"));
                codecooler.setEmail(resultSet.getString("email"));

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
                (Connection con = connection.connect();
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

//    @Override
    public Codecooler getCodecoolerByEmail(String email) {
        try
                (Connection con = connection.connect();
                 PreparedStatement pst = con.prepareStatement("select * from users where email = ?");
                ) {
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String userEmail = rs.getString(1);

                return new Codecooler(userEmail);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }
    @Override
    public boolean checkIfCodecoolerExists(String email) {
        try
                (Connection con = connection.connect();
                 PreparedStatement pst = con.prepareStatement("select * from users where email = ?");
                ) {
            pst.setString(1, email);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public List<Artifact> listCodecoolersArtifacts(String email) {
        ResultSet resultSet = null;
        List<Artifact> listArtifacts = new ArrayList<>();

        String sql = "SELECT * FROM ccartifacts WHERE email = ?";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1,email);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Artifact artifact = new Artifact();

                artifact.setId(resultSet.getInt("id"));
                artifact.setTitle(resultSet.getString("title"));
                artifact.setDescription(resultSet.getString("description"));
                artifact.setCredit(resultSet.getInt("credit"));

                listArtifacts.add(artifact);
            }
            return listArtifacts;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addArtifactByCodecooler(String email, int id, String title, String description, int credit) {
        String sql = "INSERT INTO ccartifacts (email, id, title, description, credit) " +
                "VALUES (?,?,?,?,?);";


        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, email);
            pst.setInt(2, id);
            pst.setString(3, title);
            pst.setString(4, description);
            pst.setInt(5, credit);

            System.out.println(sql);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
