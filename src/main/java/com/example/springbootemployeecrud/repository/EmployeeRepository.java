package com.example.springbootemployeecrud.repository;

import com.example.springbootemployeecrud.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findEmployeeByName(String name);
    Employee findEmployeeByDept(String name);
}
