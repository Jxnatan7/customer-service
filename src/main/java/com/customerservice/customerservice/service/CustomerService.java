package com.customerservice.customerservice.service;

import com.customerservice.customerservice.dto.request.CustomerRequest;
import com.customerservice.customerservice.model.Customer;
import com.customerservice.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .password(encoder.encode(customerRequest.getPassword()))
                .latitude(customerRequest.getLatitude())
                .longitude(customerRequest.getLongitude())
                .build();

        customerRepository.save(customer);

        log.info("Customer created successfully.");
    }


}
