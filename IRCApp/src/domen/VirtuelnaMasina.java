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
public class VirtuelnaMasina {

    private long id;
    private String ime;
    private String opis;
    private String operativniSistem;

    public VirtuelnaMasina(String ime, String opis, String operativniSistem) {
        this();
        this.ime = ime;
        this.opis = opis;
        this.operativniSistem = operativniSistem;
    }

    public VirtuelnaMasina() {
    }

    @Override
    public String toString() {
        return "VirtuelnaMasina{" + "id=" + id + ", ime=" + ime + ", opis=" + opis + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }
    
    public String getOperativniSistem() {
        return operativniSistem;
    }

    public void setOperativniSistem(String operativniSistem) {
        this.operativniSistem = operativniSistem;
    }
    

}
