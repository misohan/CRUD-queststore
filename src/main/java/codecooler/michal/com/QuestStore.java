package codecooler.michal.com;

import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.interfacedao.mentor.UserDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.dao.jdbc.UserJDBCDAO;
import codecooler.michal.com.model.Mentor;


public class QuestStore {
    public static void main(String[] args) {
//        MentorDAO mentorDAO = new MentorJDBCDAO();
//
//        Mentor mentor = new Mentor(7,"KAJO","All set", 5);
//
//        mentorDAO.createMentor(mentor);

        UserDAO userDAO = new UserJDBCDAO();

        userDAO.getByEmailAndPassword("darekczarek@codecool.pl", "abcd");

        MentorDAO mentorDAO = new MentorJDBCDAO();

        System.out.println(mentorDAO.listAllMentors());
    }
}
