/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vagrant
 */
public class ConnectionFactory {
    
    private static Connection conn;
    
    public static Connection createConnection() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("", "", "");
        }
        
        return conn;
    }
    
}
