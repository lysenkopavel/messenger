package entities;

import java.util.Date;

public class Message {

    private MessagePrimaryKey messID;

    private String message;

    private Date messageTime;

    public MessagePrimaryKey getMessID() {
        return messID;
    }

    public void setMessID(MessagePrimaryKey messID) {
        this.messID = messID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (!messID.equals(message1.messID)) return false;
        if (!message.equals(message1.message)) return false;
        return messageTime.equals(message1.messageTime);
    }

    @Override
    public int hashCode() {
        int result = messID.hashCode();
        result = 31 * result + message.hashCode();
        result = 31 * result + messageTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messID=" + messID +
                ", message='" + message + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }
}
