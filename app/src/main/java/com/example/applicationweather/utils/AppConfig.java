package com.example.applicationweather.utils;

public class AppConfig {
    private static AppConfig instance;
    public String baseUrl;
    public String apiToken;
    public String apiHost;

    private AppConfig() {
        baseUrl = "https://yahoo-weather5.p.rapidapi.com";
        apiToken = "14401c8c42msha948169c308590cp16500cjsn75fd9b1a788b";
        apiHost = "yahoo-weather5.p.rapidapi.com";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
}
