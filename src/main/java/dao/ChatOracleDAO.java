package dao;

import entities.*;

import javax.persistence.Query;
import java.util.List;

public class ChatOracleDAO extends ObjectDAO<Chat> {

    public Chat read(int id) {
        return em.find(Chat.class, id);
    }

    public void delete(Chat entity) {
        em.remove(read(entity.getChatID()));
    }

    public void showAll() {
        Query query = em.createNativeQuery("select * from CHATS", Chat.class);
        List<Chat> resultList = query.getResultList();
        System.out.println("Listing Chats:");
        for (Chat u : resultList) {
            System.out.println(u.toString());
        }
    }

}
