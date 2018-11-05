package com.shop.fuelcoupons.model.music.entity.track.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import com.shop.fuelcoupons.model.music.entity.Header;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackSearchContainer {
    @SerializedName("body")
    private TrackSearchBody body;

    @SerializedName("header")
    private Header header;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public TrackSearchBody getBody() {
        return body;
    }

    public void setBody(TrackSearchBody body) {
        this.body = body;
    }
}
