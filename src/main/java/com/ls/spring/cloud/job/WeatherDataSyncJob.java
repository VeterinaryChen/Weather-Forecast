package com.ls.spring.cloud.job;

import com.ls.spring.cloud.service.CityDataService;
import com.ls.spring.cloud.service.WeatherDataService;
import com.ls.spring.cloud.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author: jeffchen
 * 同步天气数据
 */
public class WeatherDataSyncJob extends QuartzJobBean {


    private final static Logger Logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;


    @Override
    protected void executeInternal (JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Logger.info("Weather Sync Job Start!");

        // 获取城市列表

        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 遍历 List 获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            Logger.info("Weather Data Sync Job,cityId:" + cityId);
            weatherDataService.SyncDataByCityId(cityId);

        }
        Logger.info("Weather Sync Job End!");
    }

}
