package dao.service;

import entities.Chat;

public interface ChatService extends EntityService<Chat> {

    int create(String chatTitle);

    void showAllChats();

    void addUserToChat(int uID, int cID);

    void showChatUsers(int cID);

}
