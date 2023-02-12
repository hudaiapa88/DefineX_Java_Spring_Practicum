package com.uc.weather.service;

import com.uc.weather.controller.WeatherRequest;
import com.uc.weather.model.FutureWeather;
import com.uc.weather.model.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherApiService weatherApiService;

    public Weather getCurrent(WeatherRequest weatherRequest) {
        String q = weatherRequest.getProvince()
                + " " +
                weatherRequest.getDistrict();
        return weatherApiService.getCurrent(q);
    }

    public FutureWeather getFuture(WeatherRequest weatherRequest, LocalDate future) {
        String q = weatherRequest.getProvince()
                + " " +
                weatherRequest.getDistrict();
        return weatherApiService.getFuture(q,future);
    }
}
