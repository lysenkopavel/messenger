package entities;

import java.io.Serializable;

public class MessagePrimaryKey implements Serializable {

    private int userID;

    private int chatID;

    private int messageID;

    public MessagePrimaryKey(int userID, int chatID, int messageID) {
        this.userID = userID;
        this.chatID = chatID;
        this.messageID = messageID;
    }

    public MessagePrimaryKey() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagePrimaryKey that = (MessagePrimaryKey) o;

        if (userID != that.userID) return false;
        if (chatID != that.chatID) return false;
        return messageID == that.messageID;
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + chatID;
        result = 31 * result + messageID;
        return result;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }
}
