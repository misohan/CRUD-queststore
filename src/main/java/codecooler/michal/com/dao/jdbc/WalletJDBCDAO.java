package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.WalletDAO;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Wallet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WalletJDBCDAO implements WalletDAO {
    private UserSQLConnection connection;

    public WalletJDBCDAO(UserSQLConnection connection) {
        this.connection = connection;
    }


    @Override
    public Wallet getWalletByEmail(String email) {
        ResultSet resultSet = null;
        Wallet wallet = new Wallet();

        String sql = "SELECT * FROM wallets WHERE email = ?" ;

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, email);
            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                wallet.setEmail(resultSet.getString("email"));
                wallet.setAccountBalance(resultSet.getInt("accountBalance"));
            }
            return wallet;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deductMoneyFromWallet(Artifact artifact) {

    }
}
