/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoVM;
import dao.impl.DaoUserVMsImpl;
import dao.impl.DaoVMImpl;
import domen.User;
import domen.UserVMs;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author colic.aleksandar
 */
public class Main {
    
    public static void main(String[] args) {
        try {
           DaoVM dao = new DaoVMImpl();
            System.out.println(dao.has_rdp("test 2 w10"));
            //dao.DaoUserVMs out = new DaoUserVMsImpl();
            //out.saveUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"));
            //out.deleteUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"));
            //out.updateUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"), "C:\\Nova_Putanja");
            //out.saveUserVMs(new UserVMs(new User("sarda.edis"), "Test300", "C:\\mirko\\putanja\\sws", "JavaSoft"));
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
