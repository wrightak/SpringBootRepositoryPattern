package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private MySQLCustomerRepository mySQLCustomerRepository;

    public DemoController(
            MySQLCustomerRepository mySQLCustomerRepository
    ) {
        this.mySQLCustomerRepository = mySQLCustomerRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-customer")
    public void addCustomer(@RequestBody NewCustomer newCustomer) {
        mySQLCustomerRepository.add(newCustomer);
    }
}
