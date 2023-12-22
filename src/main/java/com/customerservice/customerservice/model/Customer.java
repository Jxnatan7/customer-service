package com.customerservice.customerservice.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "customers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Double latitude;
    private Double longitude;
}
