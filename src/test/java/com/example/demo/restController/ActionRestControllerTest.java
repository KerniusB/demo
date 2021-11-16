package com.example.demo.restController;

import com.example.demo.DemoApplication;
import com.example.demo.model.Action;
import com.example.demo.repository.ActionRepository;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertTrue;

@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ActionRestControllerTest {

    @Autowired
    ActionRepository actionRepository;

    @LocalServerPort
    private int port;

    @Test
    void test() {
        System.out.println("PORT=" + port);
    }

    @Test
    void addCashRegister() {
        Action sample = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        TestRestTemplate restTemplate = new TestRestTemplate();
        HttpEntity<Action> entity = new HttpEntity<>(sample, headers);
        ResponseEntity<String> response = restTemplate.exchange("http://localhost:" + port + "/action/add", HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/action/add/" + 1L));
    }

    @Test
    void updateCashRegister() {
    }

    @Test
    void deleteCashRegister() {
    }

    @Test
    void getAllCashRegister() {
    }
}