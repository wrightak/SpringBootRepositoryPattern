package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InMemoryCustomerRepositoryFakeTest {
    private InMemoryCustomerRepositoryFake inMemoryCustomerRepositoryFake;

    @BeforeEach
    void setUp() {
        inMemoryCustomerRepositoryFake = new InMemoryCustomerRepositoryFake();
    }

    @Test
    void createAndDelete() {
        new CustomerRepositoryTest(inMemoryCustomerRepositoryFake).createAndDelete();
    }
}
