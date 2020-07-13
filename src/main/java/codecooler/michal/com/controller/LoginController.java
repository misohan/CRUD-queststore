package codecooler.michal.com.controller;

import codecooler.michal.com.dao.interfacedao.mentor.UserDAO;
import codecooler.michal.com.dao.jdbc.UserJDBCDAO;
import codecooler.michal.com.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginController extends HttpServlet {
    UserDAO userDAO = new UserJDBCDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
        HttpSession session = request.getSession();
        if(userDAO.checkIfUserExist(email,password)) {
            user = userDAO.getByEmailAndPassword(email, password);
            session.setAttribute("user",user);
            response.sendRedirect("/mentors");
        }else{
            request.setAttribute("message","Wrong credential");
            response.sendRedirect("/login");
        };

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}