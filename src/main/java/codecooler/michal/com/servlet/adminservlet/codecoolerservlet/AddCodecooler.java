package codecooler.michal.com.servlet.adminservlet.codecoolerservlet;

import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.model.Codecooler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCodecooler", urlPatterns = {"/addCodecooler"}, loadOnStartup = 6)
public class AddCodecooler extends HttpServlet {
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));

        Codecooler codecooler = new Codecooler(id, firstName, lastName, age);
        codecoolerDAO.createCodecooler(codecooler);
        response.sendRedirect("codecoolers");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-codecooler-view.jsp");
        dispatcher.forward(request, response);
    }

}







