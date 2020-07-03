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
import java.util.List;

@WebServlet(name = "update", urlPatterns = {"/update"}, loadOnStartup = 4)
public class UpdateMentor extends HttpServlet {
    final MentorDAO mentorDAO = new MentorJDBCDAO();

    private Mentor mentor;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        mentor = new Mentor(id, firstName, lastName, age);
        mentorDAO.updateUser(mentor);
        response.sendRedirect("list");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Mentor> listMentor = mentorDAO.listAllMentors();
        request.setAttribute("listMentor", listMentor);

        int id = Integer.parseInt(request.getParameter("id"));
        mentor = mentorDAO.selectMentor(id);
        request.setAttribute("mentorPut",mentor);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
}