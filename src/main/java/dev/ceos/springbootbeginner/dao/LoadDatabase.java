package dev.ceos.springbootbeginner.dao;

import dev.ceos.springbootbeginner.model.Delivery;
import dev.ceos.springbootbeginner.model.DeliveryRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(DeliveryRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Delivery("서울시 송파구 루터회관 14층 우아한테크코스", "루피","삼계탕")));
            log.info("Preloading " + repository.save(new Delivery("서울시 송파구 루터회관 13층 우아한테크코스", "test","치킨")));
        };
    }
}