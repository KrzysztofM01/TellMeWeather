package com.insane.tellmeweather.controllers;

import com.insane.tellmeweather.models.services.CurrentWeatherService;
import com.insane.tellmeweather.models.weather.current.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private CurrentWeatherService currentWeatherService;

    @Autowired
    public MainController(CurrentWeatherService currentWeatherService){
        this.currentWeatherService = currentWeatherService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String index(@RequestParam("city") String city, Model model){

        WeatherModel weatherInfo = currentWeatherService.makeCall(city);

        model.addAttribute("city", currentWeatherService.cityFormat(weatherInfo));
        model.addAttribute("country", currentWeatherService.countryFormat(weatherInfo));
        model.addAttribute("temperature", currentWeatherService.temperatureFormat(weatherInfo));
        model.addAttribute("pressure", currentWeatherService.pressureFormat(weatherInfo));
        model.addAttribute("humidity", currentWeatherService.humidityFormat(weatherInfo));
        model.addAttribute("cloudiness", currentWeatherService.cloudinessFormat(weatherInfo));
        model.addAttribute("sunrise", currentWeatherService.sunriseFormat(weatherInfo));
        model.addAttribute("sunset", currentWeatherService.sunsetFormat(weatherInfo));

        return "index";
    }
}
