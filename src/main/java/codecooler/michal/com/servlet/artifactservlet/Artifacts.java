package codecooler.michal.com.servlet.artifactservlet;

import codecooler.michal.com.dao.interfacedao.mentor.ArtifactDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.model.Artifact;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listartifacts", urlPatterns = {"/artifacts"}, loadOnStartup = 1)
public class Artifacts extends HttpServlet {
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-artifact-view.jsp");
        List<Artifact> listArtifacts = artifactDAO.listAllArtifacts();

        request.setAttribute("listArtifacts", listArtifacts);
        dispatcher.forward(request, response);
    }
}