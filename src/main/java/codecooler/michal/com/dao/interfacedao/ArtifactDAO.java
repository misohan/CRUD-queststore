package codecooler.michal.com.dao.interfacedao;


import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Codecooler;

import java.util.List;

public interface ArtifactDAO {
    void createArtifact(Artifact artifact);
    List<Artifact> listAllArtifacts();
    void removeArtifact(Artifact artifact);
    List<Artifact> listCodecoolersArtifacts(int id);
    Artifact getArtifactById(int id);
}
