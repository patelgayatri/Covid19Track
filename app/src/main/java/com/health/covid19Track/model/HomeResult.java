package com.health.covid19Track.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HomeResult {

    @SerializedName("data")
    @Expose
    private HomeData data;
    @SerializedName("status")
    @Expose
    private String status;

    public HomeData getData() {
        return data;
    }

    public void setData(HomeData data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}