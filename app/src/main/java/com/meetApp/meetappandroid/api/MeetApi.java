package com.meetApp.meetappandroid.api;

import static com.meetApp.meetappandroid.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MeetApi {

    public static MeetApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MeetApiInterface.class);
    }
}
