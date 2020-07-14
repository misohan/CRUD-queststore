package codecooler.michal.com.model;

public class Wallet {
    private int credit;
    private String artifact;

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public Wallet(int credit, String artifact) {
        this.credit = credit;
        this.artifact = artifact;
    }
}
