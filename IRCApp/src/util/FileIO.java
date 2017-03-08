/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ircclient
 */
public class FileIO {

    public static void vagrantConfig(String putanja) {

        File file = new File(putanja + "\\Vagrantfile");
        
       System.out.println(file.toString());
        
        while (!file.exists())
                ;
        
        if (file.exists()) {
            try {
                BufferedReader IN = new BufferedReader(new FileReader(file));
                String rezultatIzFajla = "";
                String pom;
                while ((pom = IN.readLine()) != null)
                    rezultatIzFajla = rezultatIzFajla + pom + System.lineSeparator();
                
                System.out.println(rezultatIzFajla);
                IN.close();
                String upisUFajl = "";
                
                upisUFajl = rezultatIzFajla.substring(0, rezultatIzFajla.length() - 5);
                upisUFajl = upisUFajl + "  config.vm.provision \"shell\", path: \"script.sh\"\nend\n";
                System.out.println(upisUFajl);
                
                BufferedWriter out = new BufferedWriter(new FileWriter(file));
                
                out.flush();
                out.write(upisUFajl);
                
                out.close();
                

            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
