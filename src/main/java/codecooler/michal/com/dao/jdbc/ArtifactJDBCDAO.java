package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.mentor.ArtifactDAO;
import codecooler.michal.com.model.Artifact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtifactJDBCDAO implements ArtifactDAO {
    private final UserSQLConnection dbConn = new UserSQLConnection();
    private UserSQLConnection connection;

    public ArtifactJDBCDAO() {
        this.connection = new UserSQLConnection();
    }

    @Override
    public void createArtifact(Artifact artifact) {
        String sql = "INSERT INTO artifacts (id, title, description, credit) " +
                "VALUES (?,?,?,?);";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, artifact.getId());
            pst.setString(2, artifact.getTitle());
            pst.setString(3, artifact.getDescription());
            pst.setInt(4, artifact.getCredit());

            System.out.println(sql);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Artifact> listAllArtifacts() {
        ResultSet resultSet = null;
        List<Artifact> listArtifacts = new ArrayList<>();

        String sql = "SELECT * FROM artifacts";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Artifact artifact = new Artifact();

                artifact.setId(resultSet.getInt("Id"));
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
    public void removeArtifact(Artifact artifact) {
        String sql = "DELETE FROM artifacts WHERE id=?";
        try
                (Connection con = dbConn.connect();
                 PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, artifact.getId());
            pst.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}