/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;

/**
 *
 * @author ircclient
 */
public class Konzola {
    
    private static Konzola konzola;
    private static final String OS_LINUX = "";
    private static final String OS_WINDOWS = "";
    private static final String VMREPO = "";
    private static final String PUTANJA_DO_FOLDERA;
    private static boolean linux = false;
    
    static {
        konzola = new Konzola();
        PUTANJA_DO_FOLDERA = Kontroler.putanjaDoFoldera;
    }

    private Konzola() {
        
    }
    
    public static Konzola getKonzola() {
        return konzola;
    }
    
    public static void pokreniKonzolu() {
        String komande = "cmd /c start cmd.exe /k "
                + " \"cd " + PUTANJA_DO_FOLDERA 
                + " && vagrant init" + " " + Kontroler.getIzabranaVM().getIme()
                + " && vagrant up"
                + " " + (linux ? OS_LINUX : OS_WINDOWS)
                + "\" ";
        
        try {
            Process p = Runtime.getRuntime().exec(komande);
        } catch (IOException ex) {
            Logger.getLogger(Konzola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
