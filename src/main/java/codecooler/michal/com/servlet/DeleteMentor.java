package codecooler.michal.com.servlet;

import codecooler.michal.com.dao.MentorDAO;
import codecooler.michal.com.dao.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "delete", urlPatterns = {"/delete"}, loadOnStartup = 3)
public class DeleteMentor extends HttpServlet {
    private MentorDAO mentorDAO = new MentorJDBCDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Mentor mentor = new Mentor(id);
        mentorDAO.removeUser(mentor);
        response.sendRedirect("list");

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
}







