package codecooler.michal.com.model;

public class Quote {
    int quoteId;
    String quoteText;

    public Quote(String quoteText) {
        this.quoteText = quoteText;
    }

    public Quote(int quoteId, String quoteText) {
        this.quoteId = quoteId;
        this.quoteText = quoteText;
    }

    public Quote() {

    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }
}
