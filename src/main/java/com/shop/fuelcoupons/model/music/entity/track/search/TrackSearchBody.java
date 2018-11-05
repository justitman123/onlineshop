package com.shop.fuelcoupons.model.music.entity.track.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shop.fuelcoupons.model.music.entity.track.Track;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackSearchBody {
    private List<Track> track_list;

    public void setTrack_list(List<Track> track_list) {
        this.track_list = track_list;
    }

    public List<Track> getTrack_list() {
        return track_list;
    }
}
