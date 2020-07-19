package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.QuestDAO;
import codecooler.michal.com.exception.DatabaseException;
import codecooler.michal.com.model.Quest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestJDBCDAO implements QuestDAO {
    private UserSQLConnection connection;

    public QuestJDBCDAO(UserSQLConnection connection)    {
        this.connection = connection;
    }


    @Override
    public void createQuest(Quest quest) {
        String sql = "INSERT INTO quests (id, title, description, credit) " +
                "VALUES (?,?,?,?);";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, quest.getId());
            pst.setString(2, quest.getTitle());
            pst.setString(3, quest.getDescription());
            pst.setInt(4, quest.getCredit());

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public List<Quest> listAllQuests() {
        ResultSet resultSet = null;
        List<Quest> listQuests = new ArrayList<>();

        String sql = "SELECT * FROM quests";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                Quest quest = new Quest();

                quest.setId(resultSet.getInt("id"));
                quest.setTitle(resultSet.getString("title"));
                quest.setDescription(resultSet.getString("description"));
                quest.setCredit(resultSet.getInt("credit"));

                listQuests.add(quest);
            }
            return listQuests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void removeQuest(Quest quest) {
        String sql = "DELETE FROM quests WHERE id=?";
        try
                (Connection con = connection.connect();
                 PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, quest.getId());
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
