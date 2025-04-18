package com.example.weather_starter.client;

import com.example.weather_starter.model.Forecast;
import com.example.weather_starter.model.WeatherData;
import com.example.weather_starter.properties.WeatherProperties;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientWeatherApiClient implements WeatherApiClient {
    private final WebClient webClient;
    private final String apiKey;

    public WebClientWeatherApiClient(WeatherProperties props) {
        this.webClient = WebClient.builder()
                .baseUrl(props.getBaseUrl())
                .defaultHeader("Accept", "application/json")
                .build();
        this.apiKey = props.getApiKey();
    }

    @Override
    public WeatherData getCurrentWeather(String city) {
        return webClient.get()
                .uri("/current.json?key={key}&q={city}", apiKey, city)
                .retrieve()
                .bodyToMono(WeatherData.class)
                .block();
    }
    @Override
    public Forecast getForecast(String city, int days) {
        return webClient.get()
                .uri("/forecast.json?key={key}&q={city}&days={days}", apiKey, city, days)
                .retrieve()
                .bodyToMono(Forecast.class)
                .block();
    }
}