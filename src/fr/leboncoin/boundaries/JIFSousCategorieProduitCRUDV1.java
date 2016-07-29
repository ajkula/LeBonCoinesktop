package fr.leboncoin.boundaries;

import fr.leboncoin.Globale;
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
public class JIFSousCategorieProduitCRUDV1 extends javax.swing.JInternalFrame {

    private Connection icn;
    private List<String> liste = new ArrayList();
    private int iiCount = 0;
    private int iiPosition = 0;
    // ID CAT, Libelle CAT
    private Map<String, String> mapCategorieIDLibelle = new HashMap();
    // Libelle CAT, ID CAT
    private Map<String, String> mapCategorieLibelleID = new HashMap();

    // --- Menu Popup
    private final JPopupMenu menuPopup = new JPopupMenu("Edit");

    private JMenuItem itemCouper = new JMenuItem("Couper");
    private JMenuItem itemCopier = new JMenuItem("Copier");
    private JMenuItem itemColler = new JMenuItem("Coller");

    /**
     * Creates new form JIFVillesCRUD
     */
    public JIFSousCategorieProduitCRUDV1() {
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
                PreparedStatement lpst = icn.prepareStatement("CALL sous_categorie_produitSelectAll()");
                ResultSet lrs = lpst.executeQuery();
                while (lrs.next()) {
                    iiCount++;
                    // ID SOUS CAT;ID CAT;LIBELLE SOUS CAT
                    liste.add(lrs.getString(1) + ";" + lrs.getString(2) + ";" + lrs.getString(3));
                }
                lrs.close();
                lpst.close();

                lpst = icn.prepareStatement("CALL categorie_produitSelectAll()");
                lrs = lpst.executeQuery();
                while (lrs.next()) {
                    mapCategorieIDLibelle.put(lrs.getString(1), lrs.getString(2));
                    mapCategorieLibelleID.put(lrs.getString(2), lrs.getString(1));
                    jComboBoxCategoriesProduits.addItem(lrs.getString(2));
                }
                lrs.close();
                lpst.close();

            } else {
                jLabelMessage.setText("Problemo !!!");
            }

        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }

        jLabelIDSousCategorieProduit.setText("");
        jTextFieldSousCategorieProduit.setText("");

        setTitle("CRUD Sous-Catégorie Produit");
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

            this.jLabelIDSousCategorieProduit.setText(tChamps[0]);
            this.jTextFieldSousCategorieProduit.setText(tChamps[2]);
            String lsIdCategorie = tChamps[1];
            jComboBoxCategoriesProduits.setSelectedItem(mapCategorieIDLibelle.get(lsIdCategorie));
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
        jTextFieldSousCategorieProduit = new javax.swing.JTextField();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelIDSousCategorieProduit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonCLS = new javax.swing.JButton();
        jButtonAjouter = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonLast = new javax.swing.JButton();
        jLabelCompteur = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCategoriesProduits = new javax.swing.JComboBox();

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

        jLabel1.setText("Sous Catégorie produit");

        jLabelMessage.setText("Message");

        jTextFieldSousCategorieProduit.setText("Gateaux");

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

        jLabelIDSousCategorieProduit.setForeground(new java.awt.Color(255, 0, 51));
        jLabelIDSousCategorieProduit.setText("ID");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addContainerGap())
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

        jLabel2.setText("Catégorie produit");

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
                            .addComponent(jLabel5)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelIDSousCategorieProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jTextFieldSousCategorieProduit, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCompteur)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxCategoriesProduits, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonFirst)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNext)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonLast))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonModifier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSupprimer)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelIDSousCategorieProduit))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldSousCategorieProduit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCategoriesProduits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFirst)
                    .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonLast))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonModifier)
                            .addComponent(jButtonSupprimer))))
                .addGap(18, 18, 18)
                .addComponent(jLabelCompteur)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMessage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // Vers BD
        try {

            PreparedStatement lpst = icn.prepareStatement("CALL sous_categorie_produitDelete(?)");
            lpst.setInt(1, Integer.valueOf(jLabelIDSousCategorieProduit.getText()));
            lpst.executeUpdate();

            icn.commit();

            lpst.close();

            jLabelMessage.setText("Jusque là tout va bien !!!");

        } catch (SQLException ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed

        int liIDSousCategorie = 0;
        String lsLibelle = jTextFieldSousCategorieProduit.getText();
        int liIDCategorie = Integer.valueOf(mapCategorieLibelleID.get(jComboBoxCategoriesProduits.getSelectedItem().toString()));
        try {
            // La commande SQL
            PreparedStatement lpst = icn.prepareStatement("CALL sous_categorie_produitInsert(?,?,?)");

            // Valorisation des parametres
            lpst.setInt(1, liIDSousCategorie);
            lpst.setInt(2, liIDCategorie);
            lpst.setString(3, lsLibelle);

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
            // sous_categorie_produitUpdate(paramID_SOUS_CATEGORIE_PRODUIT INT(10),paramID_CATEGORIE_PRODUIT INT(10),paramSOUS_CATEGORIE_PRODUIT VARCHAR(50))
            PreparedStatement lpst = icn.prepareStatement("CALL sous_categorie_produitUpdate(?,?,?)");

            lpst.setInt(1, Integer.valueOf(jLabelIDSousCategorieProduit.getText()));
            lpst.setInt(2, Integer.valueOf(mapCategorieLibelleID.get(jComboBoxCategoriesProduits.getSelectedItem().toString())));

            lpst.setString(3, jTextFieldSousCategorieProduit.getText());

            lpst.executeUpdate();

            icn.commit();

            lpst.close();
        } catch (SQLException e) {
            jLabelMessage.setText(e.getMessage());
        }
    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        //
        this.jLabelIDSousCategorieProduit.setText("");
        this.jTextFieldSousCategorieProduit.setText("");
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

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JComboBox jComboBoxCategoriesProduits;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelCompteur;
    private javax.swing.JLabel jLabelIDSousCategorieProduit;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldSousCategorieProduit;
    // End of variables declaration//GEN-END:variables
}
