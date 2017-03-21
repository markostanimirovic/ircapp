/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoAdministrator;
import db.ConnectionFactory;
import domen.Administrator;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.EnumConnectionType;

/**
 *
 * @author sarda.edis
 */
public class DaoAdministratorImpl extends DaoAdministrator {

    private Connection conn;

    public DaoAdministratorImpl() throws Exception {
        conn = ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    
    
    
    @Override
    public List<Administrator> getAll() {
        List<Administrator> administratori = new ArrayList<>();
        
        String query = "SELECT username, password, ime, prezime FROM " + tableName;
        
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                administratori.add(new Administrator(rs.getString("ime"), rs.getString("prezime"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException ex) {
            
        }
        
        
        return administratori;
    }
    
    @Override
    public Administrator find(String username, String password) {
        
        String query = "SELECT username, password, ime, prezime FROM " + tableName + " WHERE username='"+username.trim()+"' AND password='"+password.trim()+"'";
        
        
        Administrator admin = new Administrator();
        
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            int brojRedova = 0;
            
            while (rs.next()) {                
                // TODO: adassd
            }
            
        } catch (SQLException ex) {
            return null;
        }
        
        return admin;
        
    }

    @Override
    public void save(Administrator admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Administrator admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Administrator admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
