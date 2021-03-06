package fr.leboncoin.boundaries;

import fr.leboncoin.Globale;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pascal
 */
public class JIFRegionCRUD extends javax.swing.JInternalFrame {

    private DefaultTableModel idtm;
    private Connection icn;
    private Map<String, String> mapPaysIdNom = new HashMap();
    private Map<String, String> mapPaysNomId = new HashMap();

    /**
     * Creates new form JIFProduitsCRUD
     */
    public JIFRegionCRUD() {
        initComponents();

        setTitle("Régions");
        jLabelMessage.setText("");
        jTextFieldIdPays.setEnabled(false);

        icn = Globale.getCn();
        remplirJTableEtJCombo();

        jTableRegions.getColumn("ID Région").setMaxWidth(0);
        jTableRegions.getColumn("ID Région").setWidth(0);
        jTableRegions.getColumn("ID Région").setMinWidth(0);

        setVisible(true);

    } /// JIFPaysCRUD

    /**
     *
     */
    private void remplirJTableEtJCombo() {
        try {

            idtm = (DefaultTableModel) jTableRegions.getModel();

            Object[] tLigne;

            PreparedStatement lpst = icn.prepareStatement("CALL regionSelectAll()");
            ResultSet lrs = lpst.executeQuery();

            while (lrs.next()) {
                tLigne = new Object[4];
                for (int i = 0; i < tLigne.length; i++) {
                    // JTable
                    tLigne[0] = lrs.getString(1); // ID REGION
                    tLigne[1] = lrs.getString(3); // NOM
                    tLigne[2] = lrs.getString(4); // CODE
                    tLigne[3] = lrs.getString(2); // ID PAYS

                }

                idtm.addRow(tLigne);
            }

            lrs.close();
            lpst.close();

            /*
             Pays
             */
            // ID pays, nom pays, code, code iso3
            lpst = icn.prepareStatement("CALL paysSelectAll()");
            lrs = lpst.executeQuery();

            while (lrs.next()) {
                jComboBoxPays.addItem(lrs.getString(2));

                mapPaysIdNom.put(lrs.getString(1), lrs.getString(2));
                mapPaysNomId.put(lrs.getString(2), lrs.getString(1));
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
        jTableRegions = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelIdRegion = new javax.swing.JLabel();
        jTextFieldNomDeLaRegion = new javax.swing.JTextField();
        jTextFieldCodeRegion = new javax.swing.JTextField();
        jTextFieldIdPays = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonRafraichir = new javax.swing.JButton();
        jButtonCLS = new javax.swing.JButton();
        jComboBoxPays = new javax.swing.JComboBox();

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

        jTableRegions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Région", "Nom de la Région", "Code de la Région", "ID Pays"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRegions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRegionsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRegions);

        jLabel2.setText("ID région");

        jLabel3.setText("Nom de la région");

        jLabel4.setText("Code région");

        jLabel5.setText("Id Pays");

        jLabelIdRegion.setForeground(new java.awt.Color(255, 0, 51));
        jLabelIdRegion.setText("ID");

        jTextFieldNomDeLaRegion.setText("Zéro");

        jTextFieldCodeRegion.setText("999");

        jTextFieldIdPays.setText("1");

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

        jComboBoxPays.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxPaysPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                jComboBoxPaysPopupMenuWillBecomeVisible(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                    .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCLS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAjouter))
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomDeLaRegion)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCodeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonModifier)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonSupprimer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonRafraichir)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldIdPays, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxPays, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelIdRegion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomDeLaRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCodeRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldIdPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxPays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCLS)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer)
                    .addComponent(jButtonRafraichir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabelMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL regionInsert(?,?,?,?)");
            lpst.setInt(1, 0);
            lpst.setString(2, jTextFieldIdPays.getText());
            lpst.setString(3, jTextFieldNomDeLaRegion.getText());
            lpst.setString(4, jTextFieldCodeRegion.getText());
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Nouvelle région ajoutée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL regionDelete(?)");
            lpst.setInt(1, Integer.valueOf(jLabelIdRegion.getText()));
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Région supprimée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jTableRegionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRegionsMouseClicked
        //
        jLabelIdRegion.setText(jTableRegions.getValueAt(jTableRegions.getSelectedRow(), 0).toString());
        jTextFieldNomDeLaRegion.setText(jTableRegions.getValueAt(jTableRegions.getSelectedRow(), 1).toString());
        jTextFieldCodeRegion.setText(jTableRegions.getValueAt(jTableRegions.getSelectedRow(), 2).toString());
        jTextFieldIdPays.setText(jTableRegions.getValueAt(jTableRegions.getSelectedRow(), 3).toString());

        // Actualisation de la combo 
        jComboBoxPays.setSelectedItem(mapPaysIdNom.get(jTextFieldIdPays.getText()));

    }//GEN-LAST:event_jTableRegionsMouseClicked

    private void jButtonRafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRafraichirActionPerformed
        //
        viderJTable();
        remplirJTableEtJCombo();
        jLabelMessage.setText("");
    }//GEN-LAST:event_jButtonRafraichirActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        this.jLabelIdRegion.setText("");
        this.jTextFieldNomDeLaRegion.setText("");
        this.jTextFieldCodeRegion.setText("");
        this.jTextFieldIdPays.setText("");
    }//GEN-LAST:event_jButtonCLSActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL regionUpdate(?,?,?,?)");
            lpst.setInt(1, Integer.valueOf(jLabelIdRegion.getText()));
            lpst.setString(2, jTextFieldIdPays.getText());
            lpst.setString(3, jTextFieldNomDeLaRegion.getText());
            lpst.setString(4, jTextFieldCodeRegion.getText());
            lpst.executeUpdate();
            icn.commit();
            jLabelMessage.setText("Région modifiée !");
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jComboBoxPaysPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPaysPopupMenuWillBecomeVisible
        // 

    }//GEN-LAST:event_jComboBoxPaysPopupMenuWillBecomeVisible

    private void jComboBoxPaysPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jComboBoxPaysPopupMenuWillBecomeInvisible
        // Quand la liste de la combo se ferme
        jTextFieldIdPays.setText(mapPaysNomId.get(jComboBoxPays.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxPaysPopupMenuWillBecomeInvisible


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonRafraichir;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxPays;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelIdRegion;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegions;
    private javax.swing.JTextField jTextFieldCodeRegion;
    private javax.swing.JTextField jTextFieldIdPays;
    private javax.swing.JTextField jTextFieldNomDeLaRegion;
    // End of variables declaration//GEN-END:variables
}
