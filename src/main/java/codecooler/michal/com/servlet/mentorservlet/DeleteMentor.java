package codecooler.michal.com.servlet.mentorservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"}, loadOnStartup = 3)
public class DeleteMentor extends HttpServlet {
    private UserSQLConnection connection;

    final MentorDAO mentorDAO = new MentorJDBCDAO(connection);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Mentor mentor = new Mentor(id);
        mentorDAO.removeMentor(mentor);
        response.sendRedirect("mentors");

    }
}







