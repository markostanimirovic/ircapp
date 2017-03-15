/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Program;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author ircclient
 */
public class Konzola {

    private static Konzola konzola;
    
    private static List<Program> listaIzabranihPrograma;
    
    private static final String OS_LINUX = "linux";
    private static final String OS_WINDOWS = "windows";
    private static final String OS_MAC = "mac";
    private static final String TASK_KILL = " && taskkill /f /im cmd.exe";
    private static final String VMREPO = "";
    private static String PUTANJA_DO_FOLDERA;
    private static final String VAGRANT_UP = "vagrant up";
    private static final String VAGRANT_INIT = "vagrant init ";
    private static final String CMD_START = "cmd /c start cmd.exe /k \"";
    private static final String CMD_END = "\" ";

    private static boolean isWindows;
    private static String imeBoxa;

    static {
        konzola = new Konzola();
    }

    public static void setKonzola(String putanjaDoFoldera, String ime, List<Program> izabraniProgrami) {
        PUTANJA_DO_FOLDERA = putanjaDoFoldera;
        imeBoxa = ime;
        listaIzabranihPrograma = izabraniProgrami;
    }
    
    private Konzola() {

    }

    public static Konzola getKonzola() {
        return konzola;
    }

    public static void pokreniKonzolu(String operativniSistem) {
        if (operativniSistem.equalsIgnoreCase(OS_WINDOWS)) {
            isWindows = true;
        } else {
            isWindows = false;
        }

        pokreniKonzolu();
    }

    private static void pokreniKonzolu() {
        String komande = CMD_START
                + " cd " + PUTANJA_DO_FOLDERA
                + " && " + VAGRANT_INIT + imeBoxa
                //                + " && " + VAGRANT_UP +
                + TASK_KILL
                + CMD_END;
        
        pokreniProcesCMD(komande);

        FileIO.promeniVagrantFajl(PUTANJA_DO_FOLDERA);
        File file = new File(PUTANJA_DO_FOLDERA + "\\script.ps1");
        if (isWindows) {
            FileIO.napraviScriptFajlWindows(file, listaIzabranihPrograma);
        } else {
            FileIO.napraviScriptFajlLinux(file, listaIzabranihPrograma);
        }

        komande = CMD_START
                + " cd " + PUTANJA_DO_FOLDERA
                + " && " + VAGRANT_UP
                + TASK_KILL
                + CMD_END;
        
        while (!file.exists())
                ;
        pokreniProcesCMD(komande);
    }

    private static void pokreniProcesCMD(String komande) {
        try {
            Process p = Runtime.getRuntime().exec(komande);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
