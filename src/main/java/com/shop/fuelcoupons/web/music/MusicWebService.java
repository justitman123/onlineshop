//package com.shop.fuelcoupons.web.music;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import java.util.Collections;
//
//public class MusicWebService {
//
//    WebClient client3 = WebClient
//            .builder()
//            .baseUrl("http://localhost:8080")
//            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//            .defaultUriVariables(Collections.singletonMap("url", "http://localhost:8080"))
//            .build();
//
//    @CrossOrigin("https://freemusicarchive.org/api/get/")
//    @GetMapping("tracks")
//    public Flux<Music> retrieve(@PathVariable Long id) {
//        WebClient client = WebClient.create("http://example.org");
//        return client.post()
//                .uri("/persons/{id}", id)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(personMono, Music.class)
//                .retrieve()
//                .bodyTaoFlux(Music.class);
//    }
//}
