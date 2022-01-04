package com.br.microservicos.microservicos.repositories;


import com.br.microservicos.microservicos.entities.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
