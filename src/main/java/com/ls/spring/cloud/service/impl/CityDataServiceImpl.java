package com.ls.spring.cloud.service.impl;


import com.ls.spring.cloud.service.CityDataService;
import com.ls.spring.cloud.util.XmlBuilder;
import com.ls.spring.cloud.vo.City;
import com.ls.spring.cloud.vo.CityList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


/**
 * @author: jeffchen
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    /**
     * 功能描述:  获取城市列表
     * @auther: JeffChen
     * @date: 2019/8/5 18:38
     */
    @Override
    public List<City> listCity () throws Exception {

        // 读取XML
        Resource resource = new ClassPathResource("cityList.xml");
        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = bf.readLine()) != null) {
            buffer.append(line);
        }
        bf.close();

        // 转换XML为Java对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());

        return cityList.getCityList();
    }
}

