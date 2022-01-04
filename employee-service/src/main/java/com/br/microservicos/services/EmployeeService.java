package com.br.microservicos.services;

import com.br.microservicos.exceptions.BadRequestException;
import com.br.microservicos.entities.Employee;
import com.br.microservicos.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll(){
     return (List<Employee>) repository.findAll();
    }


    @Override
    public Employee getById(Long id){
        findByIdOrThrowBadRequestException(id);
        return repository.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        repository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Override
    public Employee save(Employee employee){
        return repository.save(employee);
    }

    @Override
    public Employee findByIdOrThrowBadRequestException(Long id) {
        return repository.findById(id).
                        orElseThrow(() -> new BadRequestException("Empregado não encontrado"));
    }


}
