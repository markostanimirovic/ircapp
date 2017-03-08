/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author ircclient
 */
public class FileIO {

    public static void vagrantConfig(String putanja) {

        File file = new File(putanja + "\\Vagrantfile");

        while (!file.exists());

        if (file.exists()) {
            String tekstIzVagrantFajla = vratiTekstIzVagrantFajla(file);
            String tekstZaNoviVagrantFile = generisiTekstZaNoviVagrantFile(tekstIzVagrantFajla);

            if (tekstZaNoviVagrantFile != null) {
                izmeniVagrantFile(file, tekstZaNoviVagrantFile);
            } else {
                // doslo je do greske u citanju fajla
            }
        }
    }

    private static String vratiTekstIzVagrantFajla(File file) {
        String tekstUFajlu = "";
        String redUFajlu = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            while ((redUFajlu = in.readLine()) != null) {
                tekstUFajlu = tekstUFajlu + redUFajlu + System.lineSeparator();
            }

            return tekstUFajlu;
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean izmeniVagrantFile(File file, String tekstZaNoviVagrantFile) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));

            out.print(tekstZaNoviVagrantFile);

            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static String generisiTekstZaNoviVagrantFile(String tekstIzVagrantFajla) {
        String tekstZaNoviVagrantFile = tekstIzVagrantFajla.substring(0, tekstIzVagrantFajla.length() - 5);
        tekstZaNoviVagrantFile += "  config.vm.provision \"shell\", path: \"script.sh\""+System.lineSeparator()+"end\n";
        return tekstZaNoviVagrantFile;
    }

}
