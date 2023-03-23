package com.example.myapplication.ui.chat;

public class Chatting {

    private String name;
    private String message;

    public Chatting(){
    }
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

    public Chatting(String name, String message){
        this.name = name;
        this.message = message;

    }
}
