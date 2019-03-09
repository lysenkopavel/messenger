package entities;

import java.util.Date;

public class Message {

    private int messageID;
    private User messageFromUser;
    private Chat messageToChat;
    private String message;
    private Date messageTime;

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
//                ", messageFromUser=" + messageFromUser +
//                ", messageToChat=" + messageToChat +
                ", message='" + message + '\'' +
                ", messageTime=" + messageTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (messageID != message1.messageID) return false;
        if (!message.equals(message1.message)) return false;
        return messageTime.equals(message1.messageTime);
    }

    @Override
    public int hashCode() {
        int result = messageID;
        result = 31 * result + message.hashCode();
        result = 31 * result + messageTime.hashCode();
        return result;
    }

    public Message(User messageFromUser, Chat messageToChat, String message, Date messageTime) {
        this.messageFromUser = messageFromUser;
        this.messageToChat = messageToChat;
        this.message = message;
        this.messageTime = messageTime;
    }

    public Message(){

    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public User getMessageFromUser() {
        return messageFromUser;
    }

    public void setMessageFromUser(User messageFromUser) {
        this.messageFromUser = messageFromUser;
    }

    public Chat getMessageToChat() {
        return messageToChat;
    }

    public void setMessageToChat(Chat messageToChat) {
        this.messageToChat = messageToChat;
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
}
