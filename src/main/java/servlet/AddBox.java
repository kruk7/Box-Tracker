package servlet;

import dao.DaoInterface;
import model.Box;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("addbox")
public class AddBox extends HttpServlet
{
    @Inject
    DaoInterface daoInterface;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Box box = new Box();
        box.setName(request.getParameter("boxName"));
        box.setSerial(Integer.parseInt(request.getParameter("boxSerial")));

        daoInterface.addBox(box);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
