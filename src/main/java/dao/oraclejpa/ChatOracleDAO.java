package dao.oraclejpa;

import dao.service.ChatService;
import entities.*;

import javax.persistence.Query;
import java.util.List;

public class ChatOracleDAO extends OracleJpaDao<Chat> implements ChatService{

    public Chat read(int id) {
        return em.find(Chat.class, id);
    }

    public void delete(Chat entity) {
        em.getTransaction().begin();
        em.remove(read(entity.getChatID()));
        em.getTransaction().commit();
    }

    public void showAll() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("select * from CHATS", Chat.class);
        List<Chat> resultList = query.getResultList();
        System.out.println("Listing Chats:");
        for (Chat u : resultList) {
            System.out.println(u.toString());
        }
        em.getTransaction().commit();
    }


}
