package com.kpsoftwaresolutions.shafiqapplication.model;

/**
 * Created by zahid on 12/21/2017.
 */

public class Message {

    private String id;
    private String title;
    private String message;

    public Message(String id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }

    public Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
