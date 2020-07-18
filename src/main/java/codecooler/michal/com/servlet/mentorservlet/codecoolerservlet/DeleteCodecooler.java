package codecooler.michal.com.servlet.mentorservlet.codecoolerservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.model.Codecooler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCodecoolerMentorViewCodecooler", urlPatterns = {"/deleteCodecoolerMentorViewCodecooler"}, loadOnStartup = 3)
public class DeleteCodecooler extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();

    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Codecooler codecooler = new Codecooler(id);
        codecoolerDAO.removeCodecooler(codecooler);
        response.sendRedirect("mentorCodecoolerView");

    }
}
