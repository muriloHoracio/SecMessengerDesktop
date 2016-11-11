/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.entity;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author murilo
 */
public class Conversation {
    private User user;
    private User contact;
    private List<Message> messages;

    public Conversation(User user, User contact, List<Message> messages) {
        this.user = user;
        this.contact = contact;
        this.messages = messages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getContact() {
        return contact;
    }

    public void setContact(User contact) {
        this.contact = contact;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.user);
        hash = 17 * hash + Objects.hashCode(this.contact);
        hash = 17 * hash + Objects.hashCode(this.messages);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conversation other = (Conversation) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.contact, other.contact)) {
            return false;
        }
        if (!Objects.equals(this.messages, other.messages)) {
            return false;
        }
        return true;
    }
}