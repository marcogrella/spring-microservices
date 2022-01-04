package com.br.microservicos.services;

import com.br.microservicos.entities.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAll();
    Employee getById(Long id);
    Employee save(Employee employee);
    void remove(Long id) throws Exception;
    Employee findByIdOrThrowBadRequestException(Long id);

}
