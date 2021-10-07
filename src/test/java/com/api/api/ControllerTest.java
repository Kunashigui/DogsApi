package com.api.api;

import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    void getDogs() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/dogs",
                HttpMethod.GET, entity, String.class);

        Assert.notNull(response.getBody(), "Object is null.");
        Assert.isTrue("200 OK".equals(response.getStatusCode().toString()), "Response is: ".concat(response.getStatusCode().toString()));
    }

    @Test
    void addDog() {
        Dog pancho = new Dog("Pancho", "Gris/Blanco");

        ResponseEntity<Dog> postResponse = restTemplate.postForEntity(getRootUrl() + "/dogs", pancho, Dog.class);
        Assert.notNull(postResponse, "Response is null.");
        Assert.notNull(postResponse.getBody(), "Body is null.");

        Assert.isTrue("200 OK".equals(postResponse.getStatusCode().toString()), "Response is: ".concat(postResponse.getStatusCode().toString()));
    }
}