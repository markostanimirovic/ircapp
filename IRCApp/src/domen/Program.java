/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author vagrant
 */
public class Program {
    
    private long id;
    private String ime;
    private String komanda_widnows;
    private String komanda_linux;
    private String komanda_mac;

    public Program(String ime, String komanda_widnows, String komanda_linux, String komanda_mac) {
        this.ime = ime;
        this.komanda_widnows = komanda_widnows;
        this.komanda_linux = komanda_linux;
        this.komanda_mac = komanda_mac;
    }

    public Program() {
        ime = "";
        komanda_widnows = "";
        komanda_linux = "";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Program other = (Program) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getKomanda_mac() {
        return komanda_mac;
    }

    public void setKomanda_mac(String komanda_mac) {
        this.komanda_mac = komanda_mac;
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKomanda_widnows() {
        return komanda_widnows;
    }

    public void setKomanda_widnows(String komanda_widnows) {
        this.komanda_widnows = komanda_widnows;
    }

    public String getKomanda_linux() {
        return komanda_linux;
    }

    public void setKomanda_linux(String komanda_linux) {
        this.komanda_linux = komanda_linux;
    }

    @Override
    public String toString() {
        return "Naziv: "+getIme() + " Komanda windows: "+getKomanda_widnows() + " Komanda_linux: "+getKomanda_linux()+" Komanda_mac: "+getKomanda_mac();
    }
    
}
