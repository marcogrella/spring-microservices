package com.br.microservicos.controllers;


import com.br.microservicos.entities.Supplier;
import com.br.microservicos.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    ISupplierService service;

    @GetMapping("/api/suppliers/")
    public List<Supplier> getAll(){
        return service.getAll();
    }


    @GetMapping("/api/suppliers/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findByIdOrThrowBadRequestException(id));
    }


    @DeleteMapping("/api/suppliers/{id}")
    public ResponseEntity<Void> remove(@PathVariable long id) throws Exception {
        service.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/api/suppliers/")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier){
        return new ResponseEntity<>(service.save(supplier), HttpStatus.CREATED);
    }
}
