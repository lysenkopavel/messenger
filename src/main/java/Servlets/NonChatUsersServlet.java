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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonChatUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringID = (String) request.getParameter("chatID");
        int chatID = Integer.parseInt(stringID);
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        Chat currentChat = chatService.read(chatID);

        UserService userService = (UserService) getServletContext().getAttribute("userService");
        List<User> users = userService.showAllUsers();
        Set<User> nonChatUsers = new HashSet<User>();
        for (User u : users) {
            Set<Chat> chats = u.getUserChats();
            if ((chats==null)||((!chats.contains(currentChat)))){
                nonChatUsers.add(u);
            }
        }
        request.setAttribute("nonChatUsers", nonChatUsers);
        request.setAttribute("currentChat", currentChat);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/NonChatUsersView.jsp");
        dispatcher.forward(request, response);
    }
}
