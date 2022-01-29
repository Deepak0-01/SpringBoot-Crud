package com.example.springbootemployeecrud.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE_TBL")
public class Employee implements Serializable {

    @Id
    @GeneratedValue

    @Column(name="id")
    int id;
    @Column(name="name")
    String name;
    @Column(name="age")
    int age;
    @Column(name="dept")
    String dept;

    public Employee() {
    }

    public Employee(int id, String name, int age, String dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Employee(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
