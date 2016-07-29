package servlets;

import dao.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by azburatura on 7/28/2016.
 */
@WebServlet("/add-user")
public class CreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nume = req.getParameter("numeUtilizator");
        String parola = req.getParameter("parolaUtilizator");
        int varsta = Integer.parseInt(req.getParameter("varstaUtilizator"));

        Database.addUser(nume, parola, varsta);

        req.getRequestDispatcher("/UserCreated.jsp").forward(req, resp);

    }
}
