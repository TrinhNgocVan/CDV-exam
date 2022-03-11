package com.aptech.t2004e.jax_ws.repository;


import com.aptech.t2004e.jax_ws.entity.ExamEntity;
import com.aptech.t2004e.jax_ws.utils.ConnectionHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamRepo {
    private Connection conn;

    public ExamRepo() {
        conn = ConnectionHelper.getConnection();
    }

    public List<ExamEntity> findAll() throws SQLException {
        List<ExamEntity> products = new ArrayList<>();
        PreparedStatement stmt = conn.prepareStatement("select * from products where status = ?");
        stmt.setInt(1, 1);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double price = rs.getInt("price");
            int status = rs.getInt("status");
            products.add(new ExamEntity(id, name, price, status));
        }
        return products;
    }

    public ExamEntity findById(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from products where status = ? and id = ?");
        stmt.setInt(1, 1);
        stmt.setInt(2, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String name = rs.getString("name");
            double price = rs.getInt("price");
            int status = rs.getInt("status");
            return new ExamEntity(id, name, price, status);
        }
        return null;
    }

    public ExamEntity save(ExamEntity product) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("insert into products (name, price, status) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, product.getName());
        stmt.setDouble(2, product.getPrice());
        stmt.setInt(3, product.getStatus());
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            ResultSet resultSetGeneratedKeys = stmt.getGeneratedKeys();
            if (resultSetGeneratedKeys.next()) {
                int id = resultSetGeneratedKeys.getInt(1);
                product.setId(id);
                return product;
            }
        }
        return null;
    }

    public ExamEntity update(int id, ExamEntity updateProduct) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("update products set name = ?, price = ?, status = ? where id = ?");
        stmt.setString(1, updateProduct.getName());
        stmt.setDouble(2, updateProduct.getPrice());
        stmt.setInt(3, updateProduct.getStatus());
        stmt.setInt(4, id);
        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            updateProduct.setId(id);
            return updateProduct;
        }
        return null;
    }

    public boolean delete(int id) throws SQLException {
        PreparedStatement stmtDelete = conn.prepareStatement("delete from products where id = ?");
        stmtDelete.setInt(1, id);
        int affectedRows = stmtDelete.executeUpdate();
        if (affectedRows > 0) {
            return true;
        }
        return false;
    }
}
