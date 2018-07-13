package com.insane.tellmeweather.models.services;

import com.insane.tellmeweather.models.ApplicationPropertiesBean;
import com.insane.tellmeweather.models.weather.current.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class CurrentWeatherService {

    //    @Value("${openweathermap.api_key}")
//    private String apiKey;
    private RestTemplate restTemplate;

    @Autowired
    ApplicationPropertiesBean applicationPropertiesBean;

    public CurrentWeatherService() {
        restTemplate = new RestTemplate();
    }

    public WeatherModel makeCall(String city) {
        return restTemplate.getForObject(applicationPropertiesBean.getContent().get(applicationPropertiesBean.WEBSITE_URL) + city + "&appid=" + applicationPropertiesBean.getContent().get(applicationPropertiesBean.API_KEY) , WeatherModel.class);
    }

    public String cityFormat(WeatherModel weatherModel) {
        return weatherModel.getCityName();
    }

    public String countryFormat(WeatherModel weatherModel) {
        return weatherModel.getSunStats().getCountry();
    }

    public String temperatureFormat(WeatherModel weatherModel) {
        return String.format("%.1f", weatherModel.getMainStats().getTemperatureInKelwin() - 273.15) + "°C";
    }

    public String pressureFormat(WeatherModel weatherModel) {
        return String.format("%.0f", weatherModel.getMainStats().getPressure()) + " hPa";
    }

    public String humidityFormat(WeatherModel weatherModel) {
        return String.format("%.0f", weatherModel.getMainStats().getHumidity()) + "%";
    }

    public String cloudinessFormat(WeatherModel weatherModel) {
        return String.format("%.0f", weatherModel.getCloudsStats().getPercentageCloudiness()) + "%";
    }

    public String sunriseFormat(WeatherModel weatherModel) {

        Date sunrise = new Date(weatherModel.getSunStats().getSunriseInSeconds() * 1000);
        int hour = sunrise.getHours();
        int minutes = sunrise.getMinutes();

        return getString(hour, minutes);
    }

    private String getString(int hour, int minutes) {
        if (hour < 10 && minutes < 10)
            return "0" + hour + ":" + "0" + minutes;
        else if (hour >= 10 && minutes < 10)
            return hour + ":" + "0" + minutes;
        else if (hour < 10 && minutes >= 10)
            return "0" + hour + ":" + minutes;
        else
            return hour + ":" + minutes;
    }

    public String sunsetFormat(WeatherModel weatherModel) {

        Date sunset = new Date(weatherModel.getSunStats().getSunsetInSeconds() * 1000);
        int hour = sunset.getHours();
        int minutes = sunset.getMinutes();

        return getString(hour, minutes);
    }
}
