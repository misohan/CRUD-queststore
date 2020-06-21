package codecooler.michal.com.dao;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.model.Mentor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MentorJDBCDAO implements MentorDAO {
    private final UserSQLConnection dbConn = new UserSQLConnection();
    private UserSQLConnection connection;

    public MentorJDBCDAO() {
        this.connection = new UserSQLConnection();
    }



    @Override
    public void createMentor(Mentor mentor){

        String sql = "INSERT INTO mentors (id, firstname, lastname, age) " +
                "VALUES (?,?,?,?);";

        try (Connection con = dbConn.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, mentor.getId());
            pst.setString(2, mentor.getFirstName());
            pst.setString(3, mentor.getLastName());
            pst.setInt(4, mentor.getAge());

            System.out.println(sql);

            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Mentor> listAllMentors() {
        ResultSet resultSet = null;
        List<Mentor> listMentor = new ArrayList<>();

        String sql = "SELECT * FROM mentors";

        try (Connection con = dbConn.connect();
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
    public void removeUser(Mentor mentor) {

        String sql = "DELETE FROM mentors WHERE id=?";

        try
                (Connection con = dbConn.connect();
                 PreparedStatement ptmt = con.prepareStatement(sql)) {

            ptmt.setInt(1, mentor.getId());
            ptmt.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
