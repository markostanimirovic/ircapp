/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domen.Administrator;
import domen.Program;
import java.util.List;

/**
 *
 * @author sarda.edis
 */
public abstract class DaoAdministrator {
    
    protected final String tableName = "administrators";
    
    public abstract List<Administrator> getAll();
    public abstract Administrator find(String username, String password) throws Exception;
    public abstract void save(Administrator admin);
    public abstract void delete(Administrator admin);
    public abstract void update(Administrator admin);
    
}
