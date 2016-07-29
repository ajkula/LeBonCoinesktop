package fr.leboncoin.entities;

public class Utilisateur {

    private int idUtilisateur;
    private String pseudo;
    private String mdp;

    public Utilisateur() {
    }

    public Utilisateur(int idUtilisateur, String pseudo, String mdp) {
        this.idUtilisateur = idUtilisateur;
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur + ", pseudo=" + pseudo + ", mdp=" + mdp + '}';
    }

} /// class Utilisateur
