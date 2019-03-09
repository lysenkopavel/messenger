package mydao.jpaservice;

import entities.Chat;
import entities.User;
import mydao.service.MessageService;
import entities.Message;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class MessageOracleDao extends OracleJpaDao<Message> implements MessageService {

    public Message read(int id) {
        em.getTransaction().begin();
        Message message = em.find(Message.class, id);
        em.getTransaction().commit();
        return message;
    }

    public int create(User user, Chat chat, String text, Date date) {
        Message message = new Message(user, chat, text, date);
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
        return message.getMessageID();
    }

    public List<Message> showAllMessagesFromChat(int chatID) {
        em.getTransaction().begin();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from MESSAGES WHERE CHATID = ");
        sb.append(chatID);
        sb.append(" ORDER BY TIME DESC");
        String queryString = sb.toString();
        Query query = em.createNativeQuery(queryString, Message.class);
        List<Message> resultList = query.getResultList();
        em.getTransaction().commit();
        return resultList;
    }

}
