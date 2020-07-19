package codecooler.michal.com.servlet.codecoolerservlet.profileview;


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

@WebServlet(name = "ccprofile", urlPatterns = {"/ccprofile"}, loadOnStartup = 10)
public class CodecoolerProfileView extends HttpServlet {
    private UserSQLConnection connection = new UserSQLConnection();

    final QuestDAO QuestDAO = new QuestJDBCDAO(connection);
    final CodecoolerDAO codecoolerDAO = new CodecoolerJDBCDAO(connection);
    final WalletDAO walletDAO = new WalletJDBCDAO(connection);

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/codecooler-profile-view.jsp");

        String email = request.getParameter("email");

        Codecooler codecooler = codecoolerDAO.getCodecoolerByEmail(email);
        String userEmail = LoginController.userEmail;

        Wallet wallet = walletDAO.getWalletByEmail(userEmail);

        request.setAttribute("codecooler", codecooler);
        request.setAttribute("wallet", wallet);

        List<Quest> listQuests = QuestDAO.listAllQuests();
        request.setAttribute("listQuests", listQuests);

        List<Artifact> listArtifacts = codecoolerDAO.listCodecoolersArtifacts(userEmail);
        request.setAttribute("listArtifacts", listArtifacts);

        dispatcher.forward(request, response);
    }
}