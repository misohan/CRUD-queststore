package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.User;

public interface UserDAO {
    User getUserByEmailAndPassword(String email, String password);
    boolean checkIfUserExist(String email, String password);
}