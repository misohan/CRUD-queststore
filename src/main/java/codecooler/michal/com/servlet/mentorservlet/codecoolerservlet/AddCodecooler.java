package codecooler.michal.com.servlet.mentorservlet.codecoolerservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.model.Codecooler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCCMentorViewCodecooler", urlPatterns = {"/addCCMentorViewCodecooler"}, loadOnStartup = 6)
public class AddCodecooler extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");

        Codecooler codecooler = new Codecooler(id, firstName, lastName, age, email);
        codecoolerDAO.createCodecooler(codecooler);
        response.sendRedirect("mentorCodecoolerView");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-codecooler-view.jsp");
        dispatcher.forward(request, response);
    }

}







