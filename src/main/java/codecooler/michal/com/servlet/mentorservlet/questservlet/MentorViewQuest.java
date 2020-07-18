package codecooler.michal.com.servlet.mentorservlet.questservlet;

import codecooler.michal.com.dao.interfacedao.QuestDAO;
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

@WebServlet(name = "mentorQuests", urlPatterns = {"/mentorQuests"}, loadOnStartup = 1)
public class MentorViewQuest extends HttpServlet {
    final QuestDAO QuestDAO = new QuestJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/mentor-quest-view.jsp");
        List<Quest> listQuests = QuestDAO.listAllQuests();

        request.setAttribute("listQuests", listQuests);
        dispatcher.forward(request, response);
    }
}