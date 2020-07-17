package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.UserDAO;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.User;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserJDBCDAO implements UserDAO {
    private UserSQLConnection connection;

    public UserJDBCDAO(UserSQLConnection connection) {
        this.connection = connection;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        try
                (Connection con = connection.connect();
                 PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
                ) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                String userEmail = rs.getString(1);
                String userPassword = rs.getString(2);
                String isAdmin = rs.getString(3);
                return new User(userEmail, userPassword, isAdmin);
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return null;
    }

    @Override
    public boolean checkIfUserExist(String email, String password) {
        try
                (Connection con = connection.connect();
                 PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");
                ) {
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(UserJDBCDAO.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
}
