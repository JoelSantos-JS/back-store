package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.State;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StateControllerTest {

    @Autowired
    private WebTestClient  webTestClient;

    @Test
    void getAll() {

        webTestClient.get()
                .uri("/state")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findById() {
        final  var name = "Rio de Janeiro";
        final  var uf = "RJ";


        State state = new State();
        state.setName(name);
        state.setInitials(uf);

        webTestClient.get()
                .uri("/state/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .equals(state);
    }

    @Test
    void save() {

        final  var name = "Rio de Janeiro";
        final  var uf = "RJ";


        State state = new State();
        state.setName(name);
        state.setInitials(uf);

        webTestClient.post()
                .uri("/state")
                .bodyValue(state)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(State.class)
                .value(s -> assertEquals(name, s.getName()))
                .value(s -> assertEquals(uf, s.getInitials()));
    }

    @Test
    void update() {

        final  var name = "Rio de Janeiro";
        final  var uf = "RJ";


        State state = new State();
        state.setName(name);
        state.setInitials(uf);

        webTestClient.put()
                .uri("/state/1")
                .bodyValue(state)
                .exchange()
                .expectStatus().isOk()
                .expectBody(State.class)
                .value(s -> assertEquals(name, s.getName()))
                .value(s -> assertEquals(uf, s.getInitials()));
    }



    @Test
    void delete() {

        webTestClient.delete()
                .uri("/state/2")
                .exchange()
                .expectStatus().isNoContent();
    }
}