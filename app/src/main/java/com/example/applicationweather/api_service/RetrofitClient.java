package com.example.applicationweather.api_service;

import com.example.applicationweather.utils.AppConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static OkHttpClient httpClient = null;


    public static Retrofit getClient() {
        if (retrofit == null) {
            httpClient = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .addInterceptor(chain -> {
                        Request request = chain.request().newBuilder()
                                .header("Accept", "application/json")
                                .header("X-RapidAPI-Key", AppConfig.getInstance().apiToken)
                                .header("X-RapidAPI-Host", AppConfig.getInstance().apiHost)
                                .build();
                        return chain.proceed(request);
                    }).build();

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConfig.getInstance().baseUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
