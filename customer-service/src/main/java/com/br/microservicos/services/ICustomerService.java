package com.br.microservicos.services;

import com.br.microservicos.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();
    Customer getById(Long id);
    Customer save(Customer customer);
    void remove(Long id) throws Exception;
    Customer findByIdOrThrowBadRequestException(Long id);

}
