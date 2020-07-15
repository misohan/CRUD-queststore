package codecooler.michal.com.servlet.adminservlet.codecoolerservlet;

import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.model.Codecooler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCodecooler", urlPatterns = {"/deleteCodecooler"}, loadOnStartup = 3)
public class DeleteCodecooler extends HttpServlet {
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Codecooler codecooler = new Codecooler(id);
        codecoolerDAO.removeCodecooler(codecooler);
        response.sendRedirect("codecoolers");

    }
}
