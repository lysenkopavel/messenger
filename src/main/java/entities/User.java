package entities;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {

    private int userID;
    private String nickname;
    private Set<Chat> userChats;

    public Set<Chat> getUserChats() {
        return userChats;
    }

    public void setUserChats(Set<Chat> userChats) {
        this.userChats = userChats;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(userID);
        sb.append("\t'");
        sb.append(nickname);
        sb.append("' \t");
        for (Chat c:userChats){
            sb.append(c.getChatID());
        }
        return sb.toString();
    }


    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 31;
        hash = prime * hash + userID;
        hash = prime * hash + nickname.hashCode();
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
        final User other = (User) obj;
        if (userID != other.userID)
            return false;
        if (!nickname.equals(other.nickname))
            return false;
        return true;
    }

}
