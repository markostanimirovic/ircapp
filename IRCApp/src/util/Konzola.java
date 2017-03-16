/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Program;
import gui.ProgresInstalacije;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author ircclient
 */
public class Konzola {

    private static final String OS_LINUX = "linux";
    private static final String OS_WINDOWS = "windows";
    private static final String OS_MAC = "mac";

    private static final String TASK_KILL = " && taskkill /f /im cmd.exe";
    private static final String VMREPO = "";
    private static String PUTANJA_DO_FOLDERA;
    private static final String VAGRANT_UP = "vagrant up";
    private static final String VAGRANT_INIT = "vagrant init ";
    private static final String CMD_START = "cmd /c \"";
    private static final String CMD_END = "\" ";
    
    private static ProgresInstalacije progresInstalacije;

    /**
     * programi koje je korisnik izabrao za instalaciju
     */
    private static List<Program> listaIzabranihPrograma;

    /**
     * true - ako je izabrani OS windows, false - ako je izabrani OS linux
     */
    private static boolean isWindows;
    private static String imeBoxa;

    public static void setKonzola(String putanjaDoFoldera, String imeBoksa, List<Program> izabraniProgrami) {
        PUTANJA_DO_FOLDERA = putanjaDoFoldera;
        imeBoxa = imeBoksa;
        listaIzabranihPrograma = izabraniProgrami;
    }

    private Konzola() {
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

        pokreniProcesCMD(komande, 1);

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
        
        pokreniProgresInstalacije();

        pokreniProcesCMD(komande, 2);
    }

    private static void pokreniProcesCMD(String komande, int redni_broj) {
        try {
            Process p = Runtime.getRuntime().exec(komande);
            if (redni_broj > 1) {
                String red;
                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((red = reader.readLine()) != null) {
                    progresInstalacije.setTextJTxtAreaKonzola(red);
                }
                p.waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void pokreniProgresInstalacije() {
        progresInstalacije = new ProgresInstalacije(kontroler.Kontroler.glavnaForma, true);
        progresInstalacije.setVisible(true);
        progresInstalacije.setTextJTxtAreaKonzola("CQAO!");
    }

}
