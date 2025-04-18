package com.example.weather_starter.metrics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //Аннотация доступна во время выполнения программы
@Target(ElementType.METHOD) //Только для методов
public @interface TrackMetric {
    String value() default "Track Metric";
    String description() default "";
    MetricType type() default MetricType.TIMER;

    enum MetricType {
        TIMER,    // Для измерения времени выполнения
        COUNTER,  // Для подсчёта вызовов
        GAUGE     // Для значений "здесь и сейчас" (температура и т.п.)
    }
}