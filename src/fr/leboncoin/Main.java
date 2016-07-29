package fr.leboncoin;

import fr.leboncoin.boundaries.JDialogAuthentification;
import fr.leboncoin.boundaries.MDI;
import fr.leboncoin.daos.ConnexionMySQLDistante;
import java.sql.Connection;

/**
 *
 * @author pascal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         LOCALE
         */
        Globale.setIp("127.0.0.1");
        Globale.setPort("3306");
        Globale.setUt("root");
        Globale.setMdp("");
        Globale.setBd("leboncoin");

        /*
         DISTANTE
         */
//        Globale.setIp("172.26.55.55");
//        Globale.setPort("3306");
//        Globale.setUt("p");
//        Globale.setMdp("b");
//        Globale.setBd("leboncoin");
        String ip = Globale.getIp();
        String port = Globale.getPort();
        String ut = Globale.getUt();
        String mdp = Globale.getMdp();
        String bd = Globale.getBd();

        System.out.println(ip);
        System.out.println(port);
        System.out.println(ut);
        System.out.println(mdp);
        System.out.println(bd);

        ConnexionMySQLDistante cnx = new ConnexionMySQLDistante();
        Connection cn = cnx.seConnecter("127.0.0.1", "3306", "root", "", "leboncoin");

        Globale.setCn(cn);

        new JDialogAuthentification(null, true);

        new MDI();
    } /// main
} /// class
