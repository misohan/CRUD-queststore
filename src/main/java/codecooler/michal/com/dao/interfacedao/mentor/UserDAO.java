package codecooler.michal.com.dao.interfacedao.mentor;

import codecooler.michal.com.model.User;

public interface UserDAO {
    User getByEmailAndPassword(String email, String password);
    boolean checkIfUserExist(String email, String password);
}
