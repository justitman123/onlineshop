package com.shop.fuelcoupons.web.music;

import com.shop.fuelcoupons.model.music.entity.track.Track;
import com.shop.fuelcoupons.model.music.http.MusixMatch;
import com.shop.fuelcoupons.model.music.http.MusixMatchException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ajax/profile/music")
public class MusicController {

    String trackName = "Don't stop the Party";
    String artistName = "The Black Eyed Peas";

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Track getAll() throws MusixMatchException {
        MusixMatch musixMatch = new MusixMatch();
        Track track = musixMatch.getMatchingTrack(trackName, artistName);
//        TrackData data = track.getTrack();
        return track;
    }
}
