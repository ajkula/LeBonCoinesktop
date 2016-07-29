package fr.leboncoin.daos;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pascal
 */
public class PaysDAO {

    public static boolean insert(Connection pcn, Map<String, String> map) throws SQLException {
        boolean lbOK = true;
        pcn.setAutoCommit(false);

        /*
         Le PreparetedStatement pour l'INSERT
         */
        PreparedStatement lpstInsert = pcn.prepareStatement("INSERT INTO PAYS(NOM_PAYS, CODE_PAYS, CODE_ISO3_PAYS) VALUES(?,?,?)");
        lpstInsert.setString(1, map.get("nom_pays"));
        lpstInsert.setString(2, map.get("code_pays"));
        lpstInsert.setString(3, map.get("code_iso3_pays"));

        lpstInsert.executeUpdate();

        return lbOK;
    } /// insert

    // --------------------
    public static void main(String[] args) {
        ConnexionMySQLLocale cnx = new ConnexionMySQLLocale();
        // seConnecter(String serveur, String port, String ut, String mdp, String bd)
        Connection lcn = cnx.seConnecter("127.0.0.1", "3306", "root", "", "leboncoin");

        Map<String, String> mapInsert = new HashMap<>();
        mapInsert.put("nom_pays", "Zero");
        mapInsert.put("code_pays", "000");
        mapInsert.put("code_iso3_pays", "ZER");
        try {
            insert(lcn, mapInsert);
            lcn.commit();
            System.out.println("Insertion résussie !!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    } /// main

} /// class
