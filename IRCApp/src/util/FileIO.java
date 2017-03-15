/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import domen.Program;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author ircclient
 */
public class FileIO {

    public static void promeniVagrantFajl(String putanja) {

        File file = new File(putanja + "\\Vagrantfile");

        while (!file.exists())
                ;

        System.out.println(file.toString());

        if (file.exists()) {
            try {
                RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                String pomeraj = "end" + System.lineSeparator();
                raf.seek(raf.length() - pomeraj.length());

                raf.writeBytes("  config.vm.provision \"shell\", path: \"script.ps1\""
                        + System.lineSeparator() + "end");

                raf.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }

    static void napraviScriptFajlWindows(File file, List<Program> listaIzabranihPrograma) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            out.println("iex ((new-object net.webclient).DownloadString('https://chocolatey.org/install.ps1'))");
            out.println("chocolatey feature enable -n allowGlobalConfirmation");
            
            for (Program p : listaIzabranihPrograma) {
                out.println(p.getKomanda_widnows());
            }
            
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void napraviScriptFajlLinux(File file, List<Program> listaIzabranihPrograma) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            out.println("sudo apt-get update -y");
            
            for (Program p : listaIzabranihPrograma) {
                out.println(p.getKomanda_linux());
            }
            
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean napraviIRCFolder() {
        File file = new File("C:\\IRC");
        return file.mkdir();
    }

}
