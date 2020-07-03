package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class MySQLCustomerRepositoryContractTests {

    @Autowired
    private MySQLCustomerRepository mySQLCustomerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        jdbcTemplate.execute("TRUNCATE table customer");
    }

    @Test
    void createAndDelete() {
        new CustomerRepositoryContractTests(mySQLCustomerRepository).createAndDelete();
    }
}