/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import gui.ProgresInstalacije;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author filip
 */
public class InstallationThread implements Runnable {

    private String komande;

    public InstallationThread(String komande) {
        this.komande = komande;
    }

    @Override
    public void run() {
        kontroler.Kontroler.pokreniInstalaciju(komande);
    }

}
