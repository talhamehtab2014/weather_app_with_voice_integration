package com.example.applicationweather.api_service;

import com.example.applicationweather.interfaces.ApiCallServices;

public class CreateService {
    public static ApiCallServices getNodeService() {
        return RetrofitClient.getClient().create(ApiCallServices.class);
    }
}
