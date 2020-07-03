import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.model.Codecooler;
import codecooler.michal.com.model.Mentor;

public class Main {
    public static void main(String[] args) {
        MentorDAO mentorDAO = new MentorJDBCDAO();

        mentorDAO.updateMentor(1, "Donal", "Pepeag", 27);

    }
}