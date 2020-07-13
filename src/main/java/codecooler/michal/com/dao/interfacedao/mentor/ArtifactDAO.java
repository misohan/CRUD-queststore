
package codecooler.michal.com.dao.interfacedao.mentor;


import codecooler.michal.com.model.Artifact;

import java.util.List;

public interface ArtifactDAO {
    void createArtifact(Artifact artifact);
    List<Artifact> listAllArtifacts();
    void removeArtifact(Artifact artifact);
}