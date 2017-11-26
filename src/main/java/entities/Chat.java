package entities;

import java.io.Serializable;
import java.util.Set;

public class Chat implements Serializable {

    private int chatID;
    private String chatTitle;
    private Set<User> usersInChat;
    private Set<Message> chatMessages;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(chatID);
        sb.append("\t'");
        sb.append(chatTitle);
        sb.append("'");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 31;
        hash = prime * hash + chatID;
        hash = prime * hash + chatTitle.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Chat other = (Chat) obj;
        if (chatID != other.chatID)
            return false;
        if (!chatTitle.equals(other.chatTitle))
            return false;
        return true;
    }

    public Chat(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public Chat(String chatTitle, Set<User> usersInChat) {
        this.chatTitle = chatTitle;
        this.usersInChat = usersInChat;
    }

    public Chat(){

    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public Set<User> getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(Set<User> usersInChat) {
        this.usersInChat = usersInChat;
    }

    public Set<Message> getChatMessages() {
        return chatMessages;
    }

    public void setChatMessages(Set<Message> chatMessages) {
        this.chatMessages = chatMessages;
    }
}
