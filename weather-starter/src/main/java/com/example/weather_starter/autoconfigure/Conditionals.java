package com.example.weather_starter.autoconfigure;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class Conditionals {
    public static class OnMockEnabled implements Condition {
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return "true".equalsIgnoreCase(
                    context.getEnvironment().getProperty("weather.mock-enabled")
            );
        }
    }
}