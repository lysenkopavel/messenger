package Servlets;

import entities.User;
import mydao.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CreateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = (String) request.getParameter("nickname");
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        userService.create(nickname);
        response.sendRedirect(request.getContextPath() + "/users");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/CreateUserView.jsp");
        dispatcher.forward(request, response);
    }
}
