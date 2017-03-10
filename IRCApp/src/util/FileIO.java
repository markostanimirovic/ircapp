/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

/**
 *
 * @author ircclient
 */
public class FileIO {

    public static void promeniVagrantFajl(String putanja, boolean isWindows) {

        File file = new File(putanja + "\\Vagrantfile");

        while (!file.exists())
                ;

        System.out.println(file.toString());

        String ekstenzijaScriptFajla = "";
        if (isWindows) {
            ekstenzijaScriptFajla = "ps1";
        } else {
            ekstenzijaScriptFajla = "sh";
        }

        if (file.exists()) {
            try {
                RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                String pomeraj = "end" + System.lineSeparator();
                raf.seek(raf.length() - pomeraj.length());

                raf.writeBytes("  config.vm.provision \"shell\", path: \"script." + ekstenzijaScriptFajla + "\""
                        + System.lineSeparator() + "end");

                raf.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }

    static void napraviScriptFajlWindows(File file) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void napraviScriptFajlLinux(File file) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            String komande = "";

            out.print("apt-get install git-all");

            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
