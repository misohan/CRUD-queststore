package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorJDBCDAO implements MentorDAO {
    private final UserSQLConnection connection = new UserSQLConnection();
    private UserSQLConnection dbcoonection;

    public MentorJDBCDAO(UserSQLConnection dbcoonection) {
        this.dbcoonection = dbcoonection;
    }

    @Override
    public void createMentor(Mentor mentor){
        String sql = "INSERT INTO mentors (id, firstname, lastname, age) " +
                "VALUES (?,?,?,?);";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, mentor.getId());
            pst.setString(2, mentor.getFirstName());
            pst.setString(3, mentor.getLastName());
            pst.setInt(4, mentor.getAge());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void updateMentor(int id, String firstName, String lastName, int age) {
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
            System.out.println(e.getMessage());
        }
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
            return listMentor;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeMentor(Mentor mentor) {
        String sql = "DELETE FROM mentors WHERE id=?";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, mentor.getId());
            pst.executeUpdate();
            System.out.println("Data deleted successfully");
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
        }
        return null;

    }

}
