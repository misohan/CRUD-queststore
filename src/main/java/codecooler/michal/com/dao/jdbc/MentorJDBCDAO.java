package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.exception.DatabaseException;
import codecooler.michal.com.model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorJDBCDAO implements MentorDAO {
    private UserSQLConnection connection;

    public MentorJDBCDAO(UserSQLConnection connection) {
        this.connection = connection;
    }

    @Override
    public Mentor createMentor(Mentor mentor){
        String sql = "INSERT INTO mentors (firstname, lastname, age) " +
                "VALUES (?,?,?);";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, mentor.getFirstName());
            pst.setString(2, mentor.getLastName());
            pst.setInt(3, mentor.getAge());
            pst.executeUpdate();


        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        return mentor;

    }

    @Override
    public boolean updateMentor(int id, String firstName, String lastName, int age) {
        String sql = "UPDATE mentors "
                + "SET firstname= ?, lastName= ?, age= ?"
                + "WHERE ID = ?";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setInt(3, age);
            pst.setInt(4, id);
            pst.executeUpdate();

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        return true;
    }



    public List<Mentor> listAllMentors() {
        ResultSet resultSet = null;
        List<Mentor> listMentor = new ArrayList<>();

        String sql = "SELECT * FROM mentors";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Mentor mentor = new Mentor();

                mentor.setId(resultSet.getInt("id"));
                mentor.setFirstName(resultSet.getString("firstname"));
                mentor.setLastName(resultSet.getString("lastname"));
                mentor.setAge(resultSet.getInt("age"));

                listMentor.add(mentor);
            }

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
        return listMentor;
    }

    @Override
    public void removeMentor(Mentor mentor) {
        String sql = "DELETE FROM mentors WHERE id=?";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, mentor.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Mentor getMentorById(int id) {
        ResultSet resultSet = null;
        Mentor mentor = new Mentor();

        String sql = "SELECT * FROM mentors";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                mentor.setId(resultSet.getInt("id"));
                mentor.setFirstName(resultSet.getString("firstname"));
                mentor.setLastName(resultSet.getString("lastname"));
                mentor.setAge(resultSet.getInt("age"));

            }
            return mentor;

        } catch (SQLException e) {
            e.printStackTrace();
        }        return null;

    }

}
