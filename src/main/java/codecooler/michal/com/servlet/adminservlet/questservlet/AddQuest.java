package codecooler.michal.com.servlet.adminservlet.questservlet;

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

@WebServlet(name = "addQuest", urlPatterns = {"/addQuest"}, loadOnStartup = 6)
public class AddQuest extends HttpServlet {
    final QuestDAO questDAO = new QuestJDBCDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int credit = Integer.parseInt(request.getParameter("credit"));

        Quest quest = new Quest(id, title, description, credit);
        questDAO.createQuest(quest);
        response.sendRedirect("quests");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-quest-view.jsp");
        dispatcher.forward(request, response);
    }

}







