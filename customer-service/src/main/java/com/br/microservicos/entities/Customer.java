package com.br.microservicos.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty(message = "Field 'firstname' is mandatory.")
    private String firstname;
    @NotEmpty(message = "Field 'lastname' is mandatory.")
    private String lastname;
    @NotEmpty(message = "Field 'email' is mandatory.")
    private String email;
    @NotEmpty(message = "Field 'phone' is mandatory.")
    private String phone;
    @NotEmpty(message = "Field 'address' is mandatory.")
    private String address;

}
