package com.aptech.t2004e.jax_ws.repository;


import com.aptech.t2004e.jax_ws.entity.Employee;
import com.aptech.t2004e.jax_ws.utils.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    private Connection conn;

    public EmployeeRepo() {
        conn = ConnectionHelper.getConnection();
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> products = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("select * from employees ");
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double salary = rs.getInt("salary");
            products.add(new Employee(id, name, salary));
        }
        return products;
    }

    public Employee findById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from employees where  id = ?");
        stmt.setInt(1, 1);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            double salary = rs.getInt("salary");
            return new Employee(id, name, salary);
        }
        return null;
    }

    public Employee save(Employee employee) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into employees (name, salary) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, employee.getName());
        stmt.setDouble(2, employee.getSalary());
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            ResultSet resultSetGeneratedKeys = stmt.getGeneratedKeys();
            if (resultSetGeneratedKeys.next()) {
                int id = resultSetGeneratedKeys.getInt(1);
                employee.setId(id);
                return employee;
            }
        }
        return null;
    }

    public Employee update(int id, Employee employee) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("update employees set name = ?, salary = ? where id = ?");
        stmt.setString(1, employee.getName());
        stmt.setDouble(2, employee.getSalary());
        stmt.setInt(3, id);
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            employee.setId(id);
            return employee;
        }
        return null;
    }

    public boolean delete(int id) throws SQLException {
        PreparedStatement stmtDelete = conn.prepareStatement("delete from employees where id = ?");
        stmtDelete.setInt(1, id);
        int affectedRows = stmtDelete.executeUpdate();
        if (affectedRows > 0) {
            return true;
        }
        return false;
    }
}
