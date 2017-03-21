/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.impl.DaoUserVMsImpl;
import domen.User;
import domen.UserVMs;

/**
 *
 * @author colic.aleksandar
 */
public class Main {
    
    public static void main(String[] args) {
        dao.DaoUserVMs out = new DaoUserVMsImpl();
        //out.saveUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"));
        //out.deleteUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"));
        //out.updateUserVMs(new UserVMs(new User("furtula.filip"), "Test200", "C:\\putanja"), "C:\\Nova_Putanja");
        out.saveUserVMs(new UserVMs(new User("sarda.edis"), "Test300", "C:\\mirko\\putanja\\sws", "JavaSoft"));
        
    }
    
}
