package Servlets;

import mydao.service.ChatService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stringID = (String) request.getParameter("chatID");
        int id = Integer.parseInt(stringID);
        ChatService chatService = (ChatService) getServletContext().getAttribute("chatService");
        chatService.delete(id);
        response.sendRedirect(request.getContextPath() + "/chats");
    }
}
