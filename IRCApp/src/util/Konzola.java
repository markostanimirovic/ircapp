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
    private static final String OS_LINUX = "linux";
    private static final String OS_WINDOWS = "windows";
    private static final String VMREPO = "";
    private static String PUTANJA_DO_FOLDERA;
    private static final String VAGRANT_UP = "vagrant up";
    private static final String VAGRANT_INIT = "vagrant init ";
    private static final String CMD_START = "cmd /c start cmd.exe /k \"";
    private static final String CMD_END = "\" ";
    
    private static String imeBoxa;
    
    private static boolean linux = false;
    
    static {
        konzola = new Konzola();
    }

    public static void setKonzola(String putanjaDoFoldera, String ime) {
        PUTANJA_DO_FOLDERA = putanjaDoFoldera;
        imeBoxa = ime;
    }

    private Konzola() {
        
    }
    
    public static Konzola getKonzola() {
        return konzola;
    }
    
    public static void pokreniKonzolu(String operativniSistem) {
        if (operativniSistem.equals(OS_WINDOWS))
            pokreniKonzoluZaWindowsBox();
        else
            pokreniKonzoluZaLinuxBox();
    }
    
    public static void pokreniKonzoluZaWindowsBox() {
        String komande = CMD_START
                
                + " cd " + PUTANJA_DO_FOLDERA 
                + " && " + VAGRANT_INIT + imeBoxa
                + " && " + VAGRANT_UP
                
                        + CMD_END;
        
        try {
            Process p = Runtime.getRuntime().exec(komande);
        } catch (IOException ex) {
            Logger.getLogger(Konzola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void pokreniKonzoluZaLinuxBox() {
        
    }
    
}
