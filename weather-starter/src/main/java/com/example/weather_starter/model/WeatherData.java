package com.example.weather_starter.model;

import java.time.LocalDateTime;

public class WeatherData {
    private String city;
    private double temperature;
    private String condition;
    private LocalDateTime timestamp;
    private double humidity;
    private double windSpeed;


    public WeatherData() {}

    public WeatherData(String city, double temperature, String condition, LocalDateTime timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.condition = condition;
        this.timestamp = timestamp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return String.format(
                "WeatherData{city='%s', temperature=%.1f, condition='%s', timestamp=%s}",
                city, temperature, condition, timestamp
        );
    }
}