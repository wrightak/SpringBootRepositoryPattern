package com.example.demo;

import java.util.List;

public interface CustomerRepository {
    void add(NewCustomer newCustomer);

    void delete(Customer customer);

    List<Customer> getAll();
}
