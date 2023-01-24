package com.example.demo.service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Sinks;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final Sinks.Many<String> sink;

    public List<City> getAllCitiesWebSocket() {
        List<City> findAllCities = cityRepository.findAll();
        String allCities = findAllCities.toString();
        sink.emitNext(allCities, Sinks.EmitFailureHandler.FAIL_FAST);
        return findAllCities;
    }

    public List<City> getAllCities() {
        return getAllCitiesWebSocket();
    }

    public City createCity(City city) {
        city = cityRepository.save(city);
        getAllCitiesWebSocket();
        return city;
    }

}
