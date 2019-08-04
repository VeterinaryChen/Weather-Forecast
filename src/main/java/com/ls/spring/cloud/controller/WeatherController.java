package com.ls.spring.cloud.controller;

import com.ls.spring.cloud.service.WeatherDataService;
import com.ls.spring.cloud.vo.Weather;
import com.ls.spring.cloud.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jeffchen
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataServiceImpl;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataServiceImpl.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName")String cityName){
        return weatherDataServiceImpl.getDataByCityName(cityName);
    }

    @RequestMapping("/hello")
    public String Hello(){
        return "hEllo";
    }
}
