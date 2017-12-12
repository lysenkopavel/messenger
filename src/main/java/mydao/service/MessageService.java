package mydao.service;

import entities.Chat;
import entities.Message;
import entities.User;

import java.util.Date;
import java.util.List;

public interface MessageService extends EntityService<Message> {

    int create(User user, Chat chat, String text, Date date);

    List<Message> showAllMessagesFromChat(int chatID);


}
