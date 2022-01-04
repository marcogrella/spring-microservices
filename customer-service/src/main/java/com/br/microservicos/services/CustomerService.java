package com.br.microservicos.services;

import com.br.microservicos.exceptions.BadRequestException;
import com.br.microservicos.entities.Customer;
import com.br.microservicos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository repository;

    @Override
    public List<Customer> getAll(){
     return (List<Customer>) repository.findAll();
    }


    @Override
    public Customer getById(Long id){
        findByIdOrThrowBadRequestException(id);
        return repository.findById(id).get();
    }

    @Override
    public void remove(Long id) throws Exception {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Override
    public Customer save(Customer customer){
        return repository.save(customer);
    }

    @Override
    public Customer findByIdOrThrowBadRequestException(Long id) {
        return repository.findById(id).
                        orElseThrow(() -> new BadRequestException("Customer não encontrado"));
    }


}
