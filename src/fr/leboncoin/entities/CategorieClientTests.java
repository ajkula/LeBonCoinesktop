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
public class CategorieClientTests {

    // --------------------
    public static void main(String[] args) {
        CategorieClient cc = new CategorieClient();
        
        cc.setIdCategorieClient(1);
        cc.setCategorieClient("zzz");
        
        System.out.println(cc.getIdCategorieClient() +"-"+cc.getCategorieClient());    
    } /// main

} /// class
