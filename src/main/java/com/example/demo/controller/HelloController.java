package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello/{pname}")
    public String hello(@PathVariable String pname) {

        String message=helloService.getGreetingMessage(pname);
        return message;
    }

    @PostMapping("/hello/create")
    public Employee createEmployee(@RequestBody Employee emp) {

        return helloService.saveOrUpdate(emp);

    }


    @PutMapping("/hello/update")
    public Employee updateEmployee(@RequestParam long id,@RequestBody Employee emp) {

        return helloService.updateEmployee(id,emp);

    }
    @PatchMapping ("/hello/patch")
    public Employee patchEmployee(@RequestParam long id,@RequestBody Employee emp) {

        return helloService.patchEmployee(id,emp);

    }
    @DeleteMapping ("/hello/delete")
    public String deleteEmployee(@RequestParam long id) {

        return helloService.deleteEmployee(id);

    }
    @GetMapping("/hello/getEmployee")
    public List<Employee> getEmployeeListByName(@RequestParam String lastName ) {

        return helloService.getEmployeeListByName(lastName);

    }



//    @GetMapping("/hello")
//    public String searchEmployee(@RequestParam String id) {
//
//        return "Hello, your employee number" + id;
//    }
//
//    @PostMapping("/hello/create")
//    public String createEmployee(@RequestBody List< Employee > emp) {
//
//        return "EmployeeData inserted successfully for " + emp.getFirstName();
//
//    }
//    @GetMapping("/hello/100")
//    public ResponseBody create() {
//        Employee emp= new Employee();
//        emp.setFirstName("aaa");
//       return (ResponseBody) emp;
//
//    }
//
//
//    @PutMapping("/hello/update/{empid}")
//    public Employee<Collection<E>> updateEmployee(@PathVariable String empid,
//                                                  @RequestBody Employee<Collection<E>> emp) {
//        return emp;
////       return "EmployeeData updated successfully for empid  " +empid;
//
//    }
//
//    @PatchMapping("/patch/{empid}")
//    public Employee<Collection<E>> patchEmployee(@PathVariable String empid,
//                                                 @RequestBody Employee<Collection<E>> emp) {
//        return emp;
//
//    }
}



