package com.ls.spring.cloud.vo;

import java.io.Serializable;

/**
 * @author: jeffchen
 * 未来天气
 */

public class Forecast implements Serializable {

    private String date;
    private String high;
    private String low;
    private String fengxiang;
    private String fengli;
    private String type;

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getHigh () {
        return high;
    }

    public void setHigh (String high) {
        this.high = high;
    }

    public String getLow () {
        return low;
    }

    public void setLow (String low) {
        this.low = low;
    }

    public String getFengxiang () {
        return fengxiang;
    }

    public void setFengxiang (String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getFengli () {
        return fengli;
    }

    public void setFengli (String fengli) {
        this.fengli = fengli;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
}
