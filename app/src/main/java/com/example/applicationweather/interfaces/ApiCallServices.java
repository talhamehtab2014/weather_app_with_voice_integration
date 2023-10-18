package com.example.applicationweather.interfaces;

import com.example.applicationweather.model.DModelWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCallServices {
    @GET("/weather")
    Call<DModelWeather> requestGetWeatherInformation(@Query("location") String strLocation, @Query("format") String strFormat, @Query("u") char u);
}
