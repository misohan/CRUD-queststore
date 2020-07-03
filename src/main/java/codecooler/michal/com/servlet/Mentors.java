package codecooler.michal.com.servlet;

import codecooler.michal.com.dao.MentorDAO;
import codecooler.michal.com.dao.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listmentors", urlPatterns = {"/list"}, loadOnStartup = 1)
public class Mentors extends HttpServlet {
    final MentorDAO mentorDAO = new MentorJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Mentor mentor = new Mentor("","");
        List<Mentor> listMentor = mentorDAO.listAllMentors();
        request.setAttribute("listMentor", listMentor);
        request.setAttribute("mentorPut", mentor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
}
