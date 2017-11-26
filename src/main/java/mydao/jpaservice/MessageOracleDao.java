package mydao.jpaservice;

import mydao.service.MessageService;
import entities.Message;

public class MessageOracleDao  extends OracleJpaDao<Message> implements MessageService {

    public Message read(int id) {
        return null;
    }

    public void delete(int entityID) {

    }
}
