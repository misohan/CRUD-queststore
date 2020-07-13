
package codecooler.michal.com.dao.interfacedao.mentor;

import codecooler.michal.com.model.Quest;

import java.util.List;

public interface QuestDAO {
    void createQuest(Quest quest);
    List<Quest> listAllQuests();
    void removeQuest(Quest quest);
}