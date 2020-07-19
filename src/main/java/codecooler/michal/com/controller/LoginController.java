package codecooler.michal.com.controller;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.interfacedao.UserDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.dao.jdbc.UserJDBCDAO;
import codecooler.michal.com.model.Codecooler;

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
    private UserSQLConnection connection = new UserSQLConnection();
    private UserDAO userDAO = new UserJDBCDAO(connection);
    private CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);
    public static String userEmail;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Codecooler codecooler = null;
        HttpSession session = request.getSession();
        if(userDAO.checkIfUserExist(email,password)) {
            if(userDAO.getUserByEmailAndPassword(email, password).getIsAdmin().equals("codecooler")){
                Codecooler loginUser = new Codecooler(email);
                userEmail = loginUser.getEmail();

                codecooler = codecoolerDAO.getCodecoolerByEmail(email);
                session.setAttribute("codecooler",codecooler);
                response.sendRedirect("/ccprofile");
            } else if(userDAO.getUserByEmailAndPassword(email, password).getIsAdmin().equals("admin")){
                response.sendRedirect("/mentors");
            }
            else if(userDAO.getUserByEmailAndPassword(email, password).getIsAdmin().equals("mentor")) {
                response.sendRedirect("/mentorCodecoolerView");
            }

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
