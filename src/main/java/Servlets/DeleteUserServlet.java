package Servlets;

import mydao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringID = (String) request.getParameter("userID");
        int id = Integer.parseInt(stringID);
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        userService.delete(id);
        response.sendRedirect(request.getContextPath() + "/users");
    }
}
