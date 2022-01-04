package com.br.microservicos.microservicos.repositories;


import com.br.microservicos.microservicos.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
