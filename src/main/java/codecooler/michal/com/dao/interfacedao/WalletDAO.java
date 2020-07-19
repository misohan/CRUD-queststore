package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Wallet;

public interface WalletDAO {
    Wallet getWalletByEmail(String Email);
    void deductMoneyFromWallet(Artifact artifact);

}
