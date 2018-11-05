package com.shop.fuelcoupons.model.music.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.google.gson.annotations.SerializedName;

@JsonAutoDetect
public class Header {
    @SerializedName("status_code")
    private Integer statusCode;
    @SerializedName("execute_time")
    private Double executeTime;
    @SerializedName("confidence")
    private Integer confidence;
    @SerializedName("mode")
    private String mode;
    @SerializedName("cached")
    private Integer cached;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Double getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Double executeTime) {
        this.executeTime = executeTime;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Integer getCached() {
        return cached;
    }

    public void setCached(Integer cached) {
        this.cached = cached;
    }

}
