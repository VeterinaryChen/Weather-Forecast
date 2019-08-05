package com.ls.spring.cloud.service.impl;

import com.ls.spring.cloud.service.WeatherDataService;
import com.ls.spring.cloud.service.WeatherReportService;
import com.ls.spring.cloud.vo.Weather;
import com.ls.spring.cloud.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: jeffchen
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId (String cityId) {
        WeatherResponse response = weatherDataService.getDataByCityId(cityId);
        return response.getData();
    }
}
