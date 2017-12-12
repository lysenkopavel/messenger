package Servlets;

import entities.Chat;
import entities.Message;
import entities.User;
import mydao.service.ChatService;
import mydao.service.MessageService;
import mydao.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OpenChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MessageService messageService = (MessageService) getServletContext().getAttribute("messageService");
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        UserService userService = (UserService) getServletContext().getAttribute("userService");

        String messageText = (String) request.getParameter("newMessage");

        String stringID = (String) request.getParameter("chatID");
        int chatID = Integer.parseInt(stringID);
        Chat currentChat = chatService.read(chatID);

        String stringUserID = (String) request.getParameter("chooseUser");
        int userID = Integer.parseInt(stringUserID);
        User user = userService.read(userID);

        messageService.create(user, currentChat, messageText, new Date());

        response.sendRedirect(request.getContextPath() + "/openChat?chatID=" + chatID);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringID = (String) request.getParameter("chatID");
        int chatID = Integer.parseInt(stringID);
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        Chat currentChat = chatService.read(chatID);
        Set<User> usersInChat = currentChat.getUsersInChat();

        MessageService messageService = (MessageService) getServletContext().getAttribute("messageService");
        List<Message> messagesInChat = messageService.showAllMessagesFromChat(chatID);

        request.setAttribute("currentChat", currentChat);
        request.setAttribute("usersInChat", usersInChat);
        request.setAttribute("messagesInChat", messagesInChat);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/OpenChatView.jsp");
        dispatcher.forward(request, response);
    }
}
