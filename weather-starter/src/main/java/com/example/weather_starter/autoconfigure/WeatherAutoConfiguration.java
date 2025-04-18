package com.example.weather_starter.autoconfigure;

import com.example.weather_starter.client.MockWeatherApiClient;
import com.example.weather_starter.client.WeatherApiClient;
import com.example.weather_starter.client.WebClientWeatherApiClient;
import com.example.weather_starter.metrics.WeatherMetricsPostProcessor;
import com.example.weather_starter.properties.WeatherProperties;
import com.example.weather_starter.service.WeatherService;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WeatherProperties.class) //Используем настройки из WeatherProperties
@ConditionalOnClass(WeatherService.class) //Бины создаются только наличии WeatherService в пути к классам
public class WeatherAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public WeatherApiClient weatherApiClient(WeatherProperties properties) {
        return properties.isMockEnabled()
                ? new MockWeatherApiClient()
                : new WebClientWeatherApiClient(properties);
    }

    @Bean
    public WeatherService weatherService(WeatherApiClient client) {
        return new WeatherService(client);
    }
    @Bean
    public WeatherMetricsPostProcessor metricsPostProcessor(MeterRegistry registry) {
        return new WeatherMetricsPostProcessor(registry);
    }
}
