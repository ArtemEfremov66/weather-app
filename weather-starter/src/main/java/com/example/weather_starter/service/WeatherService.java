package com.example.weather_starter.service;

import com.example.weather_starter.client.WeatherApiClient;
import com.example.weather_starter.metrics.TrackMetric;
import com.example.weather_starter.model.Forecast;
import com.example.weather_starter.model.WeatherData;

public class WeatherService {
    private final WeatherApiClient client;

    public WeatherService(WeatherApiClient client) {
        this.client = client;
    }

    @TrackMetric(value = "weather.current", type = TrackMetric.MetricType.TIMER)
    public WeatherData getCurrentWeather(String city) {
        return client.getCurrentWeather(city);
    }

    @TrackMetric(value = "weather.forecast", type = TrackMetric.MetricType.TIMER)
    public Forecast getForecast(String city, int days) {
        return client.getForecast(city, days);
    }
}