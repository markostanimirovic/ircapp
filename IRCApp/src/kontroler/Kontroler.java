/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoAdministrator;
import dao.DaoUserVMs;
import dao.DaoVM;
import dao.impl.DaoAdministratorImpl;
import dao.impl.DaoUserVMsImpl;
import dao.impl.DaoVMImpl;
import db.ConnectionFactory;
import domen.Administrator;
import domen.ListaPrograma;
import domen.Program;
import domen.User;
import domen.UserVMs;
import gui.modeli.SingleRootFileSystemView;
import domen.VirtuelnaMasina;
import gui.AdminLog;
import gui.GlavnaForma;
import gui.MojeMasine;
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
import util.InstallationThread;
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
    public static List<UserVMs> listaKorisnikovihMasina;
    public static final String AKTIVNI_KLIJENT;
    public static ProgresInstalacije progresInstalacije;
    public static Process p;
    public static MojeMasine mojeMasine;
    private static String korisnikovNazivVM;
    public static Thread thread;

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

    public static void autentifikacija(String text, String password) throws Exception {

        Administrator admin = null;
        try {
            DaoAdministrator daoAdministrator = new DaoAdministratorImpl();
            admin = daoAdministrator.find(text, password);
        } catch (Exception e) {
            throw e;
        }

        if (admin != null) {
            // korisnik je uneo ispravno korisnicko ime i sifru
            zatvoriAdminLog();
            glavnaForma.prikaziCardAdministracija();
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

        if (opcija == JFileChooser.APPROVE_OPTION && !fc.getSelectedFile().getName().endsWith("Documents") && !fc.getSelectedFile().getName().endsWith("IRC")) {
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

    public static void instalacija(String imeVirtuelneMasime, String korisnikov_Naziv_VM) {
        DaoUserVMsImpl dao = new DaoUserVMsImpl();
        if (dao.user_vm_name_exist(korisnikov_Naziv_VM)) {
            JOptionPane.showMessageDialog(
                    glavnaForma, "Naziv virtualne masine vec postoji. Odaberite novi naziv.",
                    "Greška", JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        korisnikovNazivVM = korisnikov_Naziv_VM;
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

    public static void pokreniInstalaciju(String komande, String poruka) {
        progresInstalacije = new ProgresInstalacije();
        progresInstalacije.setLocationRelativeTo(null);
        progresInstalacije.setVisible(true);
        if (!poruka.equalsIgnoreCase("instalacija je u toku..."))
                progresInstalacije.setSTOPFalse();
        try {
            p = Runtime.getRuntime().exec(komande);
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String red = "\n" + reader.readLine();
            while (red != null) {
                System.out.println(red);
                if (red.startsWith("\u001B")) {
                    red = red.substring(3);
                }
                progresInstalacije.setTextJTxtAreaKonzola(red + "\n");
                red = reader.readLine();
            }
            if (poruka.equalsIgnoreCase("Instalacija je u toku...")) {
                sacuvajVirtuelnuMasinuZaKorisnika();
            } else if (poruka.equalsIgnoreCase("Pokretanje virtuelne masine...")) {
//                proveriti da li se u bazi nalazi true u rdp koloni
                if (true) {
                    p = Runtime.getRuntime().exec("cmd /c \"" + " cd " + putanjaDoFoldera + " && vagrant rdp" + " && taskkill /f /im cmd.exe" + "\" ");
                }
            } else if (poruka.equalsIgnoreCase("Gasenje virtuelne masine...")) {
            }
            glavnaForma.setEnabled(true);
            progresInstalacije.dispose();
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

    public static void sacuvajVirtuelnuMasinuZaKorisnika() {
        DaoUserVMs dao = new DaoUserVMsImpl();
        dao.saveUserVMs(new UserVMs(new User(AKTIVNI_KLIJENT), izabranaVM.getIme(), putanjaDoFoldera, korisnikovNazivVM));
    }

    public static void pokreniMojeMasineProzor() {
        mojeMasine = new MojeMasine();
        mojeMasine.setVisible(true);
        mojeMasine.setLocationRelativeTo(null);

        ucitajMojeMasine();
    }

    public static void ucitajMojeMasine() {
        DaoUserVMs dao = new DaoUserVMsImpl();
        listaKorisnikovihMasina = dao.getAllUsersVMs();
        if (listaKorisnikovihMasina != null) {
            mojeMasine.ucitajMasine(listaKorisnikovihMasina);
        } else {
            JOptionPane.showMessageDialog(
                    null, "Trenutno nemate ni jednu virtuelnu masinu.",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public static List<UserVMs> vratiKorisnikoveVirtuelneMasine() {
        listaKorisnikovihMasina = new LinkedList<>();
        DaoUserVMs dao = new DaoUserVMsImpl();
        listaKorisnikovihMasina = dao.getAllUsersVMs();
        return listaKorisnikovihMasina;
    }

    public static void zatvoriMojeMasine() {
        mojeMasine.dispose();
    }

    public static void pokreniMasinuMojeMasine(String putanjaDoVM) {
        putanjaDoFoldera = putanjaDoVM;
        String komande = "cmd /c \"" + " cd " + putanjaDoVM + " && " + "vagrant up" + " && taskkill /f /im cmd.exe" + "\" ";
        Runnable runnable = new InstallationThread(komande, "Pokretanje virtuelne masine...");
        thread = new Thread(runnable);
        thread.start();
    }

    public static void zaustaviMasinuMojeMasine(String putanjaDoVM) {
        String komande = "cmd /c \"" + " cd " + putanjaDoVM + " && " + "vagrant halt" + " && taskkill /f /im cmd.exe" + "\" ";
        Runnable runnable = new InstallationThread(komande, "Gasenje virtuelne masine...");
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void obrisiMasinuMojeMasine(String putanjaDoVM) {
        System.out.println("poceo");
        try {
            p = Runtime.getRuntime().exec("cmd /c \"" + " cd " + putanjaDoVM + " && " + "vagrant halt" + " && taskkill /f /im cmd.exe" + "\" ");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("putanja: " + putanjaDoVM);
        DaoUserVMs dao = new DaoUserVMsImpl();
        dao.deleteUserVMs(putanjaDoVM);
        izbrisiFolder(putanjaDoVM);
        System.out.println("zavrsio");
    }

    public static void izbrisiFolder(String putanja) {
        File f = new File(putanja);
        obrisiFajloveIzFoldera(f);
    }

    private static void obrisiFajloveIzFoldera(File f) {
        if (f.isDirectory()) {
            for (File f1 : f.listFiles()) {
                obrisiFajloveIzFoldera(f1);
            }
        }
        f.delete();
        System.out.println("kraj");
    }

}
