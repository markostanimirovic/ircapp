/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.modeli;

import dao.DaoVM;
import dao.impl.DaoVMImpl;
import domen.VirtuelnaMasina;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

/**
 *
 * @author sarda.edis
 */
public class ListVMModel extends AbstractListModel {

    private List<VirtuelnaMasina> listaVM;

    public ListVMModel() {
        listaVM = new ArrayList<>();
        try {
            DaoVM daoVM = new DaoVMImpl();
            listaVM.addAll(daoVM.getAllVM());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public int getSize() {
       return listaVM.size();
    }

    @Override
    public Object getElementAt(int i) {
        return listaVM.get(i);
    }
    
    
    
}
