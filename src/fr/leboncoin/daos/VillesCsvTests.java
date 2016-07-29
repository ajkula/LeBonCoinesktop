/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.leboncoin.daos;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author pascal
 */
public class VillesCsvTests {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int liProblemo=0;
        int liLigne = 2;
        
        try {
             // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("villes.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            // On saute les entetes
            lsEnregistrement = lbrBuffer.readLine();
            // On boucle a partir de la 2eme ligne donc la premiere commune
            
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {
                if (lsEnregistrement.trim().length() > 0) {
                    String[] tChamps = lsEnregistrement.split(";");
                    if (tChamps.length == 9) {
//                        System.out.println("Ligne Ok");
                    }
                    else {
                        System.out.println("Problemo à la ligne : " + liLigne);
                        liProblemo++;
                    }
                }
                liLigne++;
            }

            lbrBuffer.close();
            lfrFichier.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("C'est fini !");
        System.out.println("Lignes : " + liLigne);
        System.out.println("Problemi : " + liProblemo);
    } /// main

} /// class

