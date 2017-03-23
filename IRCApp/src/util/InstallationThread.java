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
    private EnumTipAktivnosti aktivnost;

    public InstallationThread(String komande, EnumTipAktivnosti aktivnost) {
        this.komande = komande;
        this.aktivnost = aktivnost;
    }

    @Override
    public void run() {
        kontroler.Kontroler.pokreniInstalaciju(komande, aktivnost);
    }

}
