package com.ls.spring.cloud.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: jeffchen
 */
public class Weather implements Serializable {

    private String city;
    private Yesterday yesterday;
    private String aqi;
    private List<Forecast> forecast;
    private String ganmao;
    private String wendu;

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public Yesterday getYesterday () {
        return yesterday;
    }

    public void setYesterday (Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public String getAqi () {
        return aqi;
    }

    public void setAqi (String aqi) {
        this.aqi = aqi;
    }

    public List<Forecast> getForecast () {
        return forecast;
    }

    public void setForecast (List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public String getGanmao () {
        return ganmao;
    }

    public void setGanmao (String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu () {
        return wendu;
    }

    public void setWendu (String wendu) {
        this.wendu = wendu;
    }

    @Override
    public String toString () {
        return "Weather{" +
                "city='" + city + '\'' +
                ", yesterday=" + yesterday +
                ", aqi='" + aqi + '\'' +
                ", forecast=" + forecast +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                '}';
    }
}
