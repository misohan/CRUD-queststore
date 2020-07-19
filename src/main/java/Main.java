import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.*;
import codecooler.michal.com.dao.jdbc.*;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Codecooler;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.Quote;

public class Main {
    public static void main(String[] args) {

        UserSQLConnection connection = new UserSQLConnection();

        CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);

        ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

        WalletDAO walletDAO = new WalletJDBCDAO(connection);



        System.out.println(walletDAO.getWalletByEmail("a@a.com").getAccountBalance());




    }
}
