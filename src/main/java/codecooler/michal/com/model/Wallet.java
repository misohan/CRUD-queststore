package codecooler.michal.com.model;

public class Wallet {
    private String email;
    private int accountBalance;

    public Wallet(String email) {
        this.email = email;
    }

    public Wallet() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
}
