package codecooler.michal.com.servlet.codecoolerservlet;

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
import java.util.List;

@WebServlet(name = "listCodecoolers", urlPatterns = {"/codecoolers"}, loadOnStartup = 5)
public class CodecoolerServlet extends HttpServlet {
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-codecooler-view.jsp");
        List<Codecooler> listCodecoolers = codecoolerDAO.listAllCodecoolers();

        request.setAttribute("listCodecoolers", listCodecoolers);
        dispatcher.forward(request, response);
    }
}