package servlet;

import dao.DaoInterface;
import model.Coordinates;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet("addcoordintes")
public class AddCoordinates extends HttpServlet
{
    @Inject
    DaoInterface daoInterface;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(Double.valueOf(request.getParameter("latitude")));
        coordinates.setLongitude(Double.valueOf(request.getParameter("longitude")));
        coordinates.setTimestamp(timestamp);

        daoInterface.addCoordinates(coordinates);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
