package com.shop.fuelcoupons.model.music.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.fuelcoupons.model.music.config.Constants;
import com.shop.fuelcoupons.model.music.entity.track.search.TrackSearchContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class MusixMatchRequest {

    public static String sendRequest(String requestString)
            throws MusixMatchException {
        StringBuffer buffer = new StringBuffer();
        Mono<ResponseEntity<TrackSearchContainer>> retrieve = retrieve(requestString);
        try {

            String apiUrl = Constants.API_URL + Constants.API_VERSION
                    + Constants.URL_DELIM + requestString;

            URL url = new URL(apiUrl);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    url.openStream(), "UTF-8"));
            String str;

            while ((str = in.readLine()) != null) {
                buffer.append(str);
            }

            in.close();
        } catch (MalformedURLException e) {
            throw new MusixMatchException(e.getMessage());
        } catch (IOException e) {
            throw new MusixMatchException(e.getMessage());
        }

        return buffer.toString();
    }

    @Autowired
    static ObjectMapper objectMapper;

    //    @CrossOrigin("https://freemusicarchive.org/api/get/")
    @GetMapping("tracks")
    public static Mono<ResponseEntity<TrackSearchContainer>> retrieve(String fds) {
        ExchangeStrategies strategies = ExchangeStrategies
                .builder()
                .codecs(clientDefaultCodecsConfigurer -> {
                    clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonEncoder(new Jackson2JsonEncoder(new ObjectMapper(), MediaType.TEXT_PLAIN));
                    clientDefaultCodecsConfigurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(new ObjectMapper(), MediaType.TEXT_PLAIN));

                }).build();

        WebClient webClient = WebClient.builder().exchangeStrategies(strategies).build();
        return webClient.get()
                .uri("https://musixmatchcom-musixmatch.p.mashape.com/wsr/1.1/" + requestString)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .acceptCharset(Charset.forName("UTF-8"))
                .header("X-Mashape-Key", "9zHmqxs7YzmshpMTdp1xx9sVEpI4p1x4NcQjsntt7eA60A5ZLT")
                .exchange()
                .block()
                .toEntity(TrackSearchContainer.class);
    }
}
