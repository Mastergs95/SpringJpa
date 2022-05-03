package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeRepository empRepository;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Iterable<Employee> getEmployee(){
        return empRepository.findAll();
    }

    @RequestMapping(value="/employee", method=RequestMethod.POST, consumes = "application/json")
    public Employee createEmployee(@RequestBody Employee emp){
        emp=empRepository.save(emp);
        return emp;
    }
}
