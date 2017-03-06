/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import gui.GlavnaForma;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author vagrant
 */
public class Kontroler {
    
    private static GlavnaForma glavnaForma;
    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                glavnaForma = new GlavnaForma();
                glavnaForma.setVisible(true);
                
            }
        });
        
    }
    
    public static void zatvoriAplikaciju() {
        int izbor = JOptionPane.showConfirmDialog(glavnaForma, "Da li ste sigurni da zelite da zatvorite aplikaicju?", "", JOptionPane.YES_OPTION);
        
        if (izbor == JOptionPane.YES_OPTION) {
            glavnaForma.dispose();
            System.exit(0);
        }
    }
    
}
