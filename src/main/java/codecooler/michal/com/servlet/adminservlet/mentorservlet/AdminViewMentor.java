package codecooler.michal.com.servlet.adminservlet.mentorservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.interfacedao.QuoteDAO;
import codecooler.michal.com.dao.interfacedao.UserDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.dao.jdbc.QuoteJDBCDAO;
import codecooler.michal.com.dao.jdbc.UserJDBCDAO;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.Quote;
import codecooler.michal.com.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listmentors", urlPatterns = {"/mentors"}, loadOnStartup = 1)
public class AdminViewMentor extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();
    private Random rand = new Random();

    final MentorDAO mentorDAO = new MentorJDBCDAO(connection);
    final QuoteDAO quoteDAO = new QuoteJDBCDAO(connection);
    final UserDAO userDAO = new UserJDBCDAO(connection);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-mentor-view.jsp");

        int randomInteger = rand.nextInt(4);
        Quote quote = quoteDAO.getQuoteById(randomInteger+1);
        request.setAttribute("quote", quote);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userDAO.getUserByEmailAndPassword(email, password);

        request.setAttribute("user", user);


        List<Mentor> listMentors = mentorDAO.listAllMentors();
        request.setAttribute("listMentors", listMentors);
        dispatcher.forward(request, response);
    }
}
