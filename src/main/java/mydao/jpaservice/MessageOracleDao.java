package mydao.jpaservice;

import entities.Chat;
import entities.User;
import mydao.service.MessageService;
import entities.Message;

import java.util.Date;

public class MessageOracleDao extends OracleJpaDao<Message> implements MessageService {

    public Message read(int id) {
        em.getTransaction().begin();
        Message message = em.find(Message.class, id);
        em.getTransaction().commit();
        return message;
    }

    public void delete(int entityID) {

    }

    public int create(User user, Chat chat, String text, Date date) {
        Message message = new Message(user, chat, text, date);
        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
        return message.getMessageID();
    }

    public void showAllMessagesFromChat(int chatID) {

    }

    public void showAllUserMessagesFromChat() {

    }
}
