package codecooler.michal.com.servlet.codecoolerservlet.artifactservlet;


import codecooler.michal.com.UserSQLConnection;
import codecooler.michal.com.controller.LoginController;
import codecooler.michal.com.dao.interfacedao.*;
import codecooler.michal.com.dao.jdbc.*;
import codecooler.michal.com.model.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "artifactshop", urlPatterns = {"/artifactshop"}, loadOnStartup = 10)
public class CodecoolerArtifactView extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);
    final ArtifactDAO artifactDAO = new ArtifactJDBCDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/codecooler-artifact-view.jsp");
        List<Artifact> listArtifacts = artifactDAO.listAllArtifacts();
        request.setAttribute("listArtifacts", listArtifacts);
        dispatcher.forward(request, response);
    }
}
