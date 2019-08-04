package com.ls.spring.cloud.vo;

import java.io.Serializable;

/**
 * @author: jeffchen
 * 昨日天气
 *
 */
public class Yesterday implements Serializable {

    private String date;
    private String high;
    private String low;
    private String fx;
    private String fl;
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

    public String getFx () {
        return fx;
    }

    public void setFx (String fx) {
        this.fx = fx;
    }

    public String getFl () {
        return fl;
    }

    public void setFl (String fl) {
        this.fl = fl;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }
}
