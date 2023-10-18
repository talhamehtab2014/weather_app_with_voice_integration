package com.example.applicationweather.api_service;

import android.content.Context;


import com.example.applicationweather.R;
import com.example.applicationweather.interfaces.OnApiTest;
import com.example.applicationweather.model.DModelWeather;
import com.example.applicationweather.utils.Constant;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {

    public ApiCall() {

    }

    public static void statusCode(int t) {
    }

    public static <T> void callApi(Call<T> call, final OnApiTest apiCall, final int i, Context context) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {

                if (i == Constant.RESPONSE_TYPE_DATA) {

                    if (response.isSuccessful()) {
                        apiCall.onSuccess(response);
                    } else {
                        apiCall.onFail(response.message());
                    }

                }
            }

            @Override
            public void onFailure(@NotNull Call<T> call, @NotNull Throwable t) {
                if (i == Constant.RESPONSE_TYPE_DATA) {
                    apiCall.onFail(t.getMessage() != null ? t.getMessage() : context.getString(R.string.something_went_wrong));
                }
            }
        });
    }
}
