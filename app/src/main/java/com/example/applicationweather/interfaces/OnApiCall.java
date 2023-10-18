package com.example.applicationweather.interfaces;


import com.example.applicationweather.model.DModelWeather;

public interface OnApiCall<T> {
    void onSuccess(DModelWeather baseResponseModel);

    void onFail(String msg);
}
