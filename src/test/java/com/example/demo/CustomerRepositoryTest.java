package com.example.demo;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerRepositoryTest {

    private CustomerRepository repository;

    public CustomerRepositoryTest(CustomerRepository repository) {
        this.repository = repository;
    }

    public void createAndDelete() {
        List<Customer> allBefore = repository.getAll();
        assertThat(allBefore.size()).isEqualTo(0);

        NewCustomer newCustomer = new NewCustomer("Mura-san");
        repository.add(newCustomer);

        List<Customer> allAfterCreate = repository.getAll();
        assertThat(allAfterCreate.size()).isEqualTo(1);

        Customer customer = allAfterCreate.get(0);
        assertThat(customer.getName()).isEqualTo("Mura-san");

        repository.delete(customer);

        List<Customer> allAfterDelete = repository.getAll();
        assertThat(allAfterDelete.size()).isEqualTo(0);
    }
}
