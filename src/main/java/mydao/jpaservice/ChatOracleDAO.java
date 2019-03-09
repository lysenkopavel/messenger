package mydao.jpaservice;

import mydao.service.ChatService;
import entities.*;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChatOracleDAO extends OracleJpaDao<Chat> implements ChatService {

    public int create(String chatTitle) {
        Chat chat = new Chat(chatTitle);
        em.getTransaction().begin();
        em.persist(chat);
        em.getTransaction().commit();
        return chat.getChatID();
    }

    public Chat read(int id) {
        em.getTransaction().begin();
        Chat chat = em.find(Chat.class, id);
        em.getTransaction().commit();
        return chat;
    }

    public List<Chat> showAllChats() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from CHATS", Chat.class);
        List<Chat> resultList = query.getResultList();
//        System.out.println("Listing Chats:");
//        if (!resultList.isEmpty()) {
//            for (Chat c : resultList) {
//                System.out.println(c.toString());
//            }
//        }
        em.getTransaction().commit();
        return resultList;
    }

    public void addUserToChat(User user, Chat chat) {
        em.getTransaction().begin();
        Set<User> usersInChat = chat.getUsersInChat();
        if (usersInChat == null) {
            usersInChat = new HashSet<User>();
        }
        usersInChat.add(user);
        chat.setUsersInChat(usersInChat);
        em.getTransaction().commit();
    }

    public void deleteUserFromChat(User user, Chat chat) {
        em.getTransaction().begin();
        Set<User> usersInChat = chat.getUsersInChat();
        if (usersInChat != null) {
            usersInChat.remove(user);
            chat.setUsersInChat(usersInChat);
        }
        em.getTransaction().commit();
    }

    public void showUsersChats() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS_CHATS", "ShowUsersChatsMappingXml");
        List<Object[]> resultUsersChats = query.getResultList();
        System.out.println("userID   chatID");
        for (Object[] o : resultUsersChats) {
            int chatID = ((Chat) o[1]).getChatID();
            int userID = ((User) o[0]).getUserID();
            System.out.printf("%d\t%d\n", userID, chatID);
        }
        em.getTransaction().commit();
    }

    public Set<User> showChatUsers(int cID) {
        Chat chat = read(cID);
        return chat.getUsersInChat();
    }


}
