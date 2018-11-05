package com.shop.fuelcoupons.model.music.entity.track.get;

import com.google.gson.annotations.SerializedName;
import com.shop.fuelcoupons.model.music.entity.track.TrackData;

public class TrackGetBody {
    @SerializedName("track")
    private TrackData track;

    public void setTrack(TrackData track) {
        this.track = track;
    }

    public TrackData getTrack() {
        return track;
    }
}
