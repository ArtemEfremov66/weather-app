package com.example.weather_starter.client;

import com.example.weather_starter.model.Forecast;
import com.example.weather_starter.model.WeatherData;

public interface WeatherApiClient {
    WeatherData getCurrentWeather(String city);
    Forecast getForecast(String city, int days);
}
