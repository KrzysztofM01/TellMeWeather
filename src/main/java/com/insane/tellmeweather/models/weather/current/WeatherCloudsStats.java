package com.insane.tellmeweather.models.weather.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class WeatherCloudsStats {

    @JsonProperty("all")
    private double percentageCloudiness;
}
