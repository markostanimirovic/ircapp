/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.ListaPrograma;
import domen.Program;
import domen.VirtuelnaMasina;
import gui.AdminLog;
import gui.GlavnaForma;
import gui.table_model.IzaberiVMTableModel;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
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

    /**
     * Virtuelna masina koju je korisnik izabrao na pocetnom prozoru
     */
    private static VirtuelnaMasina izabranaVM;
    public static List<JCheckBox> listaCheckBokseva;

    
    static {
        listaCheckBokseva = new ArrayList<>();
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
        int izbor = JOptionPane.showConfirmDialog(glavnaForma, "Da li ste sigurni da zelite da zatvorite aplikaciju?", "", JOptionPane.YES_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            glavnaForma.dispose();
            System.exit(0);
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

    public static List<Program> vratiListuIzabranihPrograma() {

        List<Program> izabraniProgrami = new ArrayList<>();

        for (JCheckBox jcb : listaCheckBokseva) {
            if (jcb.isSelected()) {
                Program p = ListaPrograma.getInstance().pronadjiProgramPoImenu(jcb.getText());
                izabraniProgrami.add(p);
            }
        }

        return izabraniProgrami;
    }

    public static void pokreniVM() {
        List<Program> izabraniProgrami = vratiListuIzabranihPrograma();

        int izbor = JOptionPane.showConfirmDialog(glavnaForma, "Potvrdite pokretanje VM", "Potvrda", JOptionPane.YES_NO_OPTION);

        if (izbor == JOptionPane.YES_OPTION) {
            Konzola.setKonzola(putanjaDoFoldera, izabranaVM.getIme(), izabraniProgrami);
            Konzola.pokreniKonzolu(izabranaVM.getOperativniSistem());
            JOptionPane.showMessageDialog(glavnaForma, "Instalacija je u toku...", "Instalacija", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public static String NamestiPutanjuDoFoldera(String putanja) {
        putanjaDoFoldera = putanja;
        return putanjaDoFoldera;
    }

    public static VirtuelnaMasina getIzabranaVM() {
        return izabranaVM;
    }

//    public static void setIzabranaVM(VirtuelnaMasina izabranaVM) {
//        Kontroler.izabranaVM = izabranaVM;
//    }

    public static void dodajCheckBoksUListu(JCheckBox jcb) {
        listaCheckBokseva.add(jcb);
    }
}
