package com.exam.ExamModule4.service;


import com.exam.ExamModule4.model.Customer;
import com.exam.ExamModule4.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
