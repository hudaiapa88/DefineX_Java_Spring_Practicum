package com.uc.weather.controller;

import com.uc.weather.model.FutureWeather;
import com.uc.weather.model.Weather;
import com.uc.weather.service.WeatherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("weather")
@RequiredArgsConstructor
@Validated
public class WeatherController {
    private final WeatherService weatherService;
    @GetMapping("/current")
    public ResponseEntity<Weather> getCurrent(@RequestBody @Valid WeatherRequest weatherRequest ){
        return ResponseEntity.ok(weatherService.getCurrent(weatherRequest));
    }
    @GetMapping("/future")
    public ResponseEntity<FutureWeather> getFuture(@RequestBody @Valid WeatherRequest weatherRequest, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @Future LocalDate future){
     return ResponseEntity.ok(weatherService.getFuture(weatherRequest,future));
    }
}
