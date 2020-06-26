import codecooler.michal.com.dao.interfacedao.ArtifactDAO;
import codecooler.michal.com.dao.interfacedao.QuestDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.dao.jdbc.QuestJDBCDAO;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Quest;

public class Main {
    public static void main(String[] args) {
        QuestDAO questDAO = new QuestJDBCDAO();
        ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

        Quest quest = new Quest(4,"New quest", "Fun workshop", 500);
        questDAO.createQuest(quest);
        Artifact artifact = new Artifact(4,"New quest", "Fun workshop", 800);
        artifactDAO.createArtifact(artifact);


    }
}
