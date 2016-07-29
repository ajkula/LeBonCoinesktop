package fr.leboncoin.preparations;

import java.io.*;
import java.util.*;

/**
 *
 * Phase 1 : Passer des categories brutes "volees" sur le site a des categories
 * affinees
 * 
 * On ne prend que les lignes qui ne commencent pas <
 *
 * @author pascal
 */
public class CategoriesProduitsBrutesEtc {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String lsMessage = "Traitement terminé avec succès !";

        StringBuilder lsbFichierOUT = new StringBuilder();

        List<String> liste = new ArrayList();

        try {

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("categories_brutes.txt");

            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            // On boucle a partir de la 1eme ligne
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {
                // Si ligne non vide
                if (lsEnregistrement.trim().length() > 0) {
                    // Si 1er caractere different de <
                    if (lsEnregistrement.charAt(0) != '<') {
                        lsbFichierOUT.append(lsEnregistrement);
                        lsbFichierOUT.append("\n");
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();

            /*
             OUT
             */
            FileWriter lfwFichier = new FileWriter("categories_brutes_affinees.txt");
            lfwFichier.write(lsbFichierOUT.toString());
            lfwFichier.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            lsMessage = e.getMessage();
        }
        System.out.println(lsMessage);
    } /// main

} /// class

