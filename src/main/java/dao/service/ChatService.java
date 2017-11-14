package dao.service;

import entities.Chat;

public interface ChatService extends EntityService<Chat> {

    void showAll();

    void updateObjectFromDB(Chat chat);

}
