package com.ls.spring.cloud.service;

import com.ls.spring.cloud.vo.WeatherResponse;
import org.springframework.stereotype.Service;

/**
 * @auther：jeffchen
 */
@Service
public interface WeatherDataService {

    /**
     * 功能描述: 根据城市 ID 查询城市天气
     * @auther: JeffChen
     * @date: 2019/8/4 19:09
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 功能描述: 根据城市名称查询城市天气
     * @auther: JeffChen
     * @date: 2019/8/4 19:10
     */
    WeatherResponse getDataByCityName(String cityName);

    void SyncDataByCityId(String cityId);

    void saveWeatherData(String uri);
}
