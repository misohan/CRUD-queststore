package codecooler.michal.com.servlet.codecoolerservlet;


import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.dao.interfacedao.ArtifactDAO;
import codecooler.michal.com.dao.interfacedao.MentorDAO;
import codecooler.michal.com.dao.interfacedao.QuestDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.dao.jdbc.MentorJDBCDAO;
import codecooler.michal.com.dao.jdbc.QuestJDBCDAO;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Mentor;
import codecooler.michal.com.model.Quest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "w", urlPatterns = {"/ccprofile"}, loadOnStartup = 10)
public class CodecoolerViewProfile extends HttpServlet {
    final QuestDAO QuestDAO = new QuestJDBCDAO();
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/codecooler-profile-view.jsp");

        List<Quest> listQuests = QuestDAO.listAllQuests();
        request.setAttribute("listQuests", listQuests);

        List<Artifact> listArtifacts = artifactDAO.listAllArtifacts();
        request.setAttribute("listArtifacts", listArtifacts);

        dispatcher.forward(request, response);
    }
}