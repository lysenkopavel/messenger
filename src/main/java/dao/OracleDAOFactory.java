package dao;

import entities.Chat;
import entities.User;

public class OracleDAOFactory extends DAOFactory {

    public ObjectDAO<User> getUserDAO() {
        return new UserOracleDAO();
    }

    public ObjectDAO<Chat> getChatDAO() {
        return new ChatOracleDAO();
    }

}
