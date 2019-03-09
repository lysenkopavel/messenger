package Servlets;

import entities.Chat;
import entities.User;
import mydao.service.ChatService;
import mydao.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChatsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        List<Chat> listChat = chatService.showAllChats();
        request.setAttribute("listChats", listChat);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ChatView.jsp");
        dispatcher.forward(request, response);
    }
}
