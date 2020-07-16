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

@WebServlet("/login")
public class LogIn extends HttpServlet
{
    @Inject
    DaoInterface daoInterface;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        User user = daoInterface.getUserByLogin(username);

        if (user == null)
        {
            out.println("Sorry, this user doesn't exist!");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        } else if (user.getPassword().equals(password))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/main-page.jsp");
            rd.forward(request, response);
        } else
        {
            out.println("Sorry, invalid password!");
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.include(request, response);
        }

    }
}
