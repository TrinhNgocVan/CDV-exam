package com.aptech.t2004e.jax_ws.repository;

import com.aptech.t2004e.jax_ws.entity.Employee;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ExamRepoTest {
    EmployeeRepo employeeRepo = new EmployeeRepo() ;
    @Test
    void findAll() throws SQLException {
        employeeRepo.findAll();
    }

    @Test
    void findById() throws SQLException {
        employeeRepo.findById(1);
    }


    @Test
    void save() throws SQLException {
        employeeRepo.save(new Employee("trinh ngoc van" , 100000));
    }

    @Test
    void update() throws SQLException {
        employeeRepo.update(1 ,new Employee( "Trinh ngoc van have change" , 1000000));
    }

    @Test
    void delete() throws SQLException {
        employeeRepo.delete(2);
    }
}