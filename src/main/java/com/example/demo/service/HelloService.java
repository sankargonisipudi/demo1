package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HelloService {

    @Autowired
    HelloRepository helloRepository;

    public String getGreetingMessage(String pname) {

        if (pname.startsWith("A")) {
            return "Hello, " + pname + " provide facility A joining date " + new Date();
        }
        if (pname.startsWith("B")) {
            return "Hello, " + pname + "provide facility B";
        }
        return "Hello, " + pname;
    }

    public Employee saveOrUpdate(Employee employee) {

        return helloRepository.save(employee);
    }

    public Employee updateEmployee(long id, Employee employee) {

        Employee emp = helloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        // employee.setFirstName(emp.getFirstName());
        if (employee.getFirstName() != null) {
            emp.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName() != null) {
            emp.setLastName(employee.getLastName());
        }

        if (employee.getAge() > 0) {
            emp.setAge(employee.getAge());
        }

        return helloRepository.save(emp);

    }

    public Employee patchEmployee(long id, Employee employee) {

        Employee emp = helloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setFirstName(employee.getFirstName());
        return helloRepository.save(emp);


    }
    public String deleteEmployee(long id) {


        helloRepository.deleteById(id);
        return "Emp ID "+id +"deleted successfully";


    }
    public List<Employee> getEmployeeListByName(String lastName ) {


        return helloRepository.findByLastName(lastName);



    }

}
