package fr.leboncoin.essais;

import fr.leboncoin.daos.ConnexionMySQLDistante;
import java.sql.*;

/**
 *
 * @author pascal
 */
public class AccesAlwaysdata {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            ConnexionMySQLDistante cnx = new ConnexionMySQLDistante();
            // Connection seConnecter(String serveur, String port, String ut, String mdp, String bd)
            Connection lcn = cnx.seConnecter("mysql-pascalbuguet.alwaysdata.net", "3306", "122197", "schifo", "pascalbuguet_leboncoin");
            System.out.println(lcn);

            PreparedStatement lpst = lcn.prepareStatement("SELECT * FROM PAYS");
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                System.out.println(lrs.getString(1) + ":" + lrs.getString(2));
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } /// main

} /// class

