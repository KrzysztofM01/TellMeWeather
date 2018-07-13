package com.insane.tellmeweather.models.weather.current;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class WeatherSunStats {

    @JsonProperty("sunrise")
    private long sunriseInSeconds;

    @JsonProperty("sunset")
    private long sunsetInSeconds;

    @JsonProperty("country")
    private String country;
}
