package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Mentor;

import java.util.List;

public interface MentorDAO {
    void createMentor(Mentor mentor);
    List<Mentor> listAllMentors();
    void removeMentor(Mentor mentor);
}
