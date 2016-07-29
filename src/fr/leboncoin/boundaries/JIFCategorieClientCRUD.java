package fr.leboncoin.boundaries;

import fr.leboncoin.Globale;
import fr.leboncoin.daos.CategorieClientDAO;
import fr.leboncoin.entities.CategorieClient;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.util.*;

/**
 *
 * Procedures stockees POJO DAO
 *
 * Connexion niveau Instance
 *
 * @author pascal
 */
public class JIFCategorieClientCRUD extends javax.swing.JInternalFrame {

    private Connection icn;
    private List<String> liste = new ArrayList();
    private int iiCount = 0;
    private int iiPosition = 0;

    // --- Menu Popup
    private final JPopupMenu menuPopup = new JPopupMenu("Edit");

    private JMenuItem itemCouper = new JMenuItem("Couper");
    private JMenuItem itemCopier = new JMenuItem("Copier");
    private JMenuItem itemColler = new JMenuItem("Coller");

    /**
     * Creates new form JIFVillesCRUD
     */
    public JIFCategorieClientCRUD() {
        initComponents();

        Dimension d = new Dimension(75, 35);

        jButtonFirst.setPreferredSize(d);
        jButtonPrevious.setPreferredSize(d);
        jButtonNext.setPreferredSize(d);
        jButtonLast.setPreferredSize(d);

        jButtonFirst.setMinimumSize(d);
        jButtonPrevious.setMinimumSize(d);
        jButtonNext.setMinimumSize(d);
        jButtonLast.setMinimumSize(d);

        jButtonFirst.setMaximumSize(d);
        jButtonPrevious.setMaximumSize(d);
        jButtonNext.setMaximumSize(d);
        jButtonLast.setMaximumSize(d);

        //ConnexionMySQL.get(serveur, port, ut, mdp, bd);
        //icn = ConnexionMySQL.getCN("127.0.0.1", "3306", "root", "", "leboncoin");
        try {
            icn = Globale.getCn();
            //creationDuMenuContextuel();
                /*
             Chargement dans l'ArrayList
             */

            CategorieClientDAO daoCC = new CategorieClientDAO(icn);

            List<CategorieClient> listeCC = daoCC.selectAll();

            for (int i = 0; i < listeCC.size(); i++) {
                CategorieClient categorieClient = listeCC.get(i);
                liste.add(categorieClient.getIdCategorieClient() + ";" + categorieClient.getCategorieClient());
                System.out.println(categorieClient.getIdCategorieClient() + ";" + categorieClient.getCategorieClient());
            }
            iiCount = liste.size();
        } catch (Exception ex) {
            jLabelMessage.setText(ex.getMessage());
            System.out.println(ex.getMessage());
        }

        jLabelIDCategorieClient.setText("");
//        jTextFieldCategorieClient.setText("");

        setTitle("CRUD Catégorie client");
        setVisible(true);

        jButtonFirstActionPerformed(null);

    } /// CONSTRUCTEUR

    /**
     *
     */
    private void afficherChamps() {
        if (iiCount > 0) {
            String lsEnr = liste.get(iiPosition);
            String[] tChamps = lsEnr.split(";");

            this.jLabelIDCategorieClient.setText(tChamps[0]);
            this.jTextFieldCategorieClient.setText(tChamps[1]);

            this.jLabelMessage.setText("");
        } else {
            this.jLabelMessage.setText("La table est vide !!!");
        }

        // --- Affichage du compteur
        this.jLabelCompteur.setText((iiPosition + 1) + "/" + iiCount);

        // --- Les boutons Actifs / Inactifs
        this.jButtonFirst.setEnabled(iiPosition > 0);
        this.jButtonPrevious.setEnabled(iiPosition > 0);

        this.jButtonNext.setEnabled(iiPosition < iiCount - 1);
        this.jButtonLast.setEnabled(iiPosition < iiCount - 1);
    } /// afficherChamps

    /**
     *
     */
    private void creationDuMenuContextuel() {

        menuPopup.setBorderPainted(true);
        menuPopup.setLabel("Edit");

//        itemCouper.setMnemonic('P');
//        itemCopier.setMnemonic('C');
//        itemColler.setMnemonic('L');
        menuPopup.add(itemCouper);
        menuPopup.add(itemCopier);
        menuPopup.add(itemColler);

        itemCouper.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Code
                    System.out.println("Couper");
                } catch (Exception ex) {
                    // Code
                }
            }
        });
        itemCopier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Code
                    System.out.println("Copier");
                } catch (Exception ex) {
                    // Code
                }
            }
        });
        itemColler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    // Code
                    System.out.println("Coller");
                } catch (Exception ex) {
                    // Code
                }
            }
        });
    } /// creationDuMenuContextuel

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jTextFieldCategorieClient = new javax.swing.JTextField();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelIDCategorieClient = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonCLS = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonLast = new javax.swing.JButton();
        jLabelCompteur = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Catégorie client");

        jLabelMessage.setText("Message");

        jTextFieldCategorieClient.setText("Association");

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        jLabelIDCategorieClient.setForeground(new java.awt.Color(255, 0, 51));
        jLabelIDCategorieClient.setText("ID");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonCLS.setText("CLS");
        jButtonCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLSActionPerformed(evt);
            }
        });

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonCLS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAjouter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCLS)
                    .addComponent(jButtonAjouter))
                .addGap(19, 19, 19))
        );

        jButtonFirst.setText("<<");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });

        jButtonPrevious.setText("<");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jButtonNext.setText(">");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonLast.setText(">>");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });

        jLabelCompteur.setText("000 sur 1000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonModifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSupprimer))
                            .addComponent(jLabelCompteur)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelIDCategorieClient, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jTextFieldCategorieClient)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLast, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelIDCategorieClient))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCategorieClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonModifier)
                            .addComponent(jButtonSupprimer)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonFirst)
                                .addComponent(jButtonLast)
                                .addComponent(jButtonNext)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabelCompteur)
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // Vers BD
        try {

            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientDelete(?)");
            lpst.setInt(1, Integer.valueOf(jLabelIDCategorieClient.getText()));
            lpst.executeUpdate();

            icn.commit();

            lpst.close();

            jLabelMessage.setText("Jusque là tout va bien !!!");

        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed

        int liID = 0;
        String lsLibelle = jTextFieldCategorieClient.getText();

        try {
            // La commande SQL
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientInsert(?,?)");

            // Valorisation des parametres
            lpst.setInt(1, liID);
            lpst.setString(2, lsLibelle);

            // Execution de la commande SQL
            lpst.executeUpdate();

            // On la ferme !!!
            lpst.close();

            // Validation definitive
            icn.commit();

            jLabelMessage.setText("Jusqu'à tout va bien !!!");

        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed

        // Modification dans la BD
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientUpdate(?,?)");

            lpst.setInt(1, Integer.valueOf(jLabelIDCategorieClient.getText()));
            lpst.setString(2, jTextFieldCategorieClient.getText());

            lpst.executeUpdate();

            icn.commit();

            lpst.close();
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        this.jLabelIDCategorieClient.setText("");
        this.jTextFieldCategorieClient.setText("");
    }//GEN-LAST:event_jButtonCLSActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        //
        iiPosition++;
        afficherChamps();

    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        //
        iiPosition--;
        afficherChamps();

    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
        // 
        iiPosition = 0;
        afficherChamps();
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        // 
        iiPosition = liste.size() - 1;
        afficherChamps();
    }//GEN-LAST:event_jButtonLastActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCompteur;
    private javax.swing.JLabel jLabelIDCategorieClient;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCategorieClient;
    // End of variables declaration//GEN-END:variables
}
