package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.model.Mentor;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.Assert;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MentorJDBCDAOTest {

    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSet;
    @Mock
    private UserSQLConnection mockUserSQLConnection;

    private MentorJDBCDAO mentorJDBCDAO = new MentorJDBCDAO(mockUserSQLConnection);


    @Before
    public void setUp() throws Exception{
        mentorJDBCDAO = new MentorJDBCDAO(mockUserSQLConnection);
    }


    @Test
    public void should_return_mentor_by_id() throws SQLException {
        //given:
        Mentor mentor = new Mentor(1, "Michal", "White", 27);
        when(mockUserSQLConnection.connect()).thenReturn(connection);
        when(connection.prepareStatement("SELECT*FROM mentors")).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true);
        when(resultSet.getInt("id")).thenReturn(1);
        when(resultSet.getString("firtname")).thenReturn("Michal");
        when(resultSet.getInt("age")).thenReturn(5);
        when(resultSet.next()).thenReturn(false);


        //when:
        Mentor result = mentorJDBCDAO.getMentorById(1);

        //then:
        Assert.assertEquals(mentor.getId(), result.getId());
    }




}