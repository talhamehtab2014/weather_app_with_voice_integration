package com.example.applicationweather.interfaces;

import retrofit2.Response;

public interface OnApiTest<T> {
    void onSuccess(Response<T> response);

    void onFail(String msg);

}
