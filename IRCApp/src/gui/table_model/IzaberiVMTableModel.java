/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.table_model;

import domen.VirtuelnaMasina;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vagrant
 */
public class IzaberiVMTableModel extends AbstractTableModel {

    private List<VirtuelnaMasina> listaVirtuelnihMasina;
    private String[] columnNames = {"Redni broj", "Ime VM", "Opis"};

    public IzaberiVMTableModel() {
        listaVirtuelnihMasina = new ArrayList<>();

        listaVirtuelnihMasina.add(new VirtuelnaMasina(1, "Windows 10", "asdasdasdasdaqqwdqdqwdq"));
        listaVirtuelnihMasina.add(new VirtuelnaMasina(2, "Windows 7", "qefefwefewewfwef"));
        listaVirtuelnihMasina.add(new VirtuelnaMasina(3, "linux mint", "regregergergergerge"));
        listaVirtuelnihMasina.add(new VirtuelnaMasina(4, "ubuntu", "hrhrthrthrt"));
    }

    @Override
    public int getRowCount() {
        return (listaVirtuelnihMasina != null) ? listaVirtuelnihMasina.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VirtuelnaMasina vm = listaVirtuelnihMasina.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vm.getId();

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

}