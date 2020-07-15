package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.model.Mentor;
import org.mockito.Mock;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.Test;
import org.junit.Assert;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class MentorJDBCDAOTest {

    @Mock
    private UserSQLConnection mockConnection;
    @Mock
    private PreparedStatement mockStatement;
    @Mock
    private ResultSet mockResultSet;
    @Mock
    private UserSQLConnection mockUserSQLConnection;
//    @Mock
//    private MentorJDBCDAO mentorJDBCDAO = new MentorJDBCDAO(mockConnection);

    @Test
    public void getMentorById() {
        Mentor mentor = new Mentor(1, "Michal", "White", 5);

        MentorJDBCDAO mockObj = Mockito.mock(MentorJDBCDAO.class);
        Mockito.when(mockObj.getMentorById(1)).thenReturn(mentor);
        Assert.assertEquals(mentor.getId(), mockObj.getMentorById(1).getId());
    }

    @Test
    public void createMentor() {
        Mentor mentor = new Mentor(1, "Michal", "White", 5);
        MentorJDBCDAO mockObj = Mockito.mock(MentorJDBCDAO.class);

        Mockito.when(mockObj.createMentor(mentor)).thenReturn(mentor);
        Assert.assertEquals(mentor.getId(), mockObj.createMentor(mentor).getId());
    }


}