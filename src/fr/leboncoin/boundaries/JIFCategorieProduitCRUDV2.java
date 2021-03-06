package fr.leboncoin.boundaries;

import fr.leboncoin.Globale;
import fr.leboncoin.daos.CategorieProduitDAO;
import fr.leboncoin.entities.CategorieProduit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.util.*;

/**
 *
 * Procedures stockees
 *
 * Connexion niveau Instance
 *
 * @author pascal
 */
public class JIFCategorieProduitCRUDV2 extends javax.swing.JInternalFrame {

    private Connection icn;
    private List<CategorieProduit> liste = new ArrayList();
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
    public JIFCategorieProduitCRUDV2() {
        initComponents();

        //ConnexionMySQL.get(serveur, port, ut, mdp, bd);
        //icn = ConnexionMySQL.getCN("127.0.0.1", "3306", "root", "", "leboncoin");
        try {
//            icn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            icn.setAutoCommit(false);
            
            icn = Globale.getCn();
            
            if (icn != null) {
                //creationDuMenuContextuel();
                /*
                 Chargement dans l'ArrayList
                 */
                CategorieProduitDAO cpDAO = new CategorieProduitDAO(icn);
                liste = cpDAO.selectAll();
                iiCount=liste.size();
            } else {
                jLabelMessage.setText("Problemo !!!");
            }

        } catch (Exception ex) {
            jLabelMessage.setText(ex.getMessage());
        }

        jLabelIDCategorieProduit.setText("");
        jTextFieldCategorieProduit.setText("");

        setTitle("CRUD Catégorie Produit");
        setVisible(true);

        jButtonFirstActionPerformed(null);

    } /// CONSTRUCTEUR

    /**
     *
     */
    private void afficherChamps() {
        if (iiCount > 0) {
            CategorieProduit cp = liste.get(iiPosition);
            jLabelIDCategorieProduit.setText(Integer.toString(cp.getIdCategorieProduit()));
            jTextFieldCategorieProduit.setText(cp.getCategorieProduit());
            System.out.println("");
            
            jLabelMessage.setText("");
        } else {
            jLabelMessage.setText("La table est vide !!!");
        }

        // --- Affichage du compteur
        jLabelCompteur.setText((iiPosition + 1) + "/" + iiCount);

        // --- Les boutons Actifs / Inactifs
        jButtonFirst.setEnabled(iiPosition > 0);
        jButtonPrevious.setEnabled(iiPosition > 0);

        jButtonNext.setEnabled(iiPosition < iiCount - 1);
        jButtonLast.setEnabled(iiPosition < iiCount - 1);
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
        jTextFieldCategorieProduit = new javax.swing.JTextField();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelIDCategorieProduit = new javax.swing.JLabel();
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

        jLabel1.setText("Catégorie produit");

        jLabelMessage.setText("Message");

        jTextFieldCategorieProduit.setText("Gateaux");

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

        jLabelIDCategorieProduit.setForeground(new java.awt.Color(255, 0, 51));
        jLabelIDCategorieProduit.setText("ID");

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonModifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSupprimer))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonLast))
                            .addComponent(jLabelCompteur))
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabelIDCategorieProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jTextFieldCategorieProduit))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelIDCategorieProduit))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldCategorieProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonModifier)
                            .addComponent(jButtonSupprimer)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFirst)
                            .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonNext)
                            .addComponent(jButtonLast))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
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

            PreparedStatement lpst = icn.prepareStatement("CALL categorie_produitDelete(?)");
            lpst.setInt(1, Integer.valueOf(jLabelIDCategorieProduit.getText()));
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
        String lsLibelle = jTextFieldCategorieProduit.getText();

        try {
            // La commande SQL
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_produitInsert(?,?)");

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
            PreparedStatement lpst = icn.prepareStatement("CALL villesUpdate(?,?,?,?,?,?)");

            lpst.setInt(1, Integer.valueOf(jLabelIDCategorieProduit.getText()));
            lpst.setString(2, jTextFieldCategorieProduit.getText());

            lpst.executeUpdate();

            icn.commit();

            lpst.close();
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        this.jLabelIDCategorieProduit.setText("");
        this.jTextFieldCategorieProduit.setText("");
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
    private javax.swing.JLabel jLabelIDCategorieProduit;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCategorieProduit;
    // End of variables declaration//GEN-END:variables
}
