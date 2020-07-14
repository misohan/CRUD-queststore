package codecooler.michal.com.servlet.artifactservlet;

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

@WebServlet(name = "listartifacts", urlPatterns = {"/ccartifacts"}, loadOnStartup = 2)
public class ArtifactServlet extends HttpServlet {
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO() {
    };

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/codecooler-artifact-view");
        List<Artifact> listAllArtifacts = artifactDAO.listAllArtifacts();
        request.setAttribute("listArtifacts", listAllArtifacts);
        dispatcher.forward(request, response);
    }
}
