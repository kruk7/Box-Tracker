package servlet;

import dao.DaoInterface;
import model.User;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("adduser")
public class AddUser extends HttpServlet
{
    @Inject
    DaoInterface daoInterface;
    private String login;
    private String password;
    private String passwordRepeat;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        login = request.getParameter("login");
        password = request.getParameter("password");
        passwordRepeat = request.getParameter("password-repeat");
        PrintWriter out = response.getWriter();



        if (!(password.equals(passwordRepeat)))
        {
            out.println("Typed different passwords");
            RequestDispatcher rd = request.getRequestDispatcher("/sign-up.jsp");
            rd.include(request, response);
        }
        else if (daoInterface.ifUserExists(login))
        {
            out.println("This login already exist");
            RequestDispatcher rd = request.getRequestDispatcher("/sign-up.jsp");
            rd.include(request, response);
        }
        else
        {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);

            daoInterface.addUser(user);
            System.out.println("User add succesfull");
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }

    }
}
