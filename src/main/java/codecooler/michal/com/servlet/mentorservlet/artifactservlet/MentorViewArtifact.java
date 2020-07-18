package codecooler.michal.com.servlet.mentorservlet.artifactservlet;

import codecooler.michal.com.dao.interfacedao.ArtifactDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.model.Artifact;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mentorArtifacts", urlPatterns = {"/mentorArtifacts"}, loadOnStartup = 1)
public class MentorViewArtifact extends HttpServlet {
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/mentor-artifact-view.jsp");
        List<Artifact> listArtifacts = artifactDAO.listAllArtifacts();

        request.setAttribute("listArtifacts", listArtifacts);
        dispatcher.forward(request, response);
    }
}