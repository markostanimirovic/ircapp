/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vagrant
 */
public class ListaPrograma {
    
    private static ListaPrograma objekat;
    
    private List<Program> listaPrograma;

    private ListaPrograma() {
        listaPrograma = new ArrayList<>();
        
        listaPrograma.add(new Program(1, "NetBeans", "choco install netbeans-jee", "sudo apt-get install netbeans"));
        listaPrograma.add(new Program(2, "Eclipse", "choco install eclipse", "sudo apt-get install -y eclipse"));
        listaPrograma.add(new Program(3, "Git", "choco install git", "sudo apt-get install git"));
        
        for (int i = 0; i < 100; i++) {
            listaPrograma.add(new Program(i+4, "Git", "choco install git", "sudo apt-get install git"));
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
