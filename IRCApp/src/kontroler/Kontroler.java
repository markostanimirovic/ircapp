/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoVM;
import dao.impl.DaoVMImpl;
import db.ConnectionFactory;
import domen.ListaPrograma;
import domen.Program;
import gui.modeli.SingleRootFileSystemView;
import domen.VirtuelnaMasina;
import gui.AdminLog;
import gui.GlavnaForma;
import gui.ProgresInstalacije;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import util.EnumConnectionType;
import util.FileIO;
import util.Konzola;

/**
 *
 * @author vagrant
 */
public class Kontroler {

    public static GlavnaForma glavnaForma;
    private static AdminLog adminLog;
    public static String putanjaDoFoldera;
    private static VirtuelnaMasina izabranaVM;
    public static List<JCheckBox> listaCheckBoksevaProgrami;
    public static List<VirtuelnaMasina> listaVM;
    public static final String AKTIVNI_KLIJENT;
    public static ProgresInstalacije progresInstalacije;

    static {
        listaCheckBoksevaProgrami = new ArrayList<>();
        AKTIVNI_KLIJENT = System.getProperty("user.name");
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                proveriUsera();
                glavnaForma = new GlavnaForma();

                generisiCheckBokseve();

                glavnaForma.setVisible(true);

                napraviIRCFoler();

            }

        });

    }

    public static void zatvoriAplikaciju() {
        int izbor = JOptionPane.showConfirmDialog(glavnaForma,
                "Da li ste sigurni da želite da zatvorite aplikaciju?", "Izlaz",
                JOptionPane.YES_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            try {
                ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER).close();
                glavnaForma.dispose();
                System.exit(0);
            } catch (IOException | SQLException ex) {
                Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void generisiCheckBokseve() {
        glavnaForma.generisiCheckBokseve(ListaPrograma.getInstance().getListaPrograma());
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
            //dodaj kod
            zatvoriAdminLog();
        } else {
            JOptionPane.showMessageDialog(adminLog, "Uneli ste pogrešne vrednosti! Pokušajte ponovo.", "Greška", JOptionPane.ERROR_MESSAGE);
            adminLog.praznaPolja();
        }
    }

    public static List<Program> vratiListuIzabranihPrograma() {

        List<Program> izabraniProgrami = new ArrayList<>();

        for (JCheckBox jcb : listaCheckBoksevaProgrami) {
            if (jcb.isSelected()) {
                Program p = ListaPrograma.getInstance().pronadjiProgramPoImenu(jcb.getText());
                izabraniProgrami.add(p);
            }
        }

        return izabraniProgrami;
    }

    public static String namestiPutanjuDoFoldera(String putanja) {
        putanjaDoFoldera = putanja;
        return putanjaDoFoldera;
    }

    public static SingleRootFileSystemView getRootDirectory(File root) {
        return new SingleRootFileSystemView(root);
    }

    public static void dodajCheckBoksUListu(JCheckBox jcb) {
        listaCheckBoksevaProgrami.add(jcb);
    }

    public static String otvoriProzorZaIzborPutanje() {
        JFileChooser fc = new JFileChooser(new SingleRootFileSystemView(new File("C:\\Users\\" + AKTIVNI_KLIJENT + "\\Documents")));
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int opcija = fc.showOpenDialog(glavnaForma);

        String putanja = "";

        if (opcija == JFileChooser.APPROVE_OPTION) {
            putanja = fc.getSelectedFile().getAbsolutePath();
        } else {
            putanja = "";
        }

        return putanja;
    }

    public static List<VirtuelnaMasina> vratiListuVMIzBaze() {
        listaVM = new LinkedList<>();
        try {
            DaoVM dao = new DaoVMImpl();
            listaVM = dao.getAllVM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVM;
    }

    public static void instalacija(String imeVirtuelneMasime) {
        izabranaVM = pronadjiVMNaOsnovuImena(imeVirtuelneMasime);

        int izbor = JOptionPane.showConfirmDialog(glavnaForma,
                "Potvrdite pokretanje virtuelne mašine.", "Potvrda", JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            List<Program> izabraniProgrami = vratiListuIzabranihPrograma();

            Konzola.setKonzola(putanjaDoFoldera, izabranaVM.getIme(), izabraniProgrami);
            Konzola.pokreniKonzolu(izabranaVM.getOperativniSistem());

        }
    }

    private static VirtuelnaMasina pronadjiVMNaOsnovuImena(String imeVM) {
        for (VirtuelnaMasina vm : listaVM) {
            if (vm.getIme().equals(imeVM)) {
                return vm;
            }
        }

        return null;
    }

    private static void napraviIRCFoler() {
        FileIO.napraviIRCFolder();
    }

    private static void proveriUsera() {
        if (AKTIVNI_KLIJENT.equals("ircclient")) {
            JOptionPane.showMessageDialog(
                    null, "Sa ovog naloga ne možete pristupiti aplikaciji!"
                    + " Molimo ulogujte se kao domenski korisnik.",
                    "Greška", JOptionPane.ERROR_MESSAGE
            );
            System.exit(0);
        }
    }

    public static void pokreniInstalaciju(String komande) {
        progresInstalacije = new ProgresInstalacije();
        progresInstalacije.setLocationRelativeTo(glavnaForma);
        progresInstalacije.setVisible(true);
        try {
            Process p = Runtime.getRuntime().exec(komande);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String red = reader.readLine();
            while (red != null) {
                progresInstalacije.setTextJTxtAreaKonzola(red + "\n");
                red = reader.readLine();
            }
            p.waitFor();
            System.out.println("KRAJ");
            progresInstalacije.setNewNameForJbtnKonzola("Ok");
        } catch (Exception e) {
            progresInstalacije.setNewNameForJbtnKonzola("Greska");
            e.printStackTrace();
        }
        System.out.println("izasao");
    }

}
