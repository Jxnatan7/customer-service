package com.customerservice.customerservice.service;

import com.customerservice.customerservice.dto.request.CustomerRequest;
import com.customerservice.customerservice.dto.response.CustomerResponse;
import com.customerservice.customerservice.model.Customer;
import com.customerservice.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder encoder;

    public void createCustomer(CustomerRequest customerRequest) {
        if(customerRepository.findByEmail(customerRequest.getEmail()) != null) {
            ResponseEntity.badRequest().build();
            return;
        }

        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .password(encoder.encode(customerRequest.getPassword()))
                .latitude(customerRequest.getLatitude())
                .longitude(customerRequest.getLongitude())
                .build();

        customerRepository.save(customer);

        log.info("Customer created successfully.");

        ResponseEntity.ok().build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found with email: " + email);
        }
        return customer;
    }


}
