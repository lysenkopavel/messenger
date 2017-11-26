package mydao.jpaservice;

import mydao.service.*;
import entities.*;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserOracleDAO extends OracleJpaDao<User> implements UserService {

    public int create(String nickname) {
        User user = new User(nickname);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user.getUserID();
    }

    public User read(int id) {
        em.getTransaction().begin();
        User u = em.find(User.class, id);
        em.getTransaction().commit();
        return u;
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void delete(int entityID) {
        User u = read(entityID);
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
    }

    public void showAllUsers() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS", User.class);
        List<User> resultList = query.getResultList();
        System.out.println("Listing Users:");
        if (!resultList.isEmpty()) {
            for (User u : resultList) {
                System.out.println(u.toString());
            }
        }
        em.getTransaction().commit();
    }

    public void showUserChats(int uID) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS_CHATS", "ShowUsersChatsMappingXml");
        List<Object[]> resultUsersChats = query.getResultList();
        System.out.println("Users id " + uID + " in chats:");
        for (Object[] res : resultUsersChats) {
            User user = (User) res[0];
            int userID = user.getUserID();
            if (uID == userID) {
                Chat chat = (Chat) res[1];
                int chatID = chat.getChatID();
                System.out.printf("%d, ", chatID);
            }
        }
        System.out.println();
        em.getTransaction().commit();
    }

    public void addUserToChat(int uID, Chat chat) {
        User u = read(uID);
        em.getTransaction().begin();
        Set<User> users = chat.getUsersInChat();
        if (users==null){
            users = new HashSet<User>();
        }
        users.add(u);
        chat.setUsersInChat(users);
        em.getTransaction().commit();
    }

    public void deleteUserFromChat(int uID, Chat chat) {
        User u = read(uID);
        em.getTransaction().begin();
        Set<Chat> userChats = u.getUserChats();
        userChats.remove(chat);
        em.getTransaction().commit();
    }


}
