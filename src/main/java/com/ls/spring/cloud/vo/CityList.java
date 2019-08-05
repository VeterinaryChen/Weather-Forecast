package com.ls.spring.cloud.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @author: jeffchen
 * City 数据的集合
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList () {
        return cityList;
    }

    public void setCityList (List<City> cityList) {
        this.cityList = cityList;
    }
}
