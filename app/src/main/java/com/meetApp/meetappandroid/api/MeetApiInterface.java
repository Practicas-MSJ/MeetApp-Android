package com.meetApp.meetappandroid.api;

import com.meetApp.meetappandroid.domain.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MeetApiInterface {

    @GET("messages")
    Call<List<Message>> getMessages();

    @GET("messages/{messageId}")
    Call<Message> getMessage(@Path("messageId") long messageId);

    @POST("messages")
    Call<Message> addMessage(@Body Message message);
}
