package com.insane.tellmeweather.models.weather.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class WeatherMainStats {

    @JsonProperty("temp")
    private double temperatureInKelwin;

    @JsonProperty("pressure")
    private double pressure;

    @JsonProperty("humidity")
    private double humidity;
}
