/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.leboncoin.entities;

/**
 *
 * @author formation
 */
public class CategorieClient {

    private int idCategorieClient;
    private String categorieClient;

    public CategorieClient() {
    }

    public CategorieClient(int idCategorieClient, String categorieClient) {
        this.idCategorieClient = idCategorieClient;
        this.categorieClient = categorieClient;
    }

    public int getIdCategorieClient() {
        return idCategorieClient;
    }

    public void setIdCategorieClient(int idCategorieClient) {
        this.idCategorieClient = idCategorieClient;
    }

    public String getCategorieClient() {
        return categorieClient;
    }

    public void setCategorieClient(String categorieClient) {
        this.categorieClient = categorieClient;
    }

} /// class
