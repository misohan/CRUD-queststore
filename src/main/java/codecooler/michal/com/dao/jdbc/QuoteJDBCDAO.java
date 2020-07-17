package codecooler.michal.com.dao.jdbc;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.QuoteDAO;
import codecooler.michal.com.exception.DatabaseException;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.Quote;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuoteJDBCDAO implements QuoteDAO {
    private UserSQLConnection connection;

    public QuoteJDBCDAO(UserSQLConnection connection) {
        this.connection = connection;
    }

    @Override
    public void createQuote(Quote quote) {
        String sql = "INSERT INTO quotes (quotetext) " +
                "VALUES (?);";

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, quote.getQuoteText());

            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @Override
    public Quote getQuoteById(int id) {
        ResultSet resultSet = null;
        Quote quote = new Quote();

        String sql = "SELECT * FROM quotes WHERE id = " + id;

        try (Connection con = connection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {

            resultSet = pst.executeQuery();

            while (resultSet.next()) {

                quote.setQuoteId(resultSet.getInt("id"));
                quote.setQuoteText(resultSet.getString("quotetext"));


            }
            return quote;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
