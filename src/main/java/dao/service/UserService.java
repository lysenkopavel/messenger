package dao.service;

import entities.User;

import java.util.List;

public interface UserService extends EntityService<User> {

    void updateObjectFromDB(User user);

    void showAll();
}
