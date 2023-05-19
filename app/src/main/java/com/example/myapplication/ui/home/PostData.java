package com.example.myapplication.ui.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Date;

import lombok.Data;

@Data
public class PostData{
    @Expose
    @SerializedName("user")
    private String nickname;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("post_image")
    private String post_image;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("updateAt")
    private Date updatedAt;

    public String getNickname() {
            return nickname;
        }

    public void setNickname(String nickname) {
            this.nickname = nickname;
        }

    public String getTitle() {
            return title;
        }

    public void setTitle(String title) {
            this.title = title;
        }

    public String getPost_image() {
            return post_image;
        }

    public void setPost_image(String post_image) {
            this.post_image = post_image;
        }

    public String getStatus() {
            return status;
        }

    public void setStatus(String status) {
            this.status = status;
        }

    public Date getUpdatedAt() {
            return updatedAt;
        }

    public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }

    public PostData(String title, String nickname, String post_image) {
            super();
            this.nickname = nickname;
            this.title = title;
            this.post_image = post_image;
        }

}
