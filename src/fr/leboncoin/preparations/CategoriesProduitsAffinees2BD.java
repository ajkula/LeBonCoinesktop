package fr.leboncoin.preparations;

import fr.leboncoin.Globale;
import java.sql.*;
import java.io.*;

/**
 *
 * Phase 2 : passer des categories produits affinees a la BD
 *
 * On prend pour les categories produits les lignes en majuscules
 *
 * On prend pour les sous-categories produits les autres lignes
 *
 * @author pascal
 */
public class CategoriesProduitsAffinees2BD {

    /**
     *
     * @return
     */
    public static boolean importations() {
        
        boolean lbOK = true;
        String lsInsertCategorie = "INSERT INTO CATEGORIE_PRODUIT(CATEGORIE_PRODUIT) VALUES(?)";
        String lsInsertSousCategorie = "INSERT INTO SOUS_CATEGORIE_PRODUIT(SOUS_CATEGORIE_PRODUIT, ID_CATEGORIE_PRODUIT) VALUES(?,?)";

        int liNouvelleCle = 0;

        try {

//            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            lcn.setAutoCommit(false);
            
            Connection lcn = Globale.getCn();

            PreparedStatement lpstInsertCategorie = lcn.prepareStatement(lsInsertCategorie, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement lpstInsertSousCategorie = lcn.prepareStatement(lsInsertSousCategorie);
            ResultSet lrsNouvelleCle;

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("categories_brutes_affinees.txt");

            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            // On boucle a partir de la 1eme ligne
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {
                // Si enregistrement non vide
                if (lsEnregistrement.trim().length() > 0) {
                    // Mot MAJUS
                    if (isUpperCaseWord(lsEnregistrement)) {
                        lpstInsertCategorie.setString(1, lsEnregistrement);
                        lpstInsertCategorie.executeUpdate();
                        lrsNouvelleCle = lpstInsertCategorie.getGeneratedKeys();
                        lrsNouvelleCle.next();
                        liNouvelleCle = lrsNouvelleCle.getInt(1);
                        lrsNouvelleCle.close();
                    } else {
                        lpstInsertSousCategorie.setString(1, lsEnregistrement);
                        lpstInsertSousCategorie.setInt(2, liNouvelleCle);
                        lpstInsertSousCategorie.executeUpdate();
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();

            lcn.commit();
            lpstInsertSousCategorie.close();
            lpstInsertCategorie.close();
            lcn.close();

        } catch (SQLException | IOException e) {
            lbOK = false;
        }
        return lbOK;
    } /// importations

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        importations();
    } /// main

    /**
     *
     * isUpper si MAJ + Espace seulement
     *
     * @param word
     * @return
     */
    private static boolean isUpperCaseWord(String word) {
        boolean lbOK = false;

//        int i =0;
//        while(word.charAt(i) ){
//            i++;
//        }
        String motif = "[A-Z ]{1,}";
        if (word.matches(motif)) {
            lbOK = true;
        }

        System.out.println(word + " : " + lbOK);

        return lbOK;
    } /// isUpperCaseWord

} /// class

