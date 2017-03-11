/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoProgram;
import dao.DaoVM;
import dao.impl.DaoProgramImpl;
import dao.impl.DaoVMImpl;
import domen.Program;
import domen.VirtuelnaMasina;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filip
 */
public class main {
    /*public static void main(String[] args) {
        try {
            DaoProgram program = new DaoProgramImpl();
            List<Program> programi = program.getAllPrograms();
            prikazi(programi);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public static void main(String[] args) {
        try {
            DaoVM vm = new DaoVMImpl();
            List<VirtuelnaMasina> vms = vm.getAllVM();
            prikazi_vm(vms);
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void prikazi(List<Program> ls) {
        for (Program l : ls) {
            System.out.println(l);
        }
    }
    
    private static void prikazi_vm(List<VirtuelnaMasina> ls) {
        for (VirtuelnaMasina l : ls) {
            System.out.println(l);
        }
    }
}
