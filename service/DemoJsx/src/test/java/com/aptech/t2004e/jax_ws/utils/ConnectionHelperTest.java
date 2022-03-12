package com.aptech.t2004e.jax_ws.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionHelperTest {

    @Test
    void getConnection() throws SQLException {
        Connection conn = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into product(product_name ,price , status) values('demo',10,1)");
        preparedStatement.execute();
    }
}