package com.meetApp.meetappandroid.model;

import android.content.Context;

import com.meetApp.meetappandroid.api.MeetApi;
import com.meetApp.meetappandroid.api.MeetApiInterface;
import com.meetApp.meetappandroid.contract.MessageListContract;
import com.meetApp.meetappandroid.domain.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageListModel implements MessageListContract.Model {

    private Context context;

    public MessageListModel(Context context){
        this.context =context;
    }
    @Override
    public void loadAllMessages(OnLoadMessagesListener listener) {
        MeetApiInterface api = MeetApi.buildInstance();
        Call<List<Message>> callMessages = api.getMessages();
        callMessages.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                List<Message> products = response.body();
                listener.onLoadMessagesSuccess(products);
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
                listener.onLoadMessagesError("Se ha producido un error al conectar con el servidor");
                t.printStackTrace();
            }
        });

    }
}
