package com.example.applicationweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class DModelWeather {

    private Location location;
    private Current_observation current_observation;
    private List<Forecasts> forecasts;

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current_observation getCurrent_observation() {
        return this.current_observation;
    }

    public void setCurrent_observation(Current_observation current_observation) {
        this.current_observation = current_observation;
    }

    public List<Forecasts> getForecasts() {
        return this.forecasts;
    }

    public void setForecasts(List<Forecasts> forecasts) {
        this.forecasts = forecasts;
    }

    public class Location {
        private String city;

        private int woeid;

        private String country;

        private double lat;

        @SerializedName("long")
        private double longg;

        private String timezone_id;

        public String getCity() {
            return this.city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getWoeid() {
            return this.woeid;
        }

        public void setWoeid(int woeid) {
            this.woeid = woeid;
        }

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public double getLat() {
            return this.lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public void setLong(double longg) {
            this. longg =longg ;
        }

        public double getLong() {
            return this. longg ;
        }

        public String getTimezone_id() {
            return this.timezone_id;
        }

        public void setTimezone_id(String timezone_id) {
            this.timezone_id = timezone_id;
        }
    }

    public class Wind {
        private int chill;

        private String direction;

        private int speed;

        public int getChill() {
            return this.chill;
        }

        public void setChill(int chill) {
            this.chill = chill;
        }

        public String getDirection() {
            return this.direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public int getSpeed() {
            return this.speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }

    public class Atmosphere {
        private double humidity;

        private double visibility;

        private double pressure;

        public double getHumidity() {
            return this.humidity;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public double getVisibility() {
            return this.visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public double getPressure() {
            return this.pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }
    }

    public class Astronomy {
        private String sunrise;

        private String sunset;

        public String getSunrise() {
            return this.sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return this.sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }
    }

    public class Condition {
        private int temperature;

        private String text;

        private int code;

        public int getTemperature() {
            return this.temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    public class Current_observation {
        private long pubDate;

        private Wind wind;

        private Atmosphere atmosphere;

        private Astronomy astronomy;

        private Condition condition;

        public long getPubDate() {
            return this.pubDate;
        }

        public void setPubDate(long pubDate) {
            this.pubDate = pubDate;
        }

        public Wind getWind() {
            return this.wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }

        public Atmosphere getAtmosphere() {
            return this.atmosphere;
        }

        public void setAtmosphere(Atmosphere atmosphere) {
            this.atmosphere = atmosphere;
        }

        public Astronomy getAstronomy() {
            return this.astronomy;
        }

        public void setAstronomy(Astronomy astronomy) {
            this.astronomy = astronomy;
        }

        public Condition getCondition() {
            return this.condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }
    }

    public class Forecasts {
        private String day;

        private int date;

        private int high;

        private int low;

        private String text;

        private int code;

        public String getDay() {
            return this.day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getDate() {
            return this.date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getHigh() {
            return this.high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public int getLow() {
            return this.low;
        }

        public void setLow(int low) {
            this.low = low;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getCode() {
            return this.code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
