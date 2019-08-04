package com.ls.spring.cloud.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ls.spring.cloud.service.WeatherDataService;
import com.ls.spring.cloud.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author: jeffchen
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    private final static Logger Logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    private static final long TIME_OUT = 10L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        String key = uri;
        String strbody = null;
        WeatherResponse weatherResponse = null;
        ObjectMapper mapper = new ObjectMapper();
        // 先查缓存，再调接口
        ValueOperations <String,String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)){
            Logger.info("Redis has Data!");
            strbody = ops.get(key);
        }
        else {

            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);

            if (respString.getStatusCodeValue() == 200) {
                strbody = respString.getBody();

            }

            // 将数据写入缓存
            ops.set(key, strbody, TIME_OUT, TimeUnit.SECONDS);

            try {
                weatherResponse = mapper.readValue(strbody, WeatherResponse.class);
            } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                Logger.error("Redis has no Data!");
            }
            }
            return weatherResponse;
    }
}
