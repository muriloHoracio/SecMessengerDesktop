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
public class Contacts {
    private User user;
    private List<User> contacts;

    public Contacts(User user, List<User> contacts) {
        this.user = user;
        this.contacts = contacts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getContacts() {
        return contacts;
    }

    public void setContacts(List<User> contacts) {
        this.contacts = contacts;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.user);
        hash = 17 * hash + Objects.hashCode(this.contacts);
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
        final Contacts other = (Contacts) obj;
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.contacts, other.contacts)) {
            return false;
        }
        return true;
    }
}
