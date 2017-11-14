package entities;

import java.util.Set;

public class Chat {

    private int chatID;
    private String chatTitle;
    private Set<User> usersInChat;


    public String getChatTitle() {
        return chatTitle;
    }

    public void setChatTitle(String chatTitle) {
        this.chatTitle = chatTitle;
    }

    public int getChatID() {
        return chatID;
    }

    public void setChatID(int chatID) {
        this.chatID = chatID;
    }

    public Set<User> getUsersInChat() {
        return usersInChat;
    }

    public void setUsersInChat(Set<User> usersInChat) {
        this.usersInChat = usersInChat;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(chatID);
        sb.append("\t'");
        sb.append(chatTitle);
        sb.append("' \t");
        for (User u : usersInChat) {
            sb.append(u.getUserID());
            sb.append(", ");
        }
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

}
