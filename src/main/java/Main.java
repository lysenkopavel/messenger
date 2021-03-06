import mydao.factory.DAOFactory;
import mydao.service.*;
import entities.*;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        DAOFactory daoObject = DAOFactory.getDAOFactory(DAOFactory.ORACLE_JPA);
        UserService userService = daoObject.getUserDAO();
        ChatService chatService = daoObject.getChatDAO();
        MessageService messageService = daoObject.getMessageService();

        int uid1 = userService.create("Roman");
        int uid2 = userService.create("Ivan");
        int uid3 = userService.create("Petr");
        int cid1 = chatService.create("First Chat");

        chatService.addUserToChat(userService.read(uid1), chatService.read(cid1));

        Chat chat = chatService.read(cid1);
        User userWithChat = userService.read(uid1);


        userService.showAllUsers();

//        Message m1 = new Message(u1, c1, "test text", new Date());
//        daoMessage.create(m1);
//        daoChat.refresh(m1.getMessageToChat());

    }

}
