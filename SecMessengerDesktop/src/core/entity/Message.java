/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.entity;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author murilo
 */
public class Message {
    private GregorianCalendar time;
    private User sender;
    private String senderPublicKey;
    private User receiver;
    private String receiverPublicKey;
    private String message;

    public Message(GregorianCalendar time, User sender, String senderPublicKey, User receiver, String receiverPublicKey, String message) {
        this.time = time;
        this.sender = sender;
        this.senderPublicKey = senderPublicKey;
        this.receiver = receiver;
        this.receiverPublicKey = receiverPublicKey;
        this.message = message;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public void setTime(GregorianCalendar time) {
        this.time = time;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getSenderPublicKey() {
        return senderPublicKey;
    }

    public void setSenderPublicKey(String senderPublicKey) {
        this.senderPublicKey = senderPublicKey;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getReceiverPublicKey() {
        return receiverPublicKey;
    }

    public void setReceiverPublicKey(String receiverPublicKey) {
        this.receiverPublicKey = receiverPublicKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.time);
        hash = 97 * hash + Objects.hashCode(this.sender);
        hash = 97 * hash + Objects.hashCode(this.senderPublicKey);
        hash = 97 * hash + Objects.hashCode(this.receiver);
        hash = 97 * hash + Objects.hashCode(this.receiverPublicKey);
        hash = 97 * hash + Objects.hashCode(this.message);
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
        final Message other = (Message) obj;
        if (!Objects.equals(this.senderPublicKey, other.senderPublicKey)) {
            return false;
        }
        if (!Objects.equals(this.receiverPublicKey, other.receiverPublicKey)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.sender, other.sender)) {
            return false;
        }
        if (!Objects.equals(this.receiver, other.receiver)) {
            return false;
        }
        return true;
    }
}
