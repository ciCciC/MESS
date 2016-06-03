/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseManager;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Joep, Koray, Ruben Schaafsma, Ruben van den Engel
 */
public class StudentView extends javax.swing.JFrame {

    private boolean studentType;
    private boolean knopType;
    private javax.swing.JLabel jLabel7_adres;
    private javax.swing.JTextField adres;

    /**
     * Creates new form StudentView
     */
    public StudentView() {
        super("Nieuwe binnenlandse student");
        this.studentType = true;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public StudentView(String buitenlands){
        super("Nieuwe buitenlandse student");
        this.studentType = false;
        initComponentsExchangeStudent();
        setLocationRelativeTo(null);
    }
    
    private void initComponentsExchangeStudent() {
        
        jLabel_studentnummer = new javax.swing.JLabel();
        studentnummer = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1_persoonsgegevens = new javax.swing.JLabel();
        jLabel2_naam = new javax.swing.JLabel();
        jLabel3_geslacht = new javax.swing.JLabel();
        jLabel4_emailadres = new javax.swing.JLabel();
        jRadioButton_man = new javax.swing.JRadioButton();
        jRadioButton_vrouw = new javax.swing.JRadioButton();
        naam = new javax.swing.JTextField();
        jLabel5_opleiding = new javax.swing.JLabel();
        jLabel6_universiteit = new javax.swing.JLabel();
        universiteit = new javax.swing.JTextField();
        jLabel7_adres = new javax.swing.JLabel();
        adres = new javax.swing.JTextField();
        jLabel7_telefoonnummer1 = new javax.swing.JLabel();
        telnr1 = new javax.swing.JTextField();
        jLabel8_telefoonnummer2 = new javax.swing.JLabel();
        telnr2 = new javax.swing.JTextField();
        jComboBox1_opleiding = new javax.swing.JComboBox();
        emailadres = new javax.swing.JTextField();
        jButton_annuleren = new javax.swing.JButton();
        jButton_toevoegen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 366));

        jLabel1_persoonsgegevens.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1_persoonsgegevens.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1_persoonsgegevens.setText("Persoonsgegevens");
        
        jRadioButton_man.setSelected(false);
        buttonGroup1.add(jRadioButton_man);
        jRadioButton_man.setText("Man");

        jRadioButton_vrouw.setSelected(false);
        buttonGroup1.add(jRadioButton_vrouw);
        jRadioButton_vrouw.setText("Vrouw");
        
        jLabel_studentnummer.setForeground(new java.awt.Color(0,0,0));
        jLabel_studentnummer.setText("Studentnummer");
        
        jLabel2_naam.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2_naam.setText("Naam");

        jLabel3_geslacht.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4_emailadres.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4_emailadres.setText("E-mailadres");

        jLabel6_universiteit.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6_universiteit.setText("Herkomst Uni");
        
        jLabel7_telefoonnummer1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7_telefoonnummer1.setText("Telefoonnummer");
        
        jLabel7_adres.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7_adres.setText("Adres");

        jLabel8_telefoonnummer2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8_telefoonnummer2.setText("Land");
        
        //jComboBox1_opleiding.setEnabled(false);
        jComboBox1_opleiding.setVisible(false);
        
