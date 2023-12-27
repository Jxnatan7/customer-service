package com.customerservice.customerservice.controller;

import com.customerservice.customerservice.dto.request.CustomerRequest;
import com.customerservice.customerservice.dto.request.LoginRequest;
import com.customerservice.customerservice.dto.response.CustomerResponse;
import com.customerservice.customerservice.dto.response.LoginResponse;
import com.customerservice.customerservice.dto.response.OpenStreetMapResponse;
import com.customerservice.customerservice.model.Customer;
import com.customerservice.customerservice.service.CustomerService;
import com.customerservice.customerservice.service.GeolocationService;
import com.customerservice.customerservice.service.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.token.TokenService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    private AuthenticationManager authenticationManager;

    private final CustomerService customerService;

    private final GeolocationService geolocationService;

    @Autowired
    JwtTokenService jwtTokenService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerRequest customerRequest) {

        OpenStreetMapResponse coordinates = geolocationService.getCoordinatesFromQuery(
                customerRequest.getStreet(),
                customerRequest.getCity(),
                customerRequest.getState(),
                customerRequest.getCountry(),
                customerRequest.getPostalcode()
        );

        customerRequest.setLatitude(Double.valueOf(coordinates.getLat()));
        customerRequest.setLongitude(Double.valueOf(coordinates.getLon()));

        customerService.createCustomer(customerRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<CustomerResponse> login(@RequestBody LoginRequest loginRequest) {
        var customerNamePassword = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        try {
            var auth = this.authenticationManager.authenticate(customerNamePassword);
            var customer = (Customer) auth.getPrincipal();
            var token = jwtTokenService.generateToken(customer);

            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setId(customer.getId());
            customerResponse.setName(customer.getName());
            customerResponse.setEmail(customer.getEmail());
            customerResponse.setLatitude(customer.getLatitude());
            customerResponse.setLongitude(customer.getLongitude());
            customerResponse.setToken(token);

            return ResponseEntity.ok(customerResponse);
        } catch (AuthenticationException e) {
            System.out.println("Falha de autenticação: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
