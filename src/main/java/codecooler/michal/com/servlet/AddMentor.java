package codecooler.michal.com.servlet;

import codecooler.michal.com.UserSQLConnection;
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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "add", urlPatterns = {"/add"}, loadOnStartup = 2)
public class AddMentor extends HttpServlet {
    private MentorDAO mentorDAO = new MentorJDBCDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        Mentor mentor = new Mentor(id, firstName, lastName, age);
        mentorDAO.createMentor(mentor);
        response.sendRedirect("list");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        dispatcher.forward(request, response);
    }
}







