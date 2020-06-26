package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Codecooler;
import codecooler.michal.com.model.Mentor;

import java.util.List;

public interface CodecoolerDAO {
    void createCodecooler(Mentor mentor);
    List<Mentor> listAllCodecoolers();
    void removeCodecooler(Codecooler codecooler);
    void editCodecooler(Codecooler codecooler);
}
