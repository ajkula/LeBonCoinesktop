package fr.leboncoin.boundaries;

import fr.leboncoin.Globale;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pascal
 */
public class JIFVilleCRUD extends javax.swing.JInternalFrame {
    
    private DefaultTableModel idtm;
    private Connection icn;
    private Map<String, String> mapDepartementsIdNom = new HashMap();
    private Map<String, String> mapDepartementsNomId = new HashMap();

    /**
     * Creates new form JIFProduitsCRUD
     */
    public JIFVilleCRUD() {
        initComponents();
        
        setTitle("Villes");
        jLabelMessage.setText("");
        jTextFieldIdDepartement.setEnabled(false);
        
        icn = Globale.getCn();
        remplirJTableEtJCombo();
        try {
            jTableVilles.getColumn("ID Ville").setMaxWidth(0);
            jTableVilles.getColumn("ID Ville").setWidth(0);
            jTableVilles.getColumn("ID Ville").setMinWidth(0);
        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }
        
        setVisible(true);
        
    } /// JIFVilleCRUD

    /**
     *
     */
    private void remplirJTableEtJCombo() {
        try {
            
            idtm = (DefaultTableModel) jTableVilles.getModel();
            
            Object[] tLigne;
            
            PreparedStatement lpst = icn.prepareStatement("CALL villeSelectAll()");
            ResultSet lrs = lpst.executeQuery();
            
            while (lrs.next()) {
                tLigne = new Object[6];
                for (int i = 0; i < tLigne.length; i++) {
                    // ID ville, ID dept, nom, lat, lng, cp
                    // JTable
                    tLigne[0] = lrs.getString(1); // ID 
                    tLigne[1] = lrs.getString(3); // NOM
                    tLigne[2] = lrs.getString(6); // CODE POSTAL
                    tLigne[3] = lrs.getString(4); // LAT
                    tLigne[4] = lrs.getString(5); // LNG
                    tLigne[5] = lrs.getString(2); // ID DEPT
                }
                idtm.addRow(tLigne);
            }
            
            lrs.close();
            lpst.close();

            /*
             DEPT
             */
            // ID DEPT, id region, code, nom
            lpst = icn.prepareStatement("CALL departementSelectAll()");
            lrs = lpst.executeQuery();
            
            while (lrs.next()) {
                jComboBoxDepartements.addItem(lrs.getString(4));
                
                mapDepartementsIdNom.put(lrs.getString(1), lrs.getString(4));
                mapDepartementsNomId.put(lrs.getString(4), lrs.getString(1));
            }
            
            lrs.close();
            lpst.close();

            //jLabelMessage.setText("Jusque là tout va bien !!!");
        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    } /// remplirJTable

    /**
     *
     */
    private void viderJTable() {
        for (int i = idtm.getRowCount() - 1; i >= 0; i--) {
            idtm.removeRow(i);
        }
    } /// viderJTable

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMessage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVilles = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelIdVille = new javax.swing.JLabel();
        jTextFieldNomDeLaVille = new javax.swing.JTextField();
        jTextFieldCodePostal = new javax.swing.JTextField();
        jTextFieldIdDepartement = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonRafraichir = new javax.swing.JButton();
        jButtonCLS = new javax.swing.JButton();
        jComboBoxDepartements = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldLat = new javax.swing.JTextField();
        jTextFieldLng = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPremieresLettres = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabelMessage.setText("Message");

        jTableVilles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Ville", "Nom", "Code postal", "Latitude", "Longitude", "Département"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVilles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVillesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVilles);

        jLabel2.setText("ID ville");

        jLabel3.setText("Nom de la ville");

        jLabel4.setText("Code postal");

        jLabel5.setText("Id Département");

        jLabelIdVille.setForeground(new java.awt.Color(255, 0, 51));
        jLabelIdVille.setText("ID");

        jTextFieldNomDeLaVille.setText("ZZéro");

        jTextFieldCodePostal.setText("99999");

        jTextFieldIdDepartement.setText("1");

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonRafraichir.setText("Rafraîchir");
        jButtonRafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRafraichirActionPerformed(evt);
            }
        });

        jButtonCLS.setText("CLS");
        jButtonCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLSActionPerformed(evt);
            }
        });

        jComboBoxDepartements.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxDepartementsPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxDepartementsPopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel1.setText("Latitude");

        jLabel6.setText("Longitude");

        jTextFieldLat.setText("0.1");

        jTextFieldLng.setText("0.1");

        jLabel7.setText("Tapez les premières lettres du nom de la ville (Minimum 3)");

        jTextFieldPremieresLettres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPremieresLettresKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                            .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldLng, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldIdDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldLat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(12, 12, 12)
                                .addComponent(jComboBoxDepartements, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(26, 26, 26)
                                .addComponent(jTextFieldNomDeLaVille))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCLS)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonAjouter)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonModifier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSupprimer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonRafraichir))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(81, 81, 81)
                                        .addComponent(jLabelIdVille, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldPremieresLettres, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldPremieresLettres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelIdVille))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNomDeLaVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCodePostal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldLng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldIdDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxDepartements, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCLS)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonRafraichir))
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        double lat = Double.valueOf(jTextFieldLat.getText());
        double lng = Double.valueOf(jTextFieldLng.getText());
        
        try {
            // ID ville, ID dept, nom, lat, lng, cp
            PreparedStatement lpst = icn.prepareStatement("CALL villeInsert(?,?,?,?,?,?)");
            lpst.setInt(1, 0);
            lpst.setString(2, jTextFieldIdDepartement.getText());
            lpst.setString(3, jTextFieldNomDeLaVille.getText());
            lpst.setDouble(4, lat);
            lpst.setDouble(5, lng);
            lpst.setString(6, jTextFieldCodePostal.getText());
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Nouvelle ville ajoutée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL villeDelete(?)");
            lpst.setInt(1, Integer.valueOf(jLabelIdVille.getText()));
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Ville supprimée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jTableVillesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVillesMouseClicked
        //
        jLabelIdVille.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 0).toString());
        jTextFieldNomDeLaVille.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 1).toString());
        jTextFieldCodePostal.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 2).toString());
        jTextFieldLat.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 3).toString());
        jTextFieldLng.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 4).toString());
        jTextFieldIdDepartement.setText(jTableVilles.getValueAt(jTableVilles.getSelectedRow(), 5).toString());
        // Actualisation de la combo 
        jComboBoxDepartements.setSelectedItem(mapDepartementsIdNom.get(jTextFieldIdDepartement.getText()));

    }//GEN-LAST:event_jTableVillesMouseClicked

    private void jButtonRafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRafraichirActionPerformed
        //
        viderJTable();
        remplirJTableEtJCombo();
        jLabelMessage.setText("");
    }//GEN-LAST:event_jButtonRafraichirActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        this.jLabelIdVille.setText("");
        this.jTextFieldNomDeLaVille.setText("");
        this.jTextFieldCodePostal.setText("");
        this.jTextFieldIdDepartement.setText("");
    }//GEN-LAST:event_jButtonCLSActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        
        float lat = Float.valueOf(jTextFieldLat.getText());
        float lng = Float.valueOf(jTextFieldLng.getText());
        
        try {
            // ID ville, ID dept, nom, lat, lng, cp
            PreparedStatement lpst = icn.prepareStatement("CALL villeUpdate(?,?,?,?,?,?)");
            lpst.setInt(1, Integer.valueOf(jLabelIdVille.getText()));
            lpst.setString(2, jTextFieldIdDepartement.getText());
            lpst.setString(3, jTextFieldNomDeLaVille.getText());
            lpst.setFloat(4, lat);
            lpst.setFloat(5, lng);
            lpst.setString(6, jTextFieldCodePostal.getText());
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Ville modifiée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jComboBoxDepartementsPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxDepartementsPopupMenuWillBecomeVisible
        // 

    }//GEN-LAST:event_jComboBoxDepartementsPopupMenuWillBecomeVisible

    private void jComboBoxDepartementsPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxDepartementsPopupMenuWillBecomeInvisible
        // Quand la liste de la combo se ferme
        jTextFieldIdDepartement.setText(mapDepartementsNomId.get(jComboBoxDepartements.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxDepartementsPopupMenuWillBecomeInvisible

    private void jTextFieldPremieresLettresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPremieresLettresKeyReleased
        // 
        int liCountEnrs = jTableVilles.getRowCount();
        int i = 0;
        boolean lbTrouve = false;
        
        String lsLettresSaisies = jTextFieldPremieresLettres.getText().toUpperCase();
        jLabelMessage.setText(lsLettresSaisies);
        String lsValeurCelluleVille;
        int liLongueurSaisie = lsLettresSaisies.length();
        int liLongeurNomVille = 0;
        
        try {
            if (lsLettresSaisies.length() > 2) {
                while (i < liCountEnrs && !lbTrouve) {
                    lsValeurCelluleVille = jTableVilles.getValueAt(i, 1).toString().toUpperCase();
                    liLongeurNomVille = lsValeurCelluleVille.length();
//                    System.out.println(lsValeurCelluleVille);
//                    System.out.println(lsLettresSaisies);
                    if (liLongeurNomVille >= liLongueurSaisie) {
                        if (lsValeurCelluleVille.substring(0, lsLettresSaisies.length()).equals(lsLettresSaisies)) {
                            lbTrouve = true;
                        }
                    }
                    i++;
//                    System.out.println(i);
//                    System.out.println("------------------------------");
                } /// WHILE
                if (lbTrouve) {
                    // Selectionne la ligne en bleu
                    jTableVilles.setRowSelectionInterval(i - 1, i - 1);
                    // Met le focus par scrolling
                    jTableVilles.scrollRectToVisible(new Rectangle(jTableVilles.getCellRect(i - 1, 0, true)));
                    jLabelMessage.setText("");
                } else {
                    jLabelMessage.setText("Introuvable !");
                }
            }
            
        } catch (Exception e) {
            jLabelMessage.setText(e.getMessage());
        }

    }//GEN-LAST:event_jTextFieldPremieresLettresKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonRafraichir;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxDepartements;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelIdVille;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVilles;
    private javax.swing.JTextField jTextFieldCodePostal;
    private javax.swing.JTextField jTextFieldIdDepartement;
    private javax.swing.JTextField jTextFieldLat;
    private javax.swing.JTextField jTextFieldLng;
    private javax.swing.JTextField jTextFieldNomDeLaVille;
    private javax.swing.JTextField jTextFieldPremieresLettres;
    // End of variables declaration//GEN-END:variables
}
