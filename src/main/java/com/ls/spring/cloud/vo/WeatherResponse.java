package com.ls.spring.cloud.vo;

import java.io.Serializable;

/**
 * @author: jeffchen
 */
public class WeatherResponse implements Serializable {

    private Weather data;
    private Integer status;
    private String desc;

    public Weather getData () {
        return data;
    }

    public void setData (Weather data) {
        this.data = data;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus (Integer status) {
        this.status = status;
    }

    public String getDesc () {
        return desc;
    }

    public void setDesc (String desc) {
        this.desc = desc;
    }
}
