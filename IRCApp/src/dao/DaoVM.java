/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domen.VirtuelnaMasina;
import java.util.List;

/**
 *
 * @author filip
 */
public abstract class DaoVM {
    public abstract List<VirtuelnaMasina> getAllVM();
    public abstract void saveVM(VirtuelnaMasina vm);
    public abstract void deleteVM(VirtuelnaMasina vm);
    public abstract void updateVM(VirtuelnaMasina vm);
    public abstract boolean has_rdp(String vm_name) throws Exception;
}
