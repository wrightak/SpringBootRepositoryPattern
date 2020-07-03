package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class InMemoryCustomerRepositoryFake implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    private int counter = 0;

    @Override
    public void add(NewCustomer newCustomer) {
        Customer customer = new Customer(counter, newCustomer.getName());
        counter++;
        customers.add(customer);
    }

    @Override
    public void delete(Customer customerToDelete) {
        Predicate<Customer> predicate = (customer -> customer.getId() == customerToDelete.getId());
        customers.removeIf(predicate);
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}
