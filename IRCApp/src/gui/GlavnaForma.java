/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Program;
import domen.VirtuelnaMasina;
import gui.modeli.IzaberiVMTableModel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import kontroler.Kontroler;

/**
 *
 * @author vagrant
 */
public class GlavnaForma extends javax.swing.JFrame {

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Kontroler.zatvoriAplikaciju();
            }

        });
        napuniListuVirtuelnimMasinama();
        prikaziAdministraciju(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblIzaberiVM = new javax.swing.JTable();
        jtxtPronadji = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jbtnCard0Dalje = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jpnlAdministracija = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbtnDodajVM = new javax.swing.JButton();
        jbtnIzmeniVM = new javax.swing.JButton();
        jbtnObrisiVM = new javax.swing.JButton();
        card1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtImeIzabraneVM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtAreaOpisVM = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jbtnCard1nazad = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        card0 = new javax.swing.JPanel();
        jpnlPutanja = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtPutanjaDoFoldera = new javax.swing.JTextField();
        jbtnIzaberiPutanjuDoFoldera = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jpnlCheckBoksevi = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jpnlVM = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtxtOpis = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        listVM = new java.awt.List();
        jpnlInstalacija = new javax.swing.JPanel();
        jbtnInstalacija = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        jtblIzaberiVM.setModel(new IzaberiVMTableModel());
        jScrollPane1.setViewportView(jtblIzaberiVM);

        jtxtPronadji.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtPronadjiKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Izaberite virtuelnu masinu");

        jbtnCard0Dalje.setText("Dalje...");
        jbtnCard0Dalje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCard0DaljeActionPerformed(evt);
            }
        });

        jLabel6.setText("Pronadji VM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnCard0Dalje, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtPronadji)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtPronadji, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnCard0Dalje)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administracija");

        jbtnDodajVM.setText("Dodaj virtuelnu masinu");

        jbtnIzmeniVM.setText("Izmeni");

        jbtnObrisiVM.setText("Obrisi VM");

        javax.swing.GroupLayout jpnlAdministracijaLayout = new javax.swing.GroupLayout(jpnlAdministracija);
        jpnlAdministracija.setLayout(jpnlAdministracijaLayout);
        jpnlAdministracijaLayout.setHorizontalGroup(
            jpnlAdministracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnlAdministracijaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlAdministracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnDodajVM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnIzmeniVM, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(jbtnObrisiVM, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpnlAdministracijaLayout.setVerticalGroup(
            jpnlAdministracijaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlAdministracijaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnDodajVM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnIzmeniVM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnObrisiVM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Izabrali ste VM:");

        jtxtImeIzabraneVM.setEditable(false);

        jLabel4.setText("Opis VM:");

        jScrollPane2.setEnabled(false);

        jtxtAreaOpisVM.setEditable(false);
        jtxtAreaOpisVM.setColumns(20);
        jtxtAreaOpisVM.setLineWrap(true);
        jtxtAreaOpisVM.setRows(5);
        jScrollPane2.setViewportView(jtxtAreaOpisVM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jtxtImeIzabraneVM))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtxtImeIzabraneVM, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jbtnCard1nazad.setText("Nazad");
        jbtnCard1nazad.setMaximumSize(new java.awt.Dimension(120, 25));
        jbtnCard1nazad.setMinimumSize(new java.awt.Dimension(120, 25));
        jbtnCard1nazad.setPreferredSize(new java.awt.Dimension(120, 25));
        jbtnCard1nazad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCard1nazadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jbtnCard1nazad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnCard1nazad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(card1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Admin test");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("VirtualIRC");
        getContentPane().setLayout(new java.awt.CardLayout());

        card0.setPreferredSize(new java.awt.Dimension(604, 974));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Izaberite putanju:");

        jtxtPutanjaDoFoldera.setEditable(false);
        jtxtPutanjaDoFoldera.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtPutanjaDoFoldera.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jbtnIzaberiPutanjuDoFoldera.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtnIzaberiPutanjuDoFoldera.setText("...");
        jbtnIzaberiPutanjuDoFoldera.setPreferredSize(new java.awt.Dimension(57, 34));
        jbtnIzaberiPutanjuDoFoldera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnIzaberiPutanjuDoFolderaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlPutanjaLayout = new javax.swing.GroupLayout(jpnlPutanja);
        jpnlPutanja.setLayout(jpnlPutanjaLayout);
        jpnlPutanjaLayout.setHorizontalGroup(
            jpnlPutanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPutanjaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtPutanjaDoFoldera)
                .addGap(18, 18, 18)
                .addComponent(jbtnIzaberiPutanjuDoFoldera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnlPutanjaLayout.setVerticalGroup(
            jpnlPutanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlPutanjaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlPutanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlPutanjaLayout.createSequentialGroup()
                        .addGroup(jpnlPutanjaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtPutanjaDoFoldera, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbtnIzaberiPutanjuDoFoldera, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane3.setBorder(null);
        jScrollPane3.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());

        jpnlCheckBoksevi.setLayout(new javax.swing.BoxLayout(jpnlCheckBoksevi, javax.swing.BoxLayout.Y_AXIS));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Izaberite programe:");
        jpnlCheckBoksevi.add(jLabel5);

        jScrollPane3.setViewportView(jpnlCheckBoksevi);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Izaberite virtuelnu mašinu:");

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jtxtOpis.setEditable(false);
        jtxtOpis.setBackground(new java.awt.Color(240, 240, 240));
        jtxtOpis.setColumns(20);
        jtxtOpis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtxtOpis.setLineWrap(true);
        jtxtOpis.setRows(5);
        jtxtOpis.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(jtxtOpis);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Opis virtuelne mašine:");

        listVM.setBackground(new java.awt.Color(240, 240, 240));
        listVM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        listVM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listVMMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jpnlVMLayout = new javax.swing.GroupLayout(jpnlVM);
        jpnlVM.setLayout(jpnlVMLayout);
        jpnlVMLayout.setHorizontalGroup(
            jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(listVM, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlVMLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 185, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jpnlVMLayout.setVerticalGroup(
            jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVMLayout.createSequentialGroup()
                .addGroup(jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnlVMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(listVM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jbtnInstalacija.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtnInstalacija.setText("Instalacija");
        jbtnInstalacija.setMaximumSize(new java.awt.Dimension(120, 34));
        jbtnInstalacija.setMinimumSize(new java.awt.Dimension(120, 25));
        jbtnInstalacija.setPreferredSize(new java.awt.Dimension(120, 34));
        jbtnInstalacija.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInstalacijaActionPerformed(evt);
            }
        });
        jpnlInstalacija.add(jbtnInstalacija);

        javax.swing.GroupLayout card0Layout = new javax.swing.GroupLayout(card0);
        card0.setLayout(card0Layout);
        card0Layout.setHorizontalGroup(
            card0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(card0Layout.createSequentialGroup()
                .addGroup(card0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card0Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jpnlVM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, card0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnlInstalacija, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(card0Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnlPutanja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        card0Layout.setVerticalGroup(
            card0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card0Layout.createSequentialGroup()
                .addComponent(jpnlPutanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(card0Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlVM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnlInstalacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(card0, "card2");

        jMenu3.setText("File");

        jMenuItem2.setText("Administrator");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Moje mašine");
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Exit");
        jMenu3.add(jMenuItem4);

        jMenuBar2.add(jMenu3);

        jMenu5.setText("O nama");
        jMenuBar2.add(jMenu5);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        setSize(new java.awt.Dimension(1015, 699));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCard0DaljeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCard0DaljeActionPerformed
        int selektovaniRed = jtblIzaberiVM.getSelectedRow();

        IzaberiVMTableModel iVM = (IzaberiVMTableModel) jtblIzaberiVM.getModel();

        if (selektovaniRed == -1) {
            JOptionPane.showMessageDialog(this, "Izaberite VM", "Greska", JOptionPane.ERROR_MESSAGE);
        } else {
            VirtuelnaMasina vm = iVM.vratiVM(selektovaniRed);

            if (vm != null) {
                Kontroler.card0Dalje(vm);
            }
        }
    }//GEN-LAST:event_jbtnCard0DaljeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Kontroler.otvoriAdminLog();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbtnInstalacijaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInstalacijaActionPerformed
//        Kontroler.pokreniVM();
        String vm = listVM.getSelectedItem();
        if (vm == null || Kontroler.putanjaDoFoldera == null) {
            JOptionPane.showMessageDialog(
                    this, "Morate da odabere Virtuelnu masinu i putanju do foldera u koji ce da se smesti", 
                    "Greska", JOptionPane.ERROR_MESSAGE
            );
        } else {
            Kontroler.instalacija(vm);
        }
        
    }//GEN-LAST:event_jbtnInstalacijaActionPerformed

    private void jbtnCard1nazadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCard1nazadActionPerformed
        prikaziCard0();
    }//GEN-LAST:event_jbtnCard1nazadActionPerformed

    private void jtxtPronadjiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPronadjiKeyReleased
        Kontroler.search(jtxtPronadji.getText());
    }//GEN-LAST:event_jtxtPronadjiKeyReleased

    private void jbtnIzaberiPutanjuDoFolderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnIzaberiPutanjuDoFolderaActionPerformed
        String putanjaDoFoldera = Kontroler.otvoriProzorZaIzborPutanje();

        Kontroler.namestiPutanjuDoFoldera(putanjaDoFoldera);
        jtxtPutanjaDoFoldera.setText(putanjaDoFoldera);
    }//GEN-LAST:event_jbtnIzaberiPutanjuDoFolderaActionPerformed

    private void listVMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listVMMouseClicked
        List<VirtuelnaMasina> vm = new LinkedList<>();
        vm = Kontroler.vratiListuVM();
        for (VirtuelnaMasina virtuelnaMasina : vm) {
            if(virtuelnaMasina.getIme().equals(listVM.getSelectedItem())) {
                jtxtOpis.setText(virtuelnaMasina.getOpis());
                break;
            }
        }
    }//GEN-LAST:event_listVMMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Kontroler.otvoriAdminLog();
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel card0;
    private javax.swing.JPanel card1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbtnCard0Dalje;
    private javax.swing.JButton jbtnCard1nazad;
    private javax.swing.JButton jbtnDodajVM;
    private javax.swing.JButton jbtnInstalacija;
    private javax.swing.JButton jbtnIzaberiPutanjuDoFoldera;
    private javax.swing.JButton jbtnIzmeniVM;
    private javax.swing.JButton jbtnObrisiVM;
    private javax.swing.JPanel jpnlAdministracija;
    private javax.swing.JPanel jpnlCheckBoksevi;
    private javax.swing.JPanel jpnlInstalacija;
    private javax.swing.JPanel jpnlPutanja;
    private javax.swing.JPanel jpnlVM;
    private javax.swing.JTable jtblIzaberiVM;
    private javax.swing.JTextArea jtxtAreaOpisVM;
    private javax.swing.JTextField jtxtImeIzabraneVM;
    private javax.swing.JTextArea jtxtOpis;
    private javax.swing.JTextField jtxtPronadji;
    private javax.swing.JTextField jtxtPutanjaDoFoldera;
    private java.awt.List listVM;
    // End of variables declaration//GEN-END:variables

    public void prikaziAdministraciju(boolean b) {
        jpnlAdministracija.setVisible(b);
    }

    public javax.swing.JTextField getTxtPronadji() {
        return jtxtPronadji;
    }

    public IzaberiVMTableModel getIzaberiVMTableModel() {
        return (IzaberiVMTableModel) jtblIzaberiVM.getModel();
    }

    public JTextField getJtxtImeIzabraneVirtuelneMasine() {
        return jtxtImeIzabraneVM;
    }

    public void prikaziCard1() {
        sakrijSvePanele();
        card1.setVisible(true);
    }

    public void sakrijSvePanele() {
        card0.setVisible(false);
        card1.setVisible(false);
    }

    public JTextArea getJTxtOpisVM() {
        return jtxtAreaOpisVM;
    }

    public JPanel getJPanelCheckBoksevi() {
        return jpnlCheckBoksevi;
    }

    private void prikaziCard0() {
        sakrijSvePanele();
        card0.setVisible(true);
    }

    public JTextField getTxtPutanjaDoFoldera() {
        return jtxtPutanjaDoFoldera;
    }

    public void generisiCheckBokseve(List<Program> listaPrograma) {
        Font font = new Font("Segoe UI", Font.PLAIN, 14);
        for (Program p : listaPrograma) {
            JCheckBox jcb = new JCheckBox(p.getIme());
            jcb.setFont(font);
            jpnlCheckBoksevi.add(jcb);
            Kontroler.dodajCheckBoksUListu(jcb);
        }
    }

    public JPanel getJpnlCheckBoksevi() {
        return jpnlCheckBoksevi;
    }

    public void setJpnlCheckBoksevi(JPanel jpnlCheckBoksevi) {
        this.jpnlCheckBoksevi = jpnlCheckBoksevi;
    }
    
    public void napuniListuVirtuelnimMasinama() {
        List<VirtuelnaMasina> listaSvihVM = new LinkedList<>();
        listaSvihVM = Kontroler.vratiListuVM();
        for (VirtuelnaMasina virtuelnaMasina : listaSvihVM) {
            listVM.add(virtuelnaMasina.getIme());
        }
    }

}
