package servlet;

import dao.DaoInterface;
import model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("adduser")
public class AddUser extends HttpServlet
{
    @Inject
    DaoInterface daoInterface;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setLogin(request.getParameter("password"));

        daoInterface.addUser(user);
    }
}
