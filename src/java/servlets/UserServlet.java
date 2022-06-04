package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import models.*;
import services.*;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet
        extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            List<User> users = UserService.findAll();
            request.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/showUsers.jsp");
            dispatcher.forward(request, response);
        } catch(SQLException e)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dberror.jsp");
            dispatcher.forward(request, response);
        } catch(Exception e)
        {
            PrintWriter writer = response.getWriter();
            writer.println("Извините, что-то пошло не так. Попробуйте ещё раз.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        switch(request.getParameter("method"))
        {
            case "delete" ->
                doDelete(request, response);
            case "add" ->
                doPut(request, response);
            case "update" ->
                doUpdate(request, response);
            default ->
                doGet(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        boolean result = UserService.delete(request.getParameter("id"));
        if(result)
        {
            doGet(request, response);
        } else
        {
            PrintWriter writer = response.getWriter();
            writer.println("Извините, удалить пользователя не удалось. Попробуйте ещё раз.");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try
        {
            User result = UserService.add(request.getParameter("email"), request.getParameter("name"));
            doGet(request, response);
        } catch(SQLException e)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/dberror.jsp");
            dispatcher.forward(request, response);
        } catch(Exception e)
        {
            PrintWriter writer = response.getWriter();
            writer.println("Извините, добавить пользователя не удалось. Попробуйте ещё раз.");
        }
    }

    protected void doUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        boolean result = UserService.update(request.getParameter("id"), request.getParameter("email"), request.getParameter("name"));
        if(result)
        {
            doGet(request, response);
        } else
        {
            PrintWriter writer = response.getWriter();
            writer.println("Извините, изменить пользователя не удалось. Попробуйте ещё раз.");
        }
    }
}
