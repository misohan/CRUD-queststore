package codecooler.michal.com.servlet.adminservlet.mentorservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", urlPatterns = {"/addMentor"}, loadOnStartup = 2)
public class AddMentor extends HttpServlet {
    private final UserSQLConnection connection = new UserSQLConnection();

    final MentorDAO mentorDAO = new MentorJDBCDAO(connection);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        Mentor mentor = new Mentor(id, firstName, lastName, age);
        mentorDAO.createMentor(mentor);
        response.sendRedirect("mentors");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-mentor-view.jsp");
        dispatcher.forward(request, response);
    }

}







