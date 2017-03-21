/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author filip
 */
public class InstallationThread implements Runnable {

    private String komande;
    private String poruka;

    public InstallationThread(String komande, String poruka) {
        this.komande = komande;
        this.poruka = poruka;
    }

    @Override
    public void run() {
        kontroler.Kontroler.pokreniInstalaciju(komande, poruka);
    }

}
