package mydao.service;

import entities.Chat;
import entities.User;

import java.util.List;
import java.util.Set;

public interface ChatService extends EntityService<Chat> {

    int create(String chatTitle);

    List<Chat> showAllChats();

    void addUserToChat(User user, Chat chat);

    void deleteUserFromChat(User user, Chat chat);

    void showUsersChats();

    Set<User> showChatUsers(int cID);


}
