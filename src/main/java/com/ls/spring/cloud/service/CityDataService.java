package com.ls.spring.cloud.service;

import com.ls.spring.cloud.vo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther：jeffchen
 *
 * 城市数据服务
 */
@Service
public interface CityDataService {

    /**
     * 功能描述:  获取城市列表
     * @auther: JeffChen
     * @date: 2019/8/5 18:38
     */
    List<City> listCity() throws Exception;


}
