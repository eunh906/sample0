package com.example.myapplication.ui.chat;

public class Chat {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String name;
    private String message;

    public Chat(String name, String message){
        this.name = name;
        this.message = message;
    }
}
