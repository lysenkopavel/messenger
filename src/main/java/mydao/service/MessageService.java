package mydao.service;

import entities.Chat;
import entities.Message;
import entities.User;

import java.util.Date;

public interface MessageService extends EntityService<Message> {

    int create(User user, Chat chat, String text, Date date);

    void showAllMessagesFromChat(int chatID);

    void showAllUserMessagesFromChat();


}
