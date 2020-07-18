package codecooler.michal.com.servlet.mentorservlet.questservlet;

import codecooler.michal.com.dao.interfacedao.QuestDAO;
import codecooler.michal.com.dao.jdbc.QuestJDBCDAO;
import codecooler.michal.com.model.Quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteMentorQuest", urlPatterns = {"/deleteMentorQuest"}, loadOnStartup = 3)
public class DeleteQuest extends HttpServlet {
    final QuestDAO questDAO = new QuestJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Quest quest = new Quest(id);
        questDAO.removeQuest(quest);
        response.sendRedirect("mentorQuests");

    }
}
