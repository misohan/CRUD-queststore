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

@WebServlet(name = "addArtifact", urlPatterns = {"/addArtifact"}, loadOnStartup = 4)
public class AddArtifact extends HttpServlet {
    final ArtifactDAO ArtifactDAO = new ArtifactJDBCDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int credit = Integer.parseInt(request.getParameter("credit"));

        Artifact artifact = new Artifact(id, title, description, credit);
        ArtifactDAO.createArtifact(artifact);
        response.sendRedirect("artifacts");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin-artifact-view.jsp");
        dispatcher.forward(request, response);
    }

}







