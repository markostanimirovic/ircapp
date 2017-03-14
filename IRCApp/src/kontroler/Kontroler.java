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
import util.SingleRootFileSystemView;
import domen.VirtuelnaMasina;
import gui.AdminLog;
import gui.GlavnaForma;
import gui.table_model.IzaberiVMTableModel;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
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
import util.Konzola;

/**
 *
 * @author vagrant
 */
public class Kontroler {

    private static GlavnaForma glavnaForma;
    private static AdminLog adminLog;
    private static IzaberiVMTableModel izaberiVMTableModel;
    public static String putanjaDoFoldera;
    private static VirtuelnaMasina izabranaVM;
    public static List<JCheckBox> listaCheckBoksevaProgrami;
    public static List<VirtuelnaMasina> listaVM;

    static {
        listaCheckBoksevaProgrami = new ArrayList<>();
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                glavnaForma = new GlavnaForma();

                generisiCheckBokseve();

                glavnaForma.setVisible(true);

                izaberiVMTableModel = glavnaForma.getIzaberiVMTableModel();

            }

        });

    }

    public static void zatvoriAplikaciju() {
        int izbor = JOptionPane.showConfirmDialog(glavnaForma,
                "Da li ste sigurni da zelite da zatvorite aplikaciju?", "",
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

    public static void card0Dalje(VirtuelnaMasina vm) {
        glavnaForma.getJtxtImeIzabraneVirtuelneMasine().setText(vm.getIme());
        glavnaForma.getJTxtOpisVM().setText(vm.getOpis());
        glavnaForma.prikaziCard1();
        izabranaVM = vm;
    }

    public static void pokreniVM() {

        int izbor = JOptionPane.showConfirmDialog(glavnaForma,
                "Potvrdite pokretanje VM", "Potvrda", JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            List<Program> izabraniProgrami = vratiListuIzabranihPrograma();
            Konzola.setKonzola(putanjaDoFoldera, izabranaVM.getIme(), izabraniProgrami);
            Konzola.pokreniKonzolu(izabranaVM.getOperativniSistem());
            JOptionPane.showMessageDialog(glavnaForma, "Instalacija je u toku...", "Instalacija", JOptionPane.INFORMATION_MESSAGE);
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

    public static VirtuelnaMasina getIzabranaVM() {
        return izabranaVM;
    }

    public static SingleRootFileSystemView getRootDirectory(File root) {
        return new SingleRootFileSystemView(root);
    }

    public static void dodajCheckBoksUListu(JCheckBox jcb) {
        listaCheckBoksevaProgrami.add(jcb);
    }

    public static String otvoriProzorZaIzborPutanje() {
        JFileChooser fc = new JFileChooser(new SingleRootFileSystemView(new File("C:\\")));
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
    
    public static List<VirtuelnaMasina> vratiListuVM() {       
        listaVM = new LinkedList<>();
        try {
            DaoVM dao = new DaoVMImpl();
            listaVM = dao.getAllVM();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaVM;        
    }

    public static void instalacija(String selectedItem) {
        for (VirtuelnaMasina vm : listaVM) {
            if(vm.getIme().equals(selectedItem)) {
                izabranaVM = vm;
            }
        }
        int izbor = JOptionPane.showConfirmDialog(glavnaForma,
                "Potvrdite pokretanje VM", "Potvrda", JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            List<Program> izabraniProgrami = vratiListuIzabranihPrograma();
            Konzola.setKonzola(putanjaDoFoldera, izabranaVM.getIme(), izabraniProgrami);
            Konzola.pokreniKonzolu(izabranaVM.getOperativniSistem());
            JOptionPane.showMessageDialog(glavnaForma, "Instalacija je u toku...", "Instalacija", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
