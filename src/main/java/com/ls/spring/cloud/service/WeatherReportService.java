package com.ls.spring.cloud.service;

import com.ls.spring.cloud.vo.Weather;
import org.springframework.stereotype.Service;

/**
 * @auther：jeffchen
 */
@Service
public interface WeatherReportService {

    Weather getDataByCityId(String cityId);
}
