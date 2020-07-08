package codecooler.michal.com.servlet.mentorservlet;

import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listmentors", urlPatterns = {"/mentors"}, loadOnStartup = 1)
public class MentorsServlet extends HttpServlet {
    final MentorDAO mentorDAO = new MentorJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-mentor-view.jsp");
        List<Mentor> listMentors = mentorDAO.listAllMentors();
        request.setAttribute("listMentors", listMentors);
        dispatcher.forward(request, response);
    }
}
