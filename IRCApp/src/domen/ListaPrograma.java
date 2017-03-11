/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import dao.DaoProgram;
import dao.impl.DaoProgramImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vagrant
 */
public class ListaPrograma {
    
    private static ListaPrograma objekat;
    
    private List<Program> listaPrograma;

    private ListaPrograma() {
        try {
            DaoProgram dp = new DaoProgramImpl();
            listaPrograma = dp.getAllPrograms();
        } catch (IOException | SQLException ex) {
            Logger.getLogger(ListaPrograma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ListaPrograma getInstance() {
        if (objekat == null) {
            objekat = new ListaPrograma();
        }
        return objekat;
    }
    
    public void dodajProgram(Program p) {
        if (!listaPrograma.contains(p)) {
            listaPrograma.add(p);
        }
    }
    
    public void obrisiProgram(Program p) {
        try {
            listaPrograma.remove(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void obrisiProgram(int i) {
        try {
            listaPrograma.remove(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Program get(int i) {
        return listaPrograma.get(i);
    }
    
    public int size() {
        return listaPrograma.size();
    }

    public List<Program> getListaPrograma() {
        return listaPrograma;
    }
    
    public Program pronadjiProgramPoImenu(String text) {
        for (Program p : listaPrograma) {
            if (p.getIme().equals(text)) {
                return p;
            }
        }
        
        return null;
    }
    
}
