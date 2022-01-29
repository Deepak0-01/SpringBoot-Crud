package com.example.springbootemployeecrud.service;

import com.example.springbootemployeecrud.Entity.Employee;
import com.example.springbootemployeecrud.CSVHelper;
import com.example.springbootemployeecrud.SpringBootEmployeeCrudApplication;
import com.example.springbootemployeecrud.controller.EmployeeController;
import com.example.springbootemployeecrud.repository.EmployeeRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    EmployeeRepository employeerepository;


    @Autowired
    public EmployeeService(EmployeeRepository employeerepository) {
        this.employeerepository = employeerepository;
    }

   public  Employee addEmployee(Employee employee)
    {
       return employeerepository.save(employee);
    }

    public void save(MultipartFile file)
    {
        try{

            List<Employee> csvEmployees = CSVHelper.csvToEmployees(file.getInputStream());

            employeerepository.saveAll(csvEmployees);

            LOGGER.debug("Data saved into Database Successfully");



        }catch(IOException io){


            throw new RuntimeException("Unable to store employees" + io.getMessage());




    }
    }

    public List<Employee> addAllEmployees(List<Employee> employees)
    {

        return employeerepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id)
    {
        return employeerepository.findById(id).orElse(null);
    }

    public List<Employee> getAllEmployees()
    {
        return employeerepository.findAll();
    }

    public Employee getEmployeeByName(String name)
    {

        return employeerepository.findEmployeeByName(name);
    }

    public Employee getEmployeeByDept(String name)
    {

        return employeerepository.findEmployeeByDept(name);
    }

    public String deleteEmployeeById(int id)
    {
        employeerepository.deleteById(id);

        return "Employee with id " + id +" Successfully Deleted";
    }

    public Employee updateEmployee(Employee emp)
    {
        Employee existingemp = employeerepository.findById(emp.getId()).orElse(null);

        existingemp.setId(emp.getId());
        existingemp.setName(emp.getName());
        existingemp.setAge(emp.getAge());
        existingemp.setDept(emp.getDept());

       return  employeerepository.save(existingemp);
    }



}
