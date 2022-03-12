package org.aptech.t2004e.manager;

import org.aptech.t2004e.dto.EmployeeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeManagerTest {
    @Autowired
    EmployeeManager employeeManager ;
    @Test
    void gets() {
        System.err.println(employeeManager.gets());
    }

    @Test
    void delete() {
        System.err.println(employeeManager.delete(5));
    }

    @Test
    void getById() {
        System.err.println(employeeManager.getById(1));
    }

    @Test
    void create() {
        System.err.println(employeeManager.save(new EmployeeDto("Trịnh Đức Nhân" , 10)));
    }
    @Test
    void save() {
        System.err.println(employeeManager.save(new EmployeeDto(Long.valueOf(1),"Trịnh Đức Nhân" , 10)));
    }
}