package servlets;

import dao.Database;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by azburatura on 7/29/2016.
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        String idUser = req.getParameter("id");
        if (idUser != null) {
            int id = Integer.parseInt(idUser);
            user = Database.getUser(id);
        }


        req.setAttribute("user", user);
        req.getRequestDispatcher("/User.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("userId"));
        String nume = req.getParameter("userName");
        String parola = req.getParameter("userPass");
        int varsta = Integer.parseInt(req.getParameter("userVarsta"));

        boolean created = Database.updateUser(id, nume, parola, varsta);
        if (created) {
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }

    }

}
