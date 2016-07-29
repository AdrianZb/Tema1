package servlets;

import dao.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by azburatura on 7/29/2016.
 */
@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("hiddenUser"));
        boolean deleted = Database.deleteUser(id);

        if(deleted) {
            req.getRequestDispatcher("/Home.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
    }
}
