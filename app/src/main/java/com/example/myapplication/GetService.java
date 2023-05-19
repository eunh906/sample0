package com.example.myapplication;

import com.example.myapplication.ui.home.Post;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface GetService {
    @GET("posts")
    Call<List<Post>> getPosts();

    @Multipart
    @POST("posts")
    Call<ResponseBody> uploadPost(
            @Part("title") RequestBody title,
            @Part("content") RequestBody content,
            @Part MultipartBody.Part image
    );
}
