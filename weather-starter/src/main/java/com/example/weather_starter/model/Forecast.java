package com.example.weather_starter.model;

import java.time.LocalDate;
import java.util.List;

public class Forecast {
    private String city;
    private LocalDate date;
    private List<DailyForecast> dailyForecasts;


    public Forecast() {}

    public Forecast(String city, LocalDate date, List<DailyForecast> dailyForecasts) {
        this.city = city;
        this.date = date;
        this.dailyForecasts = dailyForecasts;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }


    // Вложенный класс для дневного прогноза
    public static class DailyForecast {
        private LocalDate date;
        private double maxTemp;
        private double minTemp;
        private String condition;


        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public double getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(double maxTemp) {
            this.maxTemp = maxTemp;
        }

        public double getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(double minTemp) {
            this.minTemp = minTemp;
        }

        public String getCondition() {
            return condition;
        }

        public void setCondition(String condition) {
            this.condition = condition;
        }
    }
}