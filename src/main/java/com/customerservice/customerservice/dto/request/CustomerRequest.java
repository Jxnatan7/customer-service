package com.customerservice.customerservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private String name;
    private String email;
    private String password;
    private Double latitude;
    private Double longitude;
    private String street;
    private String city;
    private String country;
    private String state;
    private String postalcode;
}
