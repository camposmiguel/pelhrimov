
package com.miguelcr.a01_chatapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("idMessage")
    @Expose
    private String idMessage;
    @SerializedName("textMessage")
    @Expose
    private String textMessage;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("time")
    @Expose
    private String time;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Message() {
    }

    /**
     * 
     * @param idMessage
     * @param time
     * @param textMessage
     * @param user
     */
    public Message(String idMessage, String textMessage, String user, String time) {
        super();
        this.idMessage = idMessage;
        this.textMessage = textMessage;
        this.user = user;
        this.time = time;
    }

    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public Message withIdMessage(String idMessage) {
        this.idMessage = idMessage;
        return this;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Message withTextMessage(String textMessage) {
        this.textMessage = textMessage;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Message withUser(String user) {
        this.user = user;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Message withTime(String time) {
        this.time = time;
        return this;
    }

}