        jButton_annuleren.setText("Annuleren");
        jButton_annuleren.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_annulerenActionPerformed(evt);
            }
        });

        jButton_toevoegen.setText("Toevoegen");
        jButton_toevoegen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_toevoegenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8_telefoonnummer2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_toevoegen)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_annuleren))
                            .addComponent(telnr2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1_persoonsgegevens)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))    
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4_emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3_geslacht, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2_naam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton_man)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton_vrouw))
                            .addComponent(naam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6_universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1_persoonsgegevens, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_geslacht, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_man)
                    .addComponent(jRadioButton_vrouw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2_naam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(naam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4_emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6_universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7_adres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8_telefoonnummer2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telnr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_annuleren)
                    .addComponent(jButton_toevoegen))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)//343
        );

        pack();
    }// </editor-fold> 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1_persoonsgegevens = new javax.swing.JLabel();
        jLabel2_naam = new javax.swing.JLabel();
        jLabel3_geslacht = new javax.swing.JLabel();
        jLabel4_emailadres = new javax.swing.JLabel();
        jRadioButton_man = new javax.swing.JRadioButton();
        jRadioButton_vrouw = new javax.swing.JRadioButton();
        naam = new javax.swing.JTextField();
        jLabel5_opleiding = new javax.swing.JLabel();
        jLabel6_universiteit = new javax.swing.JLabel();
        universiteit = new javax.swing.JTextField();
        jLabel7_telefoonnummer1 = new javax.swing.JLabel();
        telnr1 = new javax.swing.JTextField();
        jLabel8_telefoonnummer2 = new javax.swing.JLabel();
        telnr2 = new javax.swing.JTextField();
        jComboBox1_opleiding = new javax.swing.JComboBox();
        emailadres = new javax.swing.JTextField();
        jButton_annuleren = new javax.swing.JButton();
        jButton_toevoegen = new javax.swing.JButton();
        jLabel_studentnummer = new javax.swing.JLabel();
        studentnummer = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 366));

        jLabel1_persoonsgegevens.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1_persoonsgegevens.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1_persoonsgegevens.setText("Persoonsgegevens");

        jLabel2_naam.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2_naam.setText("Naam");

        jLabel3_geslacht.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3_geslacht.setText("Geslacht");

        jLabel4_emailadres.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4_emailadres.setText("E-mailadres");

        jRadioButton_man.setSelected(false);
        buttonGroup1.add(jRadioButton_man);
        jRadioButton_man.setText("M");
        jRadioButton_man.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jRadioButton_vrouw.setSelected(false);
        buttonGroup1.add(jRadioButton_vrouw);
        jRadioButton_vrouw.setText("V");

        jLabel5_opleiding.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5_opleiding.setText("Opleiding");

        jLabel6_universiteit.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6_universiteit.setText("Uitgaans Uni");

        jLabel7_telefoonnummer1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7_telefoonnummer1.setText("Telefoonnum. 1");

        jLabel8_telefoonnummer2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8_telefoonnummer2.setText("Telefoonnum. 2");

        jComboBox1_opleiding.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "hbo-ICT", "CMD", "Bedrijfskunde", "Wiskunde" }));

        jButton_annuleren.setText("Annuleren");
        jButton_annuleren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_annulerenActionPerformed(evt);
            }
        });

        jButton_toevoegen.setText("Toevoegen");
        jButton_toevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_toevoegenActionPerformed(evt);
            }
        });

        jLabel_studentnummer.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_studentnummer.setText("Studentnummer");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1_persoonsgegevens)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3_geslacht, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton_man)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton_vrouw))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8_telefoonnummer2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton_toevoegen)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_annuleren))
                            .addComponent(telnr2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7_telefoonnummer1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telnr1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4_emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2_naam, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(naam, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6_universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1_persoonsgegevens, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3_geslacht, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_man)
                    .addComponent(jRadioButton_vrouw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2_naam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(naam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4_emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1_opleiding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6_universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(universiteit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7_telefoonnummer1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telnr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8_telefoonnummer2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telnr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_annuleren)
                    .addComponent(jButton_toevoegen))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton_annulerenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_annulerenActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_annulerenActionPerformed

    private void jButton_toevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_toevoegenActionPerformed
        HoofdView hv = new HoofdView();
        String land = this.telnr2.getText();    // om verwarring te voorkomen, dit geldt alleen voor de buitenlandse student
        
        char geslacht = '?';
        if(jRadioButton_man.isSelected()){geslacht = 'M';}else if(jRadioButton_vrouw.isSelected()){geslacht = 'V';}
        
        if(this.studentType){   //Toevoegen binnenlands student
            
            if(alleVakkenControleren(studentType)){
                
                    String [] sqlBinnenStudent1 = new String[]{studentnummer.getText(), naam.getText(), "" + geslacht, emailadres.getText()}; 
                    String [] sqlBinnenStudent = new String[]{studentnummer.getText(), telnr1.getText(), land, universiteit.getText()};

                    DatabaseManager dm = new DatabaseManager();

                    try {
                        if(!knopType){
                            System.out.println("addrecord erin! Binnen");
                            dm.addRecord("Student", sqlBinnenStudent1);
                            dm.addRecord("Binnenlands", sqlBinnenStudent);
                            JOptionPane.showMessageDialog(null, "Met succes toegevoegd.");
                        }else{
                            System.out.println("updaterecord erin! Binnen");
                            dm.updateRecord("Student", sqlBinnenStudent1);
                            dm.updateRecord("Binnenlands", sqlBinnenStudent);
                            
                            JOptionPane.showMessageDialog(null, "Met succes gewijzigd.");
                        }
                        //dm.addRecord("Student", sql1);
                        //dm.addRecord("Binnenlands", sql);
                        //JOptionPane.showMessageDialog(null, "Met succes toegevoegd.");
                    } catch (SQLException ex) {
                        System.out.println("Student is niet toegevoegd in database!");    
                        ex.printStackTrace();
                    }
                    this.dispose(); 
            }
            
        }else{  //toevoegen buitenlands student
            
            if(alleVakkenControleren(studentType)){

                String [] sql1 = new String[]{studentnummer.getText(), naam.getText(), "" + geslacht, emailadres.getText()}; 
                String [] sql = new String[]{studentnummer.getText(), adres.getText(), land, universiteit.getText()};
                
                DatabaseManager dm = new DatabaseManager();
                
                try {
                    if(knopType){
                        System.out.println("updaterecord erin! Buiten");
                        dm.updateRecord("Student", sql1);
                        dm.updateRecord("Buitenlands", sql);
                        JOptionPane.showMessageDialog(null, "Met succes gewijzigd.");
                        //hv.
                    }else{
                        System.out.println("addrecord erin! Buiten");
                        dm.addRecord("Student", sql1);
                        dm.addRecord("Buitenlands", sql);
                        JOptionPane.showMessageDialog(null, "Met succes toegevoegd.");
                    }
                    //dm.addRecord("Student", sql1);
                    //dm.addRecord("Buitenlands", sql);
                    //JOptionPane.showMessageDialog(null, "Met succes toegevoegd.");
                } catch (SQLException ex) {
                    System.out.println("Student is niet toegevoegd in database!");    
                    ex.printStackTrace();
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton_toevoegenActionPerformed

    private boolean alleVakkenControleren(boolean studentType){

        String land = this.telnr2.getText();    // om verwarring te voorkomen, dit geldt alleen voor de buitenlandse student
        
        boolean status = false;
        
        if(studentType){
            System.out.println("Binnenlandse student vakken.");
            if(!(jRadioButton_man.isSelected() || jRadioButton_vrouw.isSelected()) || (studentnummer.getText().isEmpty() || naam.getText().isEmpty() || emailadres.getText().isEmpty() || telnr1.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Alle vakken moeten ingevuld worden.");
            }else{
                System.out.println("Vakken zijn ingevuld."); // controle of studentnummer cijfers zijn of letters.
                status = true;
            }
        }else if(!studentType){
            System.out.println("Buitenlandse student vakken.");
            if(!(jRadioButton_man.isSelected() || jRadioButton_vrouw.isSelected()) || (studentnummer.getText().isEmpty() || naam.getText().isEmpty() || emailadres.getText().isEmpty() || universiteit.getText().isEmpty() || adres.getText().isEmpty() || land.isEmpty())){
                JOptionPane.showMessageDialog(null, "Alle vakken moeten ingevuld worden.");
            }else{
                System.out.println("Vakken zijn ingevuld.");
                status = true;
            }
        }
        return status;
    }
    
    public void studentWijzigen(String wijzigen, JTable studentTable, boolean knopType){
        this.knopType = knopType;
        String row [] = new String[studentTable.getColumnCount()];
        
        for (int i = 0; i < row.length; i++) {
            row[i] = "" + studentTable.getValueAt(studentTable.getSelectedRow(), i);
            if(row[i].equals("M")){
                jRadioButton_man.setSelected(true);
            }else if(row[i].equals("V")){
                jRadioButton_vrouw.setSelected(true);
            }else{
                System.out.println("geen geslacht!!");
            }
        } 
        
        if(studentType && wijzigen.equals("Binnenlands")){
            System.out.println("Binnenlands test");
            jButton_toevoegen.setText("Wijzigen");
            studentnummer.setEnabled(false);

        }else if((!studentType) && wijzigen.equals("Buitenlands")){
            jButton_toevoegen.setText("Wijzigen");
            System.out.println("Buitenlands test");
            studentnummer.setEnabled(false);
            
            studentnummer.setText(row[0]); naam.setText(row[1]); emailadres.setText(row[3]); universiteit.setText(row[6]); 
            adres.setText(row[4]); telnr1.setText(row[0]); telnr2.setText(row[5]);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentView().setVisible(true); // View van de hhs student inschrijven
                new StudentView("exchange").setVisible(true); // View van de buitenlandse student inschrijven
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField emailadres;
    private javax.swing.JButton jButton_annuleren;
    private javax.swing.JButton jButton_toevoegen;
    private javax.swing.JComboBox jComboBox1_opleiding;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_persoonsgegevens;
    private javax.swing.JLabel jLabel2_naam;
    private javax.swing.JLabel jLabel3_geslacht;
    private javax.swing.JLabel jLabel4_emailadres;
    private javax.swing.JLabel jLabel5_opleiding;
    private javax.swing.JLabel jLabel6_universiteit;
    private javax.swing.JLabel jLabel7_telefoonnummer1;
    private javax.swing.JLabel jLabel8_telefoonnummer2;
    private javax.swing.JLabel jLabel_studentnummer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_man;
    private javax.swing.JRadioButton jRadioButton_vrouw;
    private javax.swing.JTextField naam;
    private javax.swing.JTextField studentnummer;
    private javax.swing.JTextField telnr1;
    private javax.swing.JTextField telnr2;
    private javax.swing.JTextField universiteit;
    // End of variables declaration//GEN-END:variables
}
