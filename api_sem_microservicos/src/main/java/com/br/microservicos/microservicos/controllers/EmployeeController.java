package com.br.microservicos.microservicos.controllers;


import com.br.microservicos.microservicos.entities.Employee;
import com.br.microservicos.microservicos.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService service;

    @GetMapping("/api/employees")
    public List<Employee> getAll(){
        return service.getAll();
    }


    @GetMapping("/api/employees/{id}")
    public ResponseEntity<Employee> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }


    @DeleteMapping("/api/employees/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id) throws Exception {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/api/employees/")
    public ResponseEntity<Employee> save(@RequestBody Employee employee){
        return new ResponseEntity<>(service.save(employee), HttpStatus.CREATED);
    }
}
