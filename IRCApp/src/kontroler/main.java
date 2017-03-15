/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dao.DaoUser;
import dao.DaoUserVMs;
import dao.impl.DaoUserImpl;
import dao.impl.DaoUserVMsImpl;
import domen.User;
import domen.UserVMs;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author filip
 */
public class main {
    /*public static void main(String[] args) {
        try {
            DaoUser user = new DaoUserImpl();
            System.out.println(user.getUser().getUsername());
            prikazi(user.getAllUsers());
            
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    public static void main(String[] args) {
        DaoUserVMs user_vm = new DaoUserVMsImpl();
        prikazi2(user_vm.getAllUsersVMs());
        user_vm.saveUserVMs(new UserVMs("win-php-box", "C:\\Users\\sarda.edis\\NetbeansProject", new User("filip")));
        System.out.println("Novi prikqaz:");
        prikazi2(user_vm.getAllUsersVMs());
        
    }

    private static void prikazi(List<User> allUsers) {
        System.out.println("LISTA KORISNIKA:");
        for (User user : allUsers) {
            System.out.println(user.getUsername());
        }
    }

    private static void prikazi2(List<UserVMs> allUsersVMs) {
        System.out.println("Lista Virtualnih Masina:");
        for (UserVMs allUsersVM : allUsersVMs) {
            System.out.println(allUsersVM);
        }
    }
}
