package com.example.myapplication.ui.home;

public class Post {
    private String title;
    private String content;
    private String img;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.img = imageUrl;
    }
    public String getImageUrl() {
        return img;
    }
}

