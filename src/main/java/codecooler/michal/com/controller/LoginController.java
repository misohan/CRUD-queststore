package codecooler.michal.com.controller;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.interfacedao.UserDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.dao.jdbc.UserJDBCDAO;
import codecooler.michal.com.model.Codecooler;
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

            Codecooler codecooler1 = new Codecooler(1, "M", "B", 50, email);

            userEmail = codecooler1.getEmail();

            codecooler = codecoolerDAO.getCodecoolerByEmail(email);
            session.setAttribute("codecooler",codecooler);
            response.sendRedirect("/ccprofile");
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
