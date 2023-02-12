package com.uc.weather.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class WeatherRequest {
    @NotEmpty(message = "İl boş geçilemez")
    private String province;
    @NotEmpty(message = "İlçe boş geçilemez")
    private String district;
}
