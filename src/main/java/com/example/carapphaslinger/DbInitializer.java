package com.example.carapphaslinger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.List;

@Configuration
public class DbInitializer {
    @Autowired
    private CarRepository carRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void handleApplicationReady() {
        carRepository.saveAll(
                List.of(
                        new Car("Ford", "Mustang", 1964),
                        new Car("Seat", "Ibiza", 2020)
                )
        );
    }
}
