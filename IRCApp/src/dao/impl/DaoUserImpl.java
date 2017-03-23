/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoUser;
import db.ConnectionFactory;
import domen.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.EnumConnectionType;

/**
 *
 * @author filip
 */
public class DaoUserImpl extends DaoUser{

    private Connection connection;
    
    public DaoUserImpl() throws IOException, SQLException{
        connection = ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "Select * from users";
        Statement statement;
        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                User user = getCurrentRow(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        String query = "INSERT INTO users(username)" 
                + "values(?)";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, user.getUsername());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(User user) {
        String query = "DELETE FROM users WHERE username = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, user.getUsername());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateUser(User user) {
        // Nepotrebno zasad
        /*String query = "UPDATE users SET username = ? WHERE username = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, user.getUsername());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    @Override
    public User getUser() {
        String query = "SELECT * FROM users where username = ?";
        PreparedStatement prepared_stat;
        try{
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, kontroler.Kontroler.AKTIVNI_KLIJENT);
            ResultSet rs = prepared_stat.executeQuery();
            boolean find = rs.next();
            if (find) {
                return new User(rs.getString("username"));
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private User getCurrentRow(ResultSet rs) throws SQLException {
        String username = rs.getString("username");
        return new User(username);
    }
    
}
