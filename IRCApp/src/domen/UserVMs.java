/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author filip
 */
public class UserVMs {
    
    private String naziv;
    private String path;
    private User user;
    
    public UserVMs(User user, String naziv, String path) {
        this.naziv = naziv;
        this.path = path;
        this.user = user;
    }
    
    public UserVMs(){
    
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "\nNaziv: "+getNaziv() + " \nPutanja: "+getPath()+ " \nUsername: "+getUser().getUsername();
    }
    
}
