package com.br.microservicos.microservicos.repositories;


import com.br.microservicos.microservicos.entities.Customer;
import com.br.microservicos.microservicos.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
