package com.ls.spring.cloud.vo;

import javax.xml.bind.annotation.*;

/**
 * @author: jeffchen
 * 解析 XML 映射到 JavaBean
 */
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    @XmlAttribute(name = "d1")
    private String cityId;

    @XmlAttribute(name = "d2")
    private String cityName;

    @XmlAttribute(name = "d3")
    private String cityCode;

    @XmlAttribute(name = "d4")
    private String province;

    public String getCityId () {
        return cityId;
    }

    public void setCityId (String cityId) {
        this.cityId = cityId;
    }

    public String getCityName () {
        return cityName;
    }

    public void setCityName (String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode () {
        return cityCode;
    }

    public void setCityCode (String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince () {
        return province;
    }

    public void setProvince (String province) {
        this.province = province;
    }
}
