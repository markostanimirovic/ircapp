/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoVM;
import db.ConnectionFactory;
import domen.VirtuelnaMasina;
import java.io.IOException;
import java.sql.Connection;
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
public class DaoVMImpl extends DaoVM{
    Connection connection;
    
    public DaoVMImpl() throws IOException, SQLException{
        connection = ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    
    @Override
    public List<VirtuelnaMasina> getAllVM() {
        List<VirtuelnaMasina> vms_list = new ArrayList<>();
        String query = "SELECT * FROM virtual_machines";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                VirtuelnaMasina vm = getCurrentRow(rs);
                vms_list.add(vm);
            }
            statement.close();
        } catch(SQLException ex) {
            return null;
        }
        return vms_list;
    }

    @Override
    public void saveVM(VirtuelnaMasina vm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVM(VirtuelnaMasina vm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateVM(VirtuelnaMasina vm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private VirtuelnaMasina getCurrentRow(ResultSet rs) throws SQLException {
        String ime = rs.getString("naziv");
        String opis = rs.getString("opis");
        String operativniSistem = rs.getString("tip_os");
        return new VirtuelnaMasina(ime, opis, operativniSistem);
    }
    
}
