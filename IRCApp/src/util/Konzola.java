/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;

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

    private static boolean isWindows;

    private static String imeBoxa;

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
//        if (operativniSistem.equals(OS_WINDOWS)) {
//            isWindows = true;
//            pokreniKonzoluZaWindowsBox();
//        } else {
//            isWindows = false;
//            pokreniKonzoluZaLinuxBox();
//        }

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
                //               + " && taskkill /f /im cmd.exe"
                + CMD_END;
        try {
            Process p = Runtime.getRuntime().exec(komande);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileIO.promeniVagrantFajl(PUTANJA_DO_FOLDERA, isWindows);
        File file = new File(PUTANJA_DO_FOLDERA + "\\script.ps1");
        if (isWindows) {
            FileIO.napraviScriptFajlWindows(file);
        } else {
            FileIO.napraviScriptFajlLinux(file);
        }

        komande = CMD_START
                + " cd " + PUTANJA_DO_FOLDERA
                + " && " + VAGRANT_UP
                //                + " && taskkill /f /im cmd.exe"
                + CMD_END;

        try {
            while (!file.exists())
                ;
            Process p = Runtime.getRuntime().exec(komande);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pokreniKonzoluZaLinuxBox() {
        String komande = CMD_START
                + " cd " + PUTANJA_DO_FOLDERA
                + " && " + VAGRANT_INIT + imeBoxa
                //                + " && " + VAGRANT_UP +
                //               + " && taskkill /f /im cmd.exe"
                + CMD_END;

        try {
            Process p = Runtime.getRuntime().exec(komande);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
