
package com.miguelcr.a01_chatapp;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServerMessageResponse {

    @SerializedName("error")
    @Expose
    private boolean error;
    @SerializedName("messages")
    @Expose
    private List<Message> messages = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServerMessageResponse() {
    }

    /**
     * 
     * @param error
     * @param messages
     */
    public ServerMessageResponse(boolean error, List<Message> messages) {
        super();
        this.error = error;
        this.messages = messages;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public ServerMessageResponse withError(boolean error) {
        this.error = error;
        return this;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public ServerMessageResponse withMessages(List<Message> messages) {
        this.messages = messages;
        return this;
    }

}
