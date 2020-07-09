package codecooler.michal.com.dao.jdbc;


import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.model.Mentor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MentorJDBCDAOTest {

    @Mock
    private UserSQLConnection userSQLConnection;
    @Mock
    private Connection connection;
    @Mock
    private PreparedStatement stmt;
    @Mock
    private ResultSet rs;
    private Mentor mentor;
    @Mock
    private MentorDAO mentorDAO = new MentorJDBCDAO(userSQLConnection);


    @Before
    public void setUp() throws Exception {
        assertNotNull(userSQLConnection);
        when(connection.prepareStatement(any(String.class))).thenReturn(stmt);
        when(userSQLConnection.connect()).thenReturn(connection);
        mentor = new Mentor();
        mentor.setId(1);
        mentor.setFirstName("A");
        mentor.setLastName("K");
        mentor.setAge(5);
        when(rs.first()).thenReturn(true);
        when(rs.getInt(1)).thenReturn(1);
        when(rs.getString(2)).thenReturn(mentor.getFirstName());
        when(rs.getString(3)).thenReturn(mentor.getLastName());
        when(stmt.executeQuery()).thenReturn(rs);
    }
    @Test(expected=IllegalArgumentException.class)
    public void nullCreateThrowsException() {
        mentorDAO.createMentor(mentor);
    }
    @Test
    public void createMentor() {
        mentorDAO.createMentor(mentor);
    }
    @Test
    public void createAndRetrieveMentor() throws Exception {
        Mentor retrieve = mentorDAO.getMentorById(1);
        assertEquals(mentor, retrieve);
    }
}
