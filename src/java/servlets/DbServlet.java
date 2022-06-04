package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import services.*;

@WebServlet(name = "DbServlet", urlPatterns = "/db")
public class DbServlet
        extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        switch(request.getParameter("method"))
        {
            case "dbReset" ->
            {
                DbService.deleteDbFile();
                DbService.createTables();
                response.sendRedirect("index.jsp");
            }
            case "dbSample" ->
            {
                DbService.deleteDbFile();
                DbService.createTables();
                DbService.makeSamples();
                response.sendRedirect("index.jsp");
            }
            default ->
                response.sendRedirect("index.jsp");
        }

    }
}
