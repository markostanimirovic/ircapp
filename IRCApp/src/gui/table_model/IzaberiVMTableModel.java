/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.table_model;

import dao.DaoVM;
import dao.impl.DaoVMImpl;
import domen.VirtuelnaMasina;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vagrant
 */
public class IzaberiVMTableModel extends AbstractTableModel {

    private List<VirtuelnaMasina> listaVirtuelnihMasina;
    private List<VirtuelnaMasina> listaSvihVM;

    private String[] columnNames = {"Redni broj", "Ime VM", "Opis"};

    public IzaberiVMTableModel() {
        listaVirtuelnihMasina = new ArrayList<>();
        listaSvihVM = new ArrayList<>();
        
        try {
            DaoVM dao = new DaoVMImpl();
            listaSvihVM = dao.getAllVM();
            listaVirtuelnihMasina.addAll(listaSvihVM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return listaVirtuelnihMasina.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VirtuelnaMasina vm = listaVirtuelnihMasina.get(rowIndex);

        switch (columnIndex) {
            case 1:
                return vm.getIme();

            case 2:
                return vm.getOpis();

            default:
                return "/";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void dodajVM(VirtuelnaMasina vm) {
        if (vm != null) {
            listaVirtuelnihMasina.add(vm);
            fireTableDataChanged();
        }
    }

    public VirtuelnaMasina vratiVM(int index) {
        return listaVirtuelnihMasina.get(index);
    }

    private void preuzmiSveVMIzBaze() {

    }

    public void search(String text) {
        text = text.toLowerCase();

        listaVirtuelnihMasina.removeAll(listaVirtuelnihMasina);
        listaVirtuelnihMasina.addAll(listaSvihVM);

        if (text.equals("")) {
            // pa nista
        } else {
            for (int i = 0; i < listaVirtuelnihMasina.size(); i++) {
                VirtuelnaMasina vm = listaVirtuelnihMasina.get(i);

                if (!vm.getIme().toLowerCase().contains(text)) {
                    listaVirtuelnihMasina.remove(i);
                    i--;
                }
            }
        }

        fireTableDataChanged();
    }

}
