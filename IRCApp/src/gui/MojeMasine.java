/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.UserVMs;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author stanimirovic.marko
 */
public class MojeMasine extends javax.swing.JFrame {

    /**
     * Creates new form MojeMasine
     */
    public MojeMasine() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Kontroler.zatvoriMojeMasine();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmnRefresh = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlMojeMasine = new javax.swing.JList<>();
        jbtnPokreni = new javax.swing.JButton();
        jbtnZaustavi = new javax.swing.JButton();
        jbtnObrisi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtPutanja = new javax.swing.JTextField();

        jmnRefresh.setText("Refresh");
        jmnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnRefreshActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmnRefresh);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Moje mašine");
        setResizable(false);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlMojeMasine.setBackground(new java.awt.Color(240, 240, 240));
        jlMojeMasine.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlMojeMasine.setModel(dlm);
        jlMojeMasine.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlMojeMasine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMojeMasineMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlMojeMasineMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jlMojeMasine);

        jbtnPokreni.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtnPokreni.setText("Pokreni");
        jbtnPokreni.setMaximumSize(new java.awt.Dimension(84, 29));
        jbtnPokreni.setMinimumSize(new java.awt.Dimension(84, 29));
        jbtnPokreni.setPreferredSize(new java.awt.Dimension(84, 29));
        jbtnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPokreniActionPerformed(evt);
            }
        });

        jbtnZaustavi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtnZaustavi.setText("Zaustavi");
        jbtnZaustavi.setPreferredSize(new java.awt.Dimension(84, 29));
        jbtnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnZaustaviActionPerformed(evt);
            }
        });

        jbtnObrisi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtnObrisi.setText("Obriši");
        jbtnObrisi.setMaximumSize(new java.awt.Dimension(84, 29));
        jbtnObrisi.setPreferredSize(new java.awt.Dimension(84, 29));
        jbtnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnObrisiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Putanja:");

        jtxtPutanja.setEditable(false);
        jtxtPutanja.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtPutanja.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnPokreni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jbtnZaustavi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtPutanja)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jtxtPutanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnPokreni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnZaustavi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPokreniActionPerformed
        String izabranaVM = jlMojeMasine.getSelectedValue();
        if (izabranaVM == null) {
            JOptionPane.showMessageDialog(
                    this, "Morate da odaberete masinu za pokretanje!",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            Kontroler.pokreniMasinuMojeMasine(izabranaVM);
        }
    }//GEN-LAST:event_jbtnPokreniActionPerformed

    private void jbtnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnZaustaviActionPerformed
        String izabranaVM = jlMojeMasine.getSelectedValue();
        if (izabranaVM == null) {
            JOptionPane.showMessageDialog(
                    this, "Morate da odaberete masinu koju zelite da zaustavite!",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            Kontroler.zaustaviMasinuMojeMasine(izabranaVM);
        }
    }//GEN-LAST:event_jbtnZaustaviActionPerformed

    private void jbtnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnObrisiActionPerformed
        String izabranaVM = jlMojeMasine.getSelectedValue();
        if (izabranaVM == null) {
            JOptionPane.showMessageDialog(
                    this, "Morate da odaberete masinu koju zelite da obrisete!",
                    "Upozorenje", JOptionPane.WARNING_MESSAGE);
        } else {
            Kontroler.obrisiMasinuMojeMasine(izabranaVM);
        }
    }//GEN-LAST:event_jbtnObrisiActionPerformed

    private void jlMojeMasineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMojeMasineMouseClicked
        List<UserVMs> l = new LinkedList<>();
        l = Kontroler.vratiKorisnikoveVirtuelneMasine();
        for (UserVMs userVMs : l) {
            if(userVMs.getNaziv().equals(jlMojeMasine.getSelectedValue())) {
                jtxtPutanja.setText(userVMs.getPath());
            }
        }
    }//GEN-LAST:event_jlMojeMasineMouseClicked

    private void jmnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnRefreshActionPerformed
        dlm.clear();
        Kontroler.ucitajMojeMasine();
    }//GEN-LAST:event_jmnRefreshActionPerformed

    private void jlMojeMasineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMojeMasineMouseReleased
        if(evt.isPopupTrigger()) {
            jPopupMenu1.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_jlMojeMasineMouseReleased

    /**
     * @param args the command line arguments
     */
    DefaultListModel dlm = new DefaultListModel();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnObrisi;
    private javax.swing.JButton jbtnPokreni;
    private javax.swing.JButton jbtnZaustavi;
    private javax.swing.JList<String> jlMojeMasine;
    private javax.swing.JMenuItem jmnRefresh;
    private javax.swing.JTextField jtxtPutanja;
    // End of variables declaration//GEN-END:variables

    
    public void ucitajMasine(List<UserVMs> listaKorisnikovihMasina) {
        for (UserVMs masina : listaKorisnikovihMasina) {
            dlm.addElement(masina.getNaziv());
        }
    }
}