package fr.leboncoin;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pascal
 */
public class Globale {

    /*
     * Les variables de classe
     */
    private static Connection cn;
    private static int entier;
    private static String chaine;
    private static JDesktopPane bureauMDI;
    private static JFrame mdi;
    private static boolean authentifie;
    private static List<String> listeJDialog = new ArrayList();
    private static String ip;
    private static String port;
    private static String ut;
    private static String mdp;
    private static String bd;

    /*
     * Les getters et setters
     */
    public static boolean isAuthentifie() {
        return authentifie;
    }

    public static void setAuthentifie(boolean authentifie) {
        Globale.authentifie = authentifie;
    }

    public static Connection getCn() {
        return cn;
    }

    public static void setCn(Connection cn) {
        Globale.cn = cn;
    }

    public static int getEntier() {
        return entier;
    }

    public static void setEntier(int entier) {
        Globale.entier = entier;
    }

    public static String getChaine() {
        return chaine;
    }

    public static void setChaine(String chaine) {
        Globale.chaine = chaine;
    }

    public static JDesktopPane getBureauMDI() {
        return bureauMDI;
    }

    public static void setBureauMDI(JDesktopPane bureauMDI) {
        Globale.bureauMDI = bureauMDI;
    }

    public static JFrame getMdi() {
        return mdi;
    }

    public static void setMdi(JFrame mdi) {
        Globale.mdi = mdi;
    }

    /*
     * Autres
     */
    public static void ajouterAListeJDialog(String nomJDialog) {
        listeJDialog.add(nomJDialog);
    }

    public static void supprimerDansListeJDialog(String nomJDialog) {
        listeJDialog.remove(nomJDialog);
    }

    public static boolean isDansListeJDialog(String nomJDialog) {
        boolean presente;

        if (listeJDialog.contains(nomJDialog)) {
            presente = true;
        } else {
            presente = false;
        }

        return presente;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        Globale.ip = ip;
    }

    public static String getPort() {
        return port;
    }

    public static void setPort(String port) {
        Globale.port = port;
    }

    public static String getUt() {
        return ut;
    }

    public static void setUt(String ut) {
        Globale.ut = ut;
    }

    public static String getMdp() {
        return mdp;
    }

    public static void setMdp(String mdp) {
        Globale.mdp = mdp;
    }

    public static String getBd() {
        return bd;
    }

    public static void setBd(String bd) {
        Globale.bd = bd;
    }

} /// class Globale
