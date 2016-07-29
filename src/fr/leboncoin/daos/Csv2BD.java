package fr.leboncoin.daos;

/*
 * CSV 2 BD
 */
import fr.leboncoin.Globale;
import java.io.*;
import java.sql.*;
import java.util.*;

// ----------------
public class Csv2BD {

    /**
     *
     * @return
     */
    public static String paysCsv2BD() {
        String lsMessage = "Traitement terminé avec succès !";
        try {
//            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            lcn.setAutoCommit(false);
            Connection lcn = Globale.getCn();

            PreparedStatement lpstInsert = lcn.prepareStatement("INSERT INTO PAYS(NOM_PAYS, CODE_PAYS, CODE_ISO3_PAYS) VALUES(?,?,?)");

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("pays.csv");
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
                    if (tChamps.length == 6) {
                        // nom pays
                        lpstInsert.setString(1, tChamps[4].trim());
                        // code pays
                        lpstInsert.setString(2, tChamps[1].trim());
                        // code iso3
                        lpstInsert.setString(3, tChamps[3].trim());
                        // INSERTION
                        lpstInsert.executeUpdate();
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();
            lpstInsert.close();
            lcn.commit();
//            lcn.close();

            System.out.println("Terminé avec succès !");
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            lsMessage = e.getMessage();
        }

        return lsMessage;
    } /// paysCsv2BD

    /**
     *
     * @return
     */
    public static String regionsCsv2BD() {
        String lsMessage = "Traitement terminé avec succès !";
        try {
            //Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            Connection lcn = DriverManager.getConnection("jdbc:mysql://mysql-pascalbuguet.alwaysdata.net:3306/pascalbuguet_leboncoin", "122197", "schifo");
//            lcn.setAutoCommit(false);
            Connection lcn = Globale.getCn();

            /*
             Recuperation de l'ID du pays
             */
            PreparedStatement lpstSelectIdPays = lcn.prepareStatement("SELECT ID_PAYS FROM PAYS WHERE NOM_PAYS = ?");
            lpstSelectIdPays.setString(1, "france");
            ResultSet lrsIdPays = lpstSelectIdPays.executeQuery();
            String lsIdPays;
            Map<String, String> mapRegions = new TreeMap();
            if (lrsIdPays.next()) {
                lsIdPays = lrsIdPays.getString(1);
                //System.out.println("ID pays : " + lsIdPays);
                lrsIdPays.close();
                lpstSelectIdPays.close();

                // --- Ouverture du fichier
                FileReader lfrFichier = new FileReader("departements_regions_france_2016.csv");
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
                        if (tChamps.length == 4) {
                            // code region, nom region
                            mapRegions.put(tChamps[2].trim(), tChamps[3].trim());
                        }
                    }
                }

                lbrBuffer.close();
                lfrFichier.close();

                // Du HashMap a la BD
                PreparedStatement lpstInsert = lcn.prepareStatement("INSERT INTO REGION(ID_PAYS, NOM_REGION, CODE_REGION) VALUES(?,?,?)");

                for (Map.Entry<String, String> ligne : mapRegions.entrySet()) {
                    String codeRegion = ligne.getKey();
                    String nomRegion = ligne.getValue();
                    // id_pays
                    lpstInsert.setString(1, lsIdPays);
                    // nom_region
                    lpstInsert.setString(2, nomRegion);
                    // code_region
                    lpstInsert.setString(3, codeRegion);
                    // INSERT
                    lpstInsert.executeUpdate();
                }

                lpstInsert.close();
                lcn.commit();
//                lcn.close();
            } else {
                lsMessage = "Problemo !!!";
            }
        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            lsMessage = e.getMessage();
        }
        System.out.println(lsMessage);

