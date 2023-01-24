package com.example.demo.controller;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Sinks;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cities")
public class DemoController {

    private final CityService cityService;

    @QueryMapping
    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @MutationMapping
    @PostMapping
    public City createCity(@RequestBody @Argument City city) {
        return cityService.createCity(city);
    }

}
