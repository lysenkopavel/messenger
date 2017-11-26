package mydao.jpaservice;

import mydao.service.ChatService;
import entities.*;

import javax.persistence.Query;
import java.util.List;

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

    public void delete(int entityID) {
        Chat c = read(entityID);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }

    public void showAllChats() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from CHATS", Chat.class);
        List<Chat> resultList = query.getResultList();
        System.out.println("Listing Chats:");
        if (!resultList.isEmpty()) {
            for (Chat c : resultList) {
                System.out.println(c.toString());
            }
        }
        em.getTransaction().commit();
    }

    //TODO
    public void addUserToChat(int uID, int cID) {

    }

    public void showChatUsers(int cID) {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from USERS_CHATS", "ShowUsersChatsMappingXml");
        List<Object[]> resultUsersChats = query.getResultList();
        System.out.println("Chat id" + cID + " users:");
        for (Object[] o : resultUsersChats) {
            Chat chat = (Chat) o[1];
            int chatID = chat.getChatID();
            if (cID == chatID) {
                User user = (User) o[0];
                int userID = user.getUserID();
                System.out.printf("%d, ", userID);
            }
        }
        System.out.println();
        em.getTransaction().commit();
    }


}
