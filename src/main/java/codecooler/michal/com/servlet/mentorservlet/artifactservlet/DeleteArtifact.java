package codecooler.michal.com.servlet.mentorservlet.artifactservlet;

import codecooler.michal.com.dao.interfacedao.ArtifactDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.model.Artifact;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteMentorArtifact", urlPatterns = {"/deleteMentorArtifact"}, loadOnStartup = 4)
public class DeleteArtifact extends HttpServlet {
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Artifact artifact = new Artifact(id);
        artifactDAO.removeArtifact(artifact);
        response.sendRedirect("mentorArtifacts");
    }
}







