package mydao.service;

import entities.Chat;
import entities.User;

import java.util.List;
import java.util.Set;

public interface UserService extends EntityService<User> {

    int create(String nickname);

    List<User> showAllUsers();

    Set<Chat> showUserChats(int uID);

}
