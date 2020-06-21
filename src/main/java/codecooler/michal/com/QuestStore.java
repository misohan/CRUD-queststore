package codecooler.michal.com;

import codecooler.michal.com.dao.MentorDAO;
import codecooler.michal.com.dao.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;


public class QuestStore {
    public static void main(String[] args) {
        MentorDAO mentorDAO = new MentorJDBCDAO();

        Mentor mentor = new Mentor(7,"KAJO","All set", 5);

        mentorDAO.createMentor(mentor);
    }
}
