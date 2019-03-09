package Servlets;

import entities.Chat;
import entities.User;
import mydao.service.ChatService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;


public class UsersInChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringID = (String) request.getParameter("chatID");
        int chatID = Integer.parseInt(stringID);
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        Chat currentChat = chatService.read(chatID);
//        Set<User> usersInChat = chatService.showChatUsers(chatID);
//        request.setAttribute("usersInChat", usersInChat);
        request.setAttribute("currentChat", currentChat);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/UsersInChatView.jsp");
        dispatcher.forward(request, response);
    }
}
