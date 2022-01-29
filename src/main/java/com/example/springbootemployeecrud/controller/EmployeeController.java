package com.example.springbootemployeecrud.controller;


import com.example.springbootemployeecrud.CSVHelper;
import com.example.springbootemployeecrud.Entity.Employee;
import com.example.springbootemployeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.util.List;

@CrossOrigin("http://localhost:9191")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final  EmployeeService employeeservice;

    @Autowired
    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }

    @PostMapping("/add-employee")

    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeservice.addEmployee(employee);
    }

    @PostMapping("/add-listofemployees")

    public List<Employee> addEmployees( @RequestBody List<Employee> employees)
        {
            return employeeservice.addAllEmployees(employees);
        }

    @PostMapping("/csv/upload")
    public String uploadFile(@RequestBody MultipartFile file) {


        if (CSVHelper.hasCSVFormat(file)) {
            try {


                employeeservice.save(file);

               return "File Uploaded successfully";


            } catch (Exception e) {
              return  "Could not upload the file: " + file.getOriginalFilename() + "!";

            }
        }
        else
        {
            return "No File is processed " + file.getContentType();
        }




    }


        @GetMapping("/employee/{id}")

      public Employee findById(@PathVariable int id)
        {
            return employeeservice.getEmployeeById(id);
        }

    @Cacheable(value="persons" , key="#name")
    @GetMapping("/employee-name/{name}")

    public Employee findByName(@PathVariable String name)
    {
        return employeeservice.getEmployeeByName(name);
    }

    @GetMapping("/empolyee-dept/{name}")

    public Employee findByDept(@PathVariable String name)
    {
        return employeeservice.getEmployeeByDept(name);
    }
    @GetMapping("/allemployees")
    public List<Employee> findAllEmployees()
    {
        return employeeservice.getAllEmployees();
    }

    @PutMapping("/update")

    public Employee updateEmployee(@RequestBody Employee emp)
    {
        return employeeservice.updateEmployee(emp);
    }

    @DeleteMapping("/delete/{id}")

    public String deleteEmployee(@PathVariable int id)
    {
        return employeeservice.deleteEmployeeById(id);
    }



}
