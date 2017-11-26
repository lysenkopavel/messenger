package mydao.service;

import entities.Chat;
import entities.User;

public interface UserService extends EntityService<User> {

    int create(String nickname);

    void showAllUsers();

    void addUserToChat(int uID, Chat chat);

    void deleteUserFromChat(int uID, Chat chat);

    void showUserChats(int uID);

}
