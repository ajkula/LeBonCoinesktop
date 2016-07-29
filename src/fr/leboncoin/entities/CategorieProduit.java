package fr.leboncoin.entities;

/**
 *
 * DTO (Data Transfert Object)
 *
 * @author pascal
 */
public class CategorieProduit {

    private int idCategorieProduit;
    private String categorieProduit;

    public CategorieProduit() {
    }

    public CategorieProduit(int idCategorieProduit, String categorieProduit) {
        this.idCategorieProduit = idCategorieProduit;
        this.categorieProduit = categorieProduit;
    }

    public int getIdCategorieProduit() {
        return idCategorieProduit;
    }

    public void setIdCategorieProduit(int idCategorieProduit) {
        this.idCategorieProduit = idCategorieProduit;
    }

    public String getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(String categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

} /// class