        return lsMessage;
    } /// regionsCsv2BD

    /**
     *
     * @return
     */
    public static String departementsCsv2BD() {

        /*
         Le departement 20 - Corse (code region 84) a ete ajoute manuellement
         */
        String lsMessage = "Traitement terminé avec succès !";
        try {
            //Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            Connection lcn = DriverManager.getConnection("jdbc:mysql://mysql-pascalbuguet.alwaysdata.net:3306/pascalbuguet_leboncoin", "122197", "schifo");
//            lcn.setAutoCommit(false);
            Connection lcn = Globale.getCn();
            /*
             Le PreparetedStatement pour le SELECT id_region
             */
            PreparedStatement lpstSelect = lcn.prepareStatement("SELECT ID_REGION FROM REGION WHERE CODE_REGION = ?");
            ResultSet lrs = null;
            /*
             Le PreparetedStatement pour l'INSERT
             */
            PreparedStatement lpstInsert = lcn.prepareStatement("INSERT INTO DEPARTEMENT(CODE_DEPARTEMENT,NOM_DEPARTEMENT,ID_REGION) VALUES(?,?,?)");

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("departements_regions_france_2016.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            String lsCodeDepartement;
            String lsNomDepartement;
            String lsCodeRegion;
            String lsIdRegion;

            // On saute les entetes
            lsEnregistrement = lbrBuffer.readLine();
            // On boucle a partir de la 2eme ligne donc la premiere commune
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {

                if (lsEnregistrement.trim().length() > 0) {

                    String[] tChamps = lsEnregistrement.split(",");

                    if (tChamps.length == 4) {

                        lsCodeDepartement = tChamps[0].trim();
                        lsNomDepartement = tChamps[1].trim();
                        lsCodeRegion = tChamps[2].trim();

                        lpstSelect.setString(1, lsCodeRegion);
                        lrs = lpstSelect.executeQuery();
                        lrs.next();
                        lsIdRegion = lrs.getString(1);

                        lpstInsert.setString(1, lsCodeDepartement);
                        lpstInsert.setString(2, lsNomDepartement);
                        lpstInsert.setString(3, lsIdRegion);

                        System.out.println(lsCodeDepartement + "-" + lsNomDepartement + "-" + lsIdRegion);

                        // INSERT
                        lpstInsert.executeUpdate();
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();

            lrs.close();
            lpstInsert.close();
            lcn.commit();
//            lcn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage());
            lsMessage = e.getMessage();
        }
        System.out.println(lsMessage);
        return lsMessage;
    } /// departementsCsv2BD

    /**
     *
     * @return
     */
    public static String villesCsv2BD() {
        String lsMessage = "Traitement terminé avec succès !";
        int liLigne = 1;
        int liProblemo = 0;
        try {
            //Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/leboncoin", "root", "");
//            Connection lcn = DriverManager.getConnection("jdbc:mysql://mysql-pascalbuguet.alwaysdata.net:3306/pascalbuguet_leboncoin", "122197", "schifo");
//            lcn.setAutoCommit(false);
            Connection lcn = Globale.getCn();
            /*
             Le PreparetedStatement pour le SELECT id_departement
             */
            PreparedStatement lpstSelect = lcn.prepareStatement("SELECT ID_DEPARTEMENT FROM DEPARTEMENT WHERE CODE_DEPARTEMENT = ?");
            ResultSet lrs = null;
            /*
             Le PreparetedStatement pour l'INSERT
             */
            PreparedStatement lpstInsert = lcn.prepareStatement("INSERT INTO VILLE(NOM_VILLE, CP_VILLE, LATITUDE_VILLE, LONGITUDE_VILLE, ID_DEPARTEMENT) VALUES(?,?,?,?,?)");

            // --- Ouverture du fichier
            FileReader lfrFichier = new FileReader("villes.csv");
            // --- Bufferisation
            BufferedReader lbrBuffer = new BufferedReader(lfrFichier);

            // --- Lecture des lignes-enregistrements
            String lsEnregistrement;

            String lsNomVille;
            String lsCPVille;
            String lsLAT;
            String lsLNG;
            String lsCodeDepartement;
            String lsIdDepartement;

            // On saute les entetes
            lsEnregistrement = lbrBuffer.readLine();
            // On boucle a partir de la 2eme ligne donc la premiere commune
            while ((lsEnregistrement = lbrBuffer.readLine()) != null) {
                liLigne++;
                if (lsEnregistrement.trim().length() > 0) {

                    String[] tChamps = lsEnregistrement.split(";");

                    if (tChamps.length == 4) {

                        lsNomVille = tChamps[0].trim();
                        lsCPVille = tChamps[1].trim();
                        lsLAT = tChamps[2].trim();
                        lsLNG = tChamps[3].trim();
                        lsCodeDepartement = lsCPVille.substring(0, 2);

                        lpstSelect.setString(1, lsCodeDepartement);
                        lrs = lpstSelect.executeQuery();
                        if (lrs.next()) {
                            lsIdDepartement = lrs.getString(1);

                            lpstInsert.setString(1, lsNomVille);
                            lpstInsert.setString(2, lsCPVille);
                            lpstInsert.setDouble(3, Double.valueOf(lsLAT));
                            lpstInsert.setDouble(4, Double.valueOf(lsLNG));
                            lpstInsert.setString(5, lsIdDepartement);

                            //System.out.println(lsCodeDepartement + "-" + lsNomDepartement + "-" + lsIdRegion);
                            // INSERT
                            lpstInsert.executeUpdate();
                        } else {
                            liProblemo++;
                        }
                        lrs.close();
                    }
                }
            }

            lbrBuffer.close();
            lfrFichier.close();

//            lrs.close();
            lpstInsert.close();
            lcn.commit();
//            lcn.close();

        } catch (IOException | SQLException e) {
            System.out.println(e.getMessage() + " à la ligne " + liLigne);
            lsMessage = e.getMessage();
        }
        System.out.println(lsMessage);
        System.out.println("liProblemo : " + liProblemo);
        return lsMessage;
    } /// villesCsv2BD

    // --------------------
    public static void main(String[] args) {
//        paysCsv2BD();
//        regionsCsv2BD();
//        departementsCsv2BD();
//        villesCsv2BD();
    } /// main

} /// class
