package com.example.myapplication.ui.home;

public class Homeitem {

    private String name;
    private String text;
    private String title;
    private String date;

    public Homeitem(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getText() {return text;}
    public void setText(String text) {this.text = text;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public Homeitem(String name, String text, String title, String date){
        this.name = name;
        this.text = text;
        this.title = title;
        this.date = date;

    }
}
