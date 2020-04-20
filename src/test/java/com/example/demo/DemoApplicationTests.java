package com.example.demo;

import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    int randomServerPort;

    @Test
    public void happyGeoLocationTest() throws URISyntaxException {
        final String baseUrl = "http://localhost:" + randomServerPort + "/user/info";
        URI uri = new URI(baseUrl);
        User user =  new User();
        HttpEntity<User> userHttpEntity = new HttpEntity<>(user);
        ResponseEntity<User> response = this.restTemplate.postForEntity(uri, userHttpEntity, User.class);
        Assert.isTrue(HttpStatus.OK == response.getStatusCode(), "http state not OK");
        User geoLocationInfo = response.getBody();
        Assert.notNull(geoLocationInfo, "geoLocationInfo is null");
    }

}