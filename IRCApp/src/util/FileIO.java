/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ircclient
 */
public class FileIO {

    public static void vagrantConfig(String putanja) {

        File file = new File(putanja + "\\Vagrantfile");

        while (!file.exists())
                ;

        System.out.println(file.toString());

        if (file.exists()) {
            try {
                RandomAccessFile raf = new RandomAccessFile(file, "rwd");
                String pomeraj = "end" + System.lineSeparator();
                raf.seek(raf.length() - pomeraj.length());
                raf.writeBytes("  config.vm.provision \"shell\", path: \"script.sh\""
                        + System.lineSeparator() + "end");
                raf.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        }
    }

    static void napraviScriptSH(File file) {
        try {
            if (!file.exists())
                file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
