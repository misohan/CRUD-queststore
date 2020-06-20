package codecooler.michal.com.servlet;

import codecooler.michal.com.dao.MentorDAO;
import codecooler.michal.com.dao.MentorJDBCDAO;
import codecooler.michal.com.model.Mentor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "liststudents", urlPatterns = {"/list"}, loadOnStartup = 1)
public class Mentors extends HttpServlet {
    private MentorDAO mentorDAO = new MentorJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
        List<Mentor> listMentor = mentorDAO.litAllMentors();
        request.setAttribute("listMentor", listMentor);
        dispatcher.forward(request, response);



    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        String id = request.getParameter(request.getParameter("id"));
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String age = request.getParameter(request.getParameter("age"));
//
//        Mentor mentor = new Mentor(id);
//        mentorDAO.createMentor(mentor);
//        response.sendRedirect("list");
//
//
//    }

    public void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Mentor> listMentor = mentorDAO.litAllMentors();
        request.setAttribute("listMentor", listMentor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("MentorForm.jsp");
        dispatcher.forward(request, response);
    }

//    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Mentor existingBook = (id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
//        request.setAttribute("book", existingBook);
//        dispatcher.forward(request, response);
//
//    }
//
//    private void insertMentor(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        Mentor mentor = new Mentor(id, firstname, lastname, age);
//        mentorDAO.createMentor(mentor);
//        response.sendRedirect("list");
//    }


}
