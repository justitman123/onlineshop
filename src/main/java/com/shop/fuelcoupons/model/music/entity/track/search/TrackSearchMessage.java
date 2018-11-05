package com.shop.fuelcoupons.model.music.entity.track.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackSearchMessage {
    @SerializedName("message")
    private TrackSearchContainer trackMessage;

    public void setTrackMessage(TrackSearchContainer trackMessage) {
        this.trackMessage = trackMessage;
    }

    public TrackSearchContainer getTrackMessage() {
        return trackMessage;
    }
}
