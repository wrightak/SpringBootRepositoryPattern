package com.example.demo;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MySQLCustomerRepository implements CustomerRepository {

    private JdbcTemplate jdbcTemplate;

    public MySQLCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(NewCustomer newCustomer) {
        jdbcTemplate.update("INSERT INTO customer(name) VALUES(?)", newCustomer.getName());
    }

    @Override
    public void delete(Customer customer) {
        jdbcTemplate.update("DELETE FROM customer WHERE id = ?", customer.getId());
    }

    @Override
    public List<Customer> getAll() {
        RowMapper<Customer> rowMapper = (rs, rowNum) -> new Customer(
                rs.getInt("id"),
                rs.getString("name")
        );
        return jdbcTemplate.query("SELECT * FROM customer",
                rowMapper);
    }
}
