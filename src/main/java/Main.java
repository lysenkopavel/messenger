import dao.factory.DAOFactory;
import dao.oraclejpa.OracleJpaDao;
import dao.service.ChatService;
import dao.service.EntityService;
import dao.service.UserService;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        DAOFactory daoObject = DAOFactory.getDAOFactory(DAOFactory.ORACLE_JPA);
        UserService daoUser = daoObject.getUserDAO();
        ChatService daoChat = daoObject.getChatDAO();

        User u1 = new User();
        User u2 = new User();
        User u3 = new User();
        u1.setNickname("Ivan");
        u2.setNickname("Petr");
        u3.setNickname("Max");

        Chat chat = new Chat();
        chat.setChatTitle("MyChat");

        Set<Chat> setChat = new HashSet<Chat>();
        setChat.add(chat);
        u1.setUserChats(setChat);
        u2.setUserChats(setChat);
        u3.setUserChats(setChat);

        daoChat.create(chat);
        daoUser.create(u1);
        daoUser.create(u2);
        daoUser.create(u3);
        daoChat.updateObjectFromDB(chat);
        daoUser.showAll();
        daoChat.showAll();
        System.out.println("----------------------------");
        u1.setUserChats(new HashSet<Chat>());
        daoUser.update(u1);
        daoChat.updateObjectFromDB(chat);
        daoUser.showAll();
        daoChat.showAll();

    }



}
