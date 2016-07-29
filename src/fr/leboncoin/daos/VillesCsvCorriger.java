/*
le probleme : il y 318 villes qui n'ont que 8 champs au lieu de 9,
il manque le dernier
De toutes façons on le ne prend pas le dernier

id;nom;nom_majus;cp;insee;dept;lat;lng;distance

on ne garde que nom,cp,lat,lng donc 1,3,6,7

 */
package fr.leboncoin.daos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author pascal
 */
public class VillesCsvCorriger {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int liProblemo = 0;
        int liLigne = 2;
        StringBuilder lsb = new StringBuilder();
        lsb.append("nom;cp;lat;lng\n");

        try {
            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("villes_a_corriger.csv");
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
                    if (tChamps.length == 9 || tChamps.length==8) {
//                        System.out.println("Ligne Ok");
                        lsb.append(tChamps[1]);
                        lsb.append(";");
                        lsb.append(tChamps[3]);
                        lsb.append(";");
                        lsb.append(tChamps[6]);
                        lsb.append(";");
                        lsb.append(tChamps[7]);
                        lsb.append("\n");
                        
                    } else {
                        System.out.println("Problemo à la ligne : " + liLigne);
                        liProblemo++;
                    }
                }
                liLigne++;
            }

            lbrBuffer.close();
            lfrFichier.close();
            
            FileWriter lfw = new FileWriter("villes.csv");
            lfw.write(lsb.toString());
            lfw.close();
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("C'est fini !");
        System.out.println("Lignes : " + liLigne);
        System.out.println("Problemi : " + liProblemo);
    } /// main

} /// class

