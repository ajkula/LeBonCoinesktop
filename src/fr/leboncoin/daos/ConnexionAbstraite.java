package fr.leboncoin.daos;

import java.sql.Connection;

/**
 *
 * @author pascal
 */
public abstract class ConnexionAbstraite {

    public abstract Connection seConnecter(String serveur, String port, String ut, String mdp, String bd);

    public abstract void seDeconnecter();

    public abstract boolean valider();

    public abstract boolean annuler();
} /// class ConnexionAbstraite
