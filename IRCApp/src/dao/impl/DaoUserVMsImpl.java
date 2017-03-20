/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoUserVMs;
import db.ConnectionFactory;
import domen.User;
import domen.UserVMs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kontroler.Kontroler;
import util.EnumConnectionType;

/**
 *
 * @author filip
 */
public class DaoUserVMsImpl extends DaoUserVMs{
    
    Connection connection;
    
    public DaoUserVMsImpl() {
        try {
            connection = ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public List<UserVMs> getAllUsersVMs() {
        List<UserVMs> user_vms = new ArrayList<>();
        String query = "SELECT * FROM user_vm WHERE username = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, kontroler.Kontroler.AKTIVNI_KLIJENT);
            ResultSet rs = prepared_stat.executeQuery();
            while(rs.next()){                
                UserVMs vms = getCurrentRow(rs);
                user_vms.add(vms);
            }
            return user_vms;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public UserVMs getUserVMs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveUserVMs(UserVMs user_vms) {
        String query = "INSERT INTO user_vm(username, naziv, path)" 
                + "values(?, ?, ?)";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, user_vms.getUser().getUsername());
            prepared_stat.setString(2, user_vms.getNaziv());
            prepared_stat.setString(3, user_vms.getPath());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteUserVMs(UserVMs user_vms) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUserVMs(UserVMs user_vms) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private UserVMs getCurrentRow(ResultSet rs) throws SQLException {
        String naziv = rs.getString("naziv");
        String path = rs.getString("path");
        User user = new User(rs.getString("username"));
        return new UserVMs(user, naziv, path);

    }
    
}
