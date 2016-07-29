package fr.leboncoin.essais;

import java.io.*;
import java.util.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;

/**
 *
 * @author pascal
 */
public class CsvGrandesVilles {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String lsMessage = "Traitement terminé avec succès !";

        StringBuilder lsbFichierOUT = new StringBuilder();
        lsbFichierOUT.append("nom_ville_majus;nom_ville_reel;insee;cp;habitants\n");

        List<String> liste = new ArrayList();
        int liNbHabitants;
        StringBuilder lsbLigne = new StringBuilder();

        try {

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("villes_france.csv");

            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            // On saute les entetes
            lsEnregistrement = lbrBuffer.readLine();

            // On boucle a partir de la 2eme ligne donc la premiere commune
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {
                if (lsEnregistrement.trim().length() > 0) {
                    String[] tChamps = lsEnregistrement.split(",");
                    liNbHabitants = Integer.valueOf(tChamps[16]);
                    lsbLigne.setLength(0);
                    if (liNbHabitants > 50000) {
                        // nom ville majus
                        lsbLigne.append(tChamps[3]);
                        lsbLigne.append(";");
                        // nom_ville_reel
                        lsbLigne.append(tChamps[5]);
                        lsbLigne.append(";");
                        // cp
                        lsbLigne.append(tChamps[8].substring(0, 5));
                        lsbLigne.append(";");
                        // insee
                        lsbLigne.append(tChamps[10]);
                        lsbLigne.append(";");
                        // habitants
                        lsbLigne.append(tChamps[16]);
                        //lsbLigne.append("\n");

                        liste.add(lsbLigne.toString());
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();

            String[] tContenu = liste.toArray(new String[liste.size()]);
            Arrays.sort(tContenu);

            for (int i = 0; i < tContenu.length; i++) {
                String ville = tContenu[i];
                lsbFichierOUT.append(ville);
                lsbFichierOUT.append("\n");
            }
            /*
             OUT
             */
            FileWriter lfwFichier = new FileWriter("grandes_villes_reduites.txt");
            lfwFichier.write(lsbFichierOUT.toString());
            lfwFichier.close();

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
            lsMessage = e.getMessage();
        }
        System.out.println(lsMessage);
    } /// main

} /// class

