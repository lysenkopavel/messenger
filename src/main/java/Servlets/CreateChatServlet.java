package Servlets;

import mydao.service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chatTitle = (String) request.getParameter("title");
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        chatService.create(chatTitle);
        response.sendRedirect(request.getContextPath() + "/chats");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/CreateChatView.jsp");
        dispatcher.forward(request, response);
    }
}
