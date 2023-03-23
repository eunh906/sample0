package com.example.myapplication.ui.home;

public class Home {
    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCharity() {return charity;}
    public void setCharity(String charity) {this.charity = charity;}
    private String title;
    private String content;
    private String charity;

    public Home(String title, String content, String charity){
        this.title = title;
        this.content = content;
        this.charity = charity;

    }
}
