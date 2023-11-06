package test_001.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class CustomerDAO {

    private final List<Customer> customers = new ArrayList<>();
    private long nextCustomerId = 1;

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findFirst();
    }


    public Customer save(Customer customer) {
       
        customers.add(customer);
        return customer;
    }

    public void deleteById(Long id) {
        customers.removeIf(customer -> customer.getId() == id);
    }
}
