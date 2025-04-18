package com.example.weather_starter.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Method;
import java.util.Arrays;

public class WeatherMetricsPostProcessor implements BeanPostProcessor {
    private final MeterRegistry registry;

    public WeatherMetricsPostProcessor(MeterRegistry registry) {
        this.registry = registry;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Arrays.stream(bean.getClass().getMethods())
                .filter(method -> method.isAnnotationPresent(TrackMetric.class))
                .forEach(method -> registerMetrics(bean, method));
        return bean;
    }

    private void registerMetrics(Object bean, Method method) {
        TrackMetric annotation = method.getAnnotation(TrackMetric.class);
        String metricName = annotation.value().isEmpty()
                ? "weather." + method.getName()
                : annotation.value();

        switch (annotation.type()) {
            case TIMER -> Timer.builder(metricName)
                    .description("Execution time of " + method.getName())
                    .register(registry)
                    .record(() -> {
                        try {
                            method.invoke(bean);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
            case COUNTER -> Counter.builder(metricName)
                    .description("Count of " + method.getName() + " calls")
                    .register(registry)
                    .increment();
            case GAUGE -> Gauge.builder(metricName, bean, b -> {
                try {
                    return (double) method.invoke(b);
                } catch (Exception e) {
                    return 0;
                }
            }).register(registry);
        }
    }
}