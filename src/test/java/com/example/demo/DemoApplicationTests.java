package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.jdbc.JdbcTestUtils.countRowsInTable;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("TRUNCATE table customer");
    }

    @Test
    void contextLoads() {
    }

    @Test
    void showHelloWorld() {
        RequestEntity<Void> requestEntity = RequestEntity.get(URI.create("http://localhost:" + port + "/"))
                .build();

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).contains("Hello World!");
    }

    @Test
    void addCustomer() {
        int rowsInTableBefore = countRowsInTable(jdbcTemplate, "customer");
        assertThat(rowsInTableBefore).isEqualTo(0);

        String customer = "{\n" +
                "  \"name\": \"Andrew\"\n" +
                "}";

        RequestEntity<String> requestEntity = RequestEntity.post(URI.create("http://localhost:" + port + "/add-customer"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(customer);


        ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, String.class);


        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        int rowsInTableAfter = countRowsInTable(jdbcTemplate, "customer");
        assertThat(rowsInTableAfter).isEqualTo(1);
    }
}
