/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import gui.AdminLog;
import gui.GlavnaForma;
import gui.table_model.IzaberiVMTableModel;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author vagrant
 */
public class Kontroler {

    private static GlavnaForma glavnaForma;
    private static AdminLog adminLog;
    private static IzaberiVMTableModel izaberiVMTableModel;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                glavnaForma = new GlavnaForma();
                glavnaForma.setVisible(true);

                izaberiVMTableModel = glavnaForma.getIzaberiVMTableModel();

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

    public static void otvoriAdminLog() {
        if (adminLog == null) {
            adminLog = new AdminLog(glavnaForma, true);
            adminLog.setLocationRelativeTo(glavnaForma);
            adminLog.setVisible(true);
        }
    }

    public static void zatvoriAdminLog() {
        adminLog.dispose();
        adminLog = null;
    }

    public static void autentifikacija(String text, String password) {
        if (text.equals("vagrant") && password.equals("vagrant")) {
            glavnaForma.prikaziAdministraciju(true);
            zatvoriAdminLog();
        } else {
            JOptionPane.showMessageDialog(adminLog, "Uneli ste pogresne vrednosti! Pokusajte ponovo.", "Greska", JOptionPane.ERROR_MESSAGE);
            adminLog.praznaPolja();
        }
    }

    public static void search(String text) {
        izaberiVMTableModel.search(text);
    }

}
