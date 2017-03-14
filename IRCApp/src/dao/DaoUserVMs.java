/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domen.UserVMs;
import java.util.List;

/**
 *
 * @author filip
 */
public abstract class DaoUserVMs {
    public abstract List<UserVMs> getAllUsersVMs();
    public abstract UserVMs getUserVMs();
    public abstract void saveUserVMs(UserVMs user_vms);
    public abstract void deleteUserVMs(UserVMs user_vms);
    public abstract void updateUserVMs(UserVMs user_vms);
}
