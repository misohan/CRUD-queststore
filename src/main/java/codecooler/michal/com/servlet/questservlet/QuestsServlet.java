package codecooler.michal.com.servlet.questservlet;

import codecooler.michal.com.dao.interfacedao.mentor.QuestDAO;
import codecooler.michal.com.dao.jdbc.QuestJDBCDAO;
import codecooler.michal.com.model.Quest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listQuests", urlPatterns = {"/quests"}, loadOnStartup = 1)
public class QuestsServlet extends HttpServlet {
    final QuestDAO QuestDAO = new QuestJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-quest-view.jsp");
        List<Quest> listQuests = QuestDAO.listAllQuests();

        request.setAttribute("listQuests", listQuests);
        dispatcher.forward(request, response);
    }
}