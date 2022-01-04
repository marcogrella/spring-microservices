package com.br.microservicos.microservicos.controllers;


import com.br.microservicos.microservicos.entities.Customer;
import com.br.microservicos.microservicos.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    ICustomerService service;

    @GetMapping("/api/customers")
    public List<Customer> getAll(){
        return service.getAll();
    }


    @GetMapping("/api/customers/{id}")
    public ResponseEntity<Customer> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }


    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id) throws Exception {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/api/customers/")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return new ResponseEntity<>(service.save(customer), HttpStatus.CREATED);
    }
}
