package fr.leboncoin.daos;

import java.sql.*;

/**
 *
 * @author pascal
 */
public class ConnexionMySQLLocale extends ConnexionAbstraite {

    private Connection icn;

    /**
     *
     * @param serveur
     * @param port
     * @param ut
     * @param mdp
     * @param bd
     * @return
     */
    @Override
    public Connection seConnecter(String serveur, String port, String ut, String mdp, String bd) {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            icn = DriverManager.getConnection("jdbc:mysql://" + serveur + ":" + port + "/" + bd, ut, mdp);
            icn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return icn;
    } /// seConnecter

    /**
     *
     * @param psCheminFichierProperties
     * @return
     */
    public Connection seConnecter(String psCheminFichierProperties) {
        Connection lcn = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            /*
             TODO
             */
            icn.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return lcn;
    } /// seConnecter

    /**
     *
     */
    @Override
    public void seDeconnecter() {
        try {
            icn.close();
        } catch (SQLException ex) {
            //Logger.getLogger(ConnexionMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } /// seDeconnecter

    /**
     *
     * @return
     */
    @Override
    public boolean valider() {
        boolean lbOK = true;
        try {
            icn.commit();
        } catch (SQLException e) {
            lbOK = false;
        }
        return lbOK;
    } /// valider

    /**
     *
     * @return
     */
    @Override
    public boolean annuler() {
        boolean lbOK = true;
        try {
            icn.rollback();
        } catch (SQLException e) {
            lbOK = false;
        }
        return lbOK;
    } /// annuler
} /// class Connexion
