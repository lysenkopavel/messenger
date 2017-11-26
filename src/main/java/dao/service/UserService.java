package dao.service;

import entities.Chat;
import entities.User;

import java.util.List;

public interface UserService extends EntityService<User> {

    int create(String nickname);

    void showAllUsers();

    void addUserToChat(int uID, Chat chat);

    void deleteUserFromChat(int uID, Chat chat);

    void showUserChats(int uID);

}
