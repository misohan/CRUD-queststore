package codecooler.michal.com.servlet.codecoolerservlet.artifactservlet;

import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.controller.LoginController;
import codecooler.michal.com.dao.interfacedao.ArtifactDAO;
import codecooler.michal.com.dao.interfacedao.CodecoolerDAO;
import codecooler.michal.com.dao.jdbc.ArtifactJDBCDAO;
import codecooler.michal.com.dao.jdbc.CodecoolerJDBCDAO;
import codecooler.michal.com.model.Artifact;
import codecooler.michal.com.model.Codecooler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCCArtifact", urlPatterns = {"/addCCArtifact"}, loadOnStartup = 2)
public class AddArtifactCCView extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int artifactId = Integer.parseInt(request.getParameter("id"));

        Artifact artifact = artifactDAO.getArtifactById(artifactId);
        String artifactEmail = LoginController.userEmail;

        codecoolerDAO.addArtifactByCodecooler(artifactEmail, artifact.getId(), artifact.getTitle(), artifact.getDescription(), artifact.getCredit());
        response.sendRedirect("artifactshop");

    }

}
