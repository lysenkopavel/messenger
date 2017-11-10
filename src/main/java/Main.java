import dao.*;
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);

        DAOFactory daoObject = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
        ObjectDAO<User> daoUser = daoObject.getUserDAO();
        ObjectDAO<Chat> daoChat = daoObject.getChatDAO();

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

//        //TODO
//        Set<User> userSet = new HashSet<User>();
//        userSet.add(u1);
//        userSet.add(u2);
//        userSet.add(u3);
//        chat.setUsersInChat(userSet);

        ObjectDAO.beginTransaction();
//        daoChat.create(chat);
        daoUser.create(u1);
        daoUser.create(u2);
        daoUser.create(u3);
        daoUser.showAll();
//        daoChat.showAll();
        System.out.println("----------------------------");
//        u1.setUserChats(new HashSet<Chat>());
        daoUser.delete(u1);
        daoUser.showAll();
//        daoChat.showAll();
        ObjectDAO.commitTransaction();

    }

}
