/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoUserVMs;
import dao.DaoVM;
import dao.impl.DaoUserVMsImpl;
import dao.impl.DaoVMImpl;
import db.ConnectionFactory;
import domen.ListaPrograma;
import domen.Program;
import domen.User;
import domen.UserVMs;
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
import java.util.Collections;
import java.util.Comparator;
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

                proveriKonekcijuSaBazom();

                proveriUsera();
                glavnaForma = new GlavnaForma();

                generisiCheckBokseve();

                glavnaForma.setVisible(true);

                napraviIRCFoler();

            }

        });

    }

    private static void proveriKonekcijuSaBazom() {
        try {
            ConnectionFactory.makeConnection(EnumConnectionType.DRIVER_MANAGER);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(glavnaForma, "Problem pri konekciji sa bazom!");
        }
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
        List<Program> lista = ListaPrograma.getInstance().getListaPrograma();
        Collections.sort(lista, new Comparator<Program>() {
            @Override
            public int compare(Program o1, Program o2) {
                String s1 = o1.getIme().toLowerCase();
                String s2 = o2.getIme().toLowerCase();
                return strcmp(s1, s2);
            }

        });

        glavnaForma.generisiCheckBokseve(lista);
    }

    private static int strcmp(String s1, String s2) {
        int duzina = s1.length() > s2.length() ? s2.length() : s1.length();
        for (int i = 0; i < duzina; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
        }
        if (s1.length() > s2.length()) {
            return 1;
        } else {
            return -1;
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

            Collections.sort(listaVM, new Comparator<VirtuelnaMasina>() {
                @Override
                public int compare(VirtuelnaMasina o1, VirtuelnaMasina o2) {
                    String s1 = o1.getIme().toLowerCase();
                    String s2 = o2.getIme().toLowerCase();
                    return strcmp(s1, s2);
                }
            });
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
            String red = null;

            while ((red = reader.readLine()) != null) {
                if (red.startsWith("\u001B")) {
                    red = red.substring(3);
                }
                progresInstalacije.setTextJTxtAreaKonzola(red + "\n");
                System.out.println(red);
            }

            progresInstalacije.setNewNameForJbtnKonzola("Ok");
            sacuvajVirtuelnuMasinuZaKorisnika();
        } catch (Exception e) {
            progresInstalacije.setNewNameForJbtnKonzola("Greška");
            e.printStackTrace();
        }
        System.out.println("izasao");
    }

    public static boolean proveriDaLiSeUFolderuNalaziVagrantfile(String putanjaDoFoldera) {
        File f = new File(putanjaDoFoldera + "\\Vagrantfile");

        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void setEnabledGlavnaForma(boolean b) {
        glavnaForma.setEnabled(b);
    }

    private static void sacuvajVirtuelnuMasinuZaKorisnika() {
        DaoUserVMs dao = new DaoUserVMsImpl();
        dao.saveUserVMs(new UserVMs(new User(AKTIVNI_KLIJENT), izabranaVM.getIme(), putanjaDoFoldera));
    }

}
