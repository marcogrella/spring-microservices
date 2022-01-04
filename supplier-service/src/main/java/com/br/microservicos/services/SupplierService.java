package com.br.microservicos.services;

import com.br.microservicos.exceptions.BadRequestException;
import com.br.microservicos.entities.Supplier;
import com.br.microservicos.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService{

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> getAll(){
        return (List<Supplier>) repository.findAll();
    }


    @Override
    public Supplier getById(Long id){
        findByIdOrThrowBadRequestException(id);
        return repository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Override
    public Supplier save(Supplier supplier){
        return repository.save(supplier);
    }

    @Override
    public Supplier findByIdOrThrowBadRequestException(Long id) {
        return repository.findById(id).
                        orElseThrow(() -> new BadRequestException("Fornecedor não encontrado"));
    }


}
