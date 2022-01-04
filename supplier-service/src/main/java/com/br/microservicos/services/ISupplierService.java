package com.br.microservicos.services;

import com.br.microservicos.entities.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> getAll();
    Supplier getById(Long id);
    Supplier save(Supplier supplier);
    void remove(Long id) throws Exception;
    Supplier findByIdOrThrowBadRequestException(Long id);

}
