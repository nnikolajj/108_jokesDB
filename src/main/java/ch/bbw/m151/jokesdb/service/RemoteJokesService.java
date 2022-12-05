package ch.bbw.m151.jokesdb.service;

import ch.bbw.m151.jokesdb.datamodel.JokesEntity;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;

public class RemoteJokesService {

    @Data
    public static class JokeDto{
        String joke;
        String timestamp;
        String category;
    }

    public JokesEntity jotd(){
        var client = WebClient.builder()
                .baseUrl("https://v2.jokeapi.dev")
                .build();
        return client.get().uri("/joke/Any?type=single")
                .retrieve()
                .bodyToMono(JokesEntity.class)
                .block();
    }


}
