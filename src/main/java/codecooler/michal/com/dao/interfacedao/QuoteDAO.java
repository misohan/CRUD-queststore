package codecooler.michal.com.dao.interfacedao;

import codecooler.michal.com.model.Quote;

public interface QuoteDAO {
    void createQuote(Quote quote);
    Quote getQuoteById(int id);
}
