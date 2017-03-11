/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DaoProgram;
import db.ConnectionFactory;
import domen.Program;
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
public class DaoProgramImpl extends DaoProgram{
    Connection connection;
    
    public DaoProgramImpl() throws IOException, SQLException{
        connection = ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
    }
    
    @Override
    public List<Program> getAllPrograms() {
        List<Program> programs_list = new ArrayList<>();
        String query = "SELECT * FROM programs";
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                Program program = getCurrentRow(rs);
                programs_list.add(program);
            }
            statement.close();
        } catch(SQLException ex) {
            return null;
        }
        return programs_list;
    }

    @Override
    public void saveProgram(Program program) {
        String query = "INSERT INTO programs(naziv, komanda_windows, komanda_linux, komanda_mac)" + "values(?, ?, ?, ?)";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, program.getIme());
            prepared_stat.setString(2, program.getKomanda_widnows());
            prepared_stat.setString(3, program.getKomanda_linux());
            prepared_stat.setString(4, program.getKomanda_mac());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteProgram(Program program) {
        String query = "DELETE FROM programs WHERE naziv = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, program.getIme());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateProgram(Program program) {
        String query = "UPDATE programs SET komanda_windows = ?, komanda_linux = ?, komanda_mac = ? WHERE naziv = ?";
        PreparedStatement prepared_stat;
        try {
            prepared_stat = connection.prepareStatement(query);
            prepared_stat.setString(1, program.getKomanda_widnows());
            prepared_stat.setString(2, program.getKomanda_linux());
            prepared_stat.setString(3, program.getKomanda_mac());
            prepared_stat.setString(4, program.getIme());
            prepared_stat.execute();
            prepared_stat.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Program getCurrentRow(ResultSet rs) throws SQLException {
        String ime = rs.getString("naziv");
        String komanda_windows = rs.getString("komanda_windows");
        String komanda_linux = rs.getString("komanda_linux");
        String komanda_mac = rs.getString("komanda_mac");
        return new Program(ime, komanda_windows, komanda_linux, komanda_mac);
    }
    
}
