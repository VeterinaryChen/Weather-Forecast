package com.ls.spring.cloud.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ls.spring.cloud.service.WeatherDataService;
import com.ls.spring.cloud.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author: jeffchen
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 功能描述: 根据城市 ID 查询城市天气
     *
     * @param cityId
     * @auther: JeffChen
     * @date: 2019/8/4 19:09
     */
    @Override
    public WeatherResponse getDataByCityId (String cityId) {
        // http://wthrcdn.etouch.cn/weather_mini?citykey=?
        String url = WEATHER_URI + "citykey=" + cityId;

        return this.doGetWeather(url);

    }

    /**
     * 功能描述: 根据城市名称查询城市天气
     *
     * @param cityName
     * @auther: JeffChen
     * @date: 2019/8/4 19:10
     */
    @Override
    public WeatherResponse getDataByCityName (String cityName) {
        String url = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(url);
    }

    private WeatherResponse doGetWeather (String uri) {
        WeatherResponse weatherResponse = null;
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        ObjectMapper mapper = new ObjectMapper();
        String strbody = null;

        if (respString.getStatusCodeValue() == 200) {
            strbody = respString.getBody();

        }

        try {
            weatherResponse = mapper.readValue(strbody, WeatherResponse.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }
}
