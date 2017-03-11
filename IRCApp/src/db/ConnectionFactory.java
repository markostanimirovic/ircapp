/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import util.Constantes;
import util.EnumConnectionType;

/**
 *
 * @author vagrant
 */
public class ConnectionFactory {
    
    private static Connection connection;
    
    public static Connection makeConnection(EnumConnectionType type) throws IOException, SQLException{
        if(connection != null){
            return connection;
        } else {
            connection = getConnection(type);
        }
        return connection;
    }

    private static Connection getConnection(EnumConnectionType type) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("db.config"));
        
        switch(type) {
            
            case DRIVER_MANAGER:
                return DriverManager.getConnection(
                        properties.getProperty(Constantes.DB_CONFIG_URL),
                        properties.getProperty(Constantes.DB_CONFIG_USERNAME), 
                        properties.getProperty(Constantes.DB_CONFIG_PASSWORD)
                );
            case DATASOURCE:
                MysqlDataSource mysql_data_source = new MysqlDataSource();
                mysql_data_source.setURL(properties.getProperty(Constantes.DB_CONFIG_URL));
                mysql_data_source.setUser(properties.getProperty(Constantes.DB_CONFIG_USERNAME));
                mysql_data_source.setPassword(properties.getProperty(Constantes.DB_CONFIG_PASSWORD));
                return mysql_data_source.getConnection();
            case DRIVER:
                Driver driver = DriverManager.getDriver(properties.getProperty(Constantes.DB_CONFIG_URL));
                Properties db_properties = new Properties();
                db_properties.put("user", properties.getProperty("username"));
                db_properties.put("password", properties.getProperty("username"));
                return driver.connect(properties.getProperty(Constantes.DB_CONFIG_URL), db_properties);
            default:
                return null;
        }
    }
      
}
