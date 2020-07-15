package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Mentor;

import java.util.List;

public interface MentorDAO {
    Mentor createMentor(Mentor mentor);
    boolean updateMentor(int id, String firstName, String lastName, int age);
    List<Mentor> listAllMentors();
    void removeMentor(Mentor mentor);
    Mentor getMentorById(int id);
}
