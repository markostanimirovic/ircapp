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
        String query = "INSERT INTO virtual_machines(naziv, opis, tip_os)" + "values(?, ?, ?)";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, vm.getIme());
            prepared_stat.setString(2, vm.getOpis());
            prepared_stat.setString(3, vm.getOperativniSistem());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteVM(VirtuelnaMasina vm) {
        String query = "DELETE FROM virtual_machines WHERE naziv = ?";
        PreparedStatement prepared_stat;
        try {
           prepared_stat = connection.prepareStatement(query);
           prepared_stat.setString(1, vm.getIme());
           prepared_stat.execute();
           prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public void updateVM(VirtuelnaMasina vm) {
        String query = "UPDATE virtual_machines SET opis = ?, tip_os = ? WHERE naziv = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, vm.getOpis());
            prepared_stat.setString(2, vm.getOperativniSistem());
            prepared_stat.setString(3, vm.getIme());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private VirtuelnaMasina getCurrentRow(ResultSet rs) throws SQLException {
        String ime = rs.getString("naziv");
        String opis = rs.getString("opis");
        String operativniSistem = rs.getString("tip_os");
        return new VirtuelnaMasina(ime, opis, operativniSistem);
    }
    
}
