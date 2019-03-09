package Servlets;

import entities.Chat;
import entities.User;
import mydao.service.ChatService;
import mydao.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserFromChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService) getServletContext().getAttribute("userService");
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");

        String stringID = (String) request.getParameter("chatID");
        int chatID = Integer.parseInt(stringID);
        stringID = (String) request.getParameter("userID");
        int userID = Integer.parseInt(stringID);

        User user = userService.read(userID);
        Chat chat = chatService.read(chatID);

        chatService.deleteUserFromChat(user,chat);
        response.sendRedirect(request.getContextPath() + "/usersInChat?chatID=" + chatID);

    }
}
