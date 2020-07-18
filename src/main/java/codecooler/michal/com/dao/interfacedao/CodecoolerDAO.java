package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Codecooler;
import codecooler.michal.com.model.Mentor;

import java.util.List;

public interface CodecoolerDAO {
    void createCodecooler(Codecooler codecooler);
    List<Codecooler> listAllCodecoolers();
    void removeCodecooler(Codecooler codecooler);
    void editCodecooler(Codecooler codecooler);
    Codecooler getCodecoolerByEmail(String email);
    boolean checkIfCodecoolerExists(String email);
    List<Artifact> listCodecoolersArtifacts(String email);
    void addArtifactByCodecooler(String email, int id, String title, String description, int credit);
}
