package fr.leboncoin.daos;

import fr.leboncoin.Globale;
import fr.leboncoin.entities.CategorieClient;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pascal
 */
public class CategorieClientDAOTests {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection icn = null;
        try {
//            Class.forName("org.gjt.mm.mysql.Driver");
            icn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:" + "3306" + "/" + "leboncoin", "root", "");
            icn.setAutoCommit(false);
            System.out.println(icn);

            CategorieClientDAO daoCC = new CategorieClientDAO(icn);

            List<CategorieClient> listeCC = daoCC.selectAll();

            for (int i = 0; i < listeCC.size(); i++) {
                CategorieClient categorieClient = listeCC.get(i);
                System.out.println(categorieClient.getIdCategorieClient() + ";" + categorieClient.getCategorieClient());
            }
            
            
            CategorieClient cc = new CategorieClient(0, "Assoc");
            int liAffecte = daoCC.insert(cc);
            System.out.println(liAffecte);
            
            cc.setIdCategorieClient(6);
            liAffecte = daoCC.delete(cc);
            System.out.println(liAffecte);
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } /// main

} /// class

