package com.joel.br.backstore.controller;

import com.joel.br.backstore.model.City;
import com.joel.br.backstore.model.State;
import com.joel.br.backstore.services.CityService;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CityControllerTest {


    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CityService cityService;

    private State state;
    private City city;
    @BeforeEach

    void setUp() {
        final var name1 = "Rio de Janeiro";
        final var uf1 = "RJ";
        state = new State();
        state.setName(name1);
        state.setInitials(uf1);

        final var name = "Jequié";
        final var id = 1L;
        city = new City();
        city.setId(id);
        city.setName(name);


    }



        @Test
    void getAll() {

        webTestClient.get().uri("/city")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void getById() {
        webTestClient.get()
                .uri("/city/{id}", 1)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void save() {


    }

    @Test
    void update() {



    }

    @Test
    void delete() {
    }
}