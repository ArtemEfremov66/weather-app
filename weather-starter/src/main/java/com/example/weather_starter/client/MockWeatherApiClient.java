package com.example.weather_starter.client;

import com.example.weather_starter.model.Forecast;
import com.example.weather_starter.model.WeatherData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockWeatherApiClient implements WeatherApiClient {
    private static final Random random = new Random();

    @Override
    public WeatherData getCurrentWeather(String city) {
        return new WeatherData(
                city,
                random.nextInt(35) - 5, // от -5 до 30
                "mock-" + city,
                LocalDateTime.now()
        );
    }
    @Override
    public Forecast getForecast(String city, int days) {
        List<Forecast.DailyForecast> mockForecasts = IntStream.range(0, days)
                .mapToObj(i -> {
                    Forecast.DailyForecast df = new Forecast.DailyForecast();
                    df.setDate(LocalDate.now().plusDays(i));
                    df.setMaxTemp(ThreadLocalRandom.current().nextDouble(15, 30));
                    df.setMinTemp(ThreadLocalRandom.current().nextDouble(5, 15));
                    df.setCondition("Переменная облачность");
                    return df;
                })
                .collect(Collectors.toList());

        return new Forecast(city, LocalDate.now(), mockForecasts);
    }
}