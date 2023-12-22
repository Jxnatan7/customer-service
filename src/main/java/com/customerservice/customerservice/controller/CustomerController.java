package com.customerservice.customerservice.controller;

import com.customerservice.customerservice.dto.CustomerRequest;
import com.customerservice.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CustomerRequest customerRequest) {
        customerService.createCustomer(customerRequest);
    }
}
