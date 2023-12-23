package com.customerservice.customerservice.controller;

import com.customerservice.customerservice.dto.request.CustomerRequest;
import com.customerservice.customerservice.dto.response.OpenStreetMapResponse;
import com.customerservice.customerservice.service.CustomerService;
import com.customerservice.customerservice.service.GeolocationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final GeolocationService geolocationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody CustomerRequest customerRequest) {
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
}
