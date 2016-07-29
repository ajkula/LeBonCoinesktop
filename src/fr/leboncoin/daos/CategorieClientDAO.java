package fr.leboncoin.daos;

import fr.leboncoin.entities.CategorieClient;
import java.sql.*;
import java.util.*;

/**
 *
 * @author pascal
 */
public class CategorieClientDAO implements IDAO<CategorieClient> {

    private Connection icn;

    public CategorieClientDAO(Connection icn) {
        this.icn = icn;
    }

    @Override
    public int insert(CategorieClient objet) {
        int liAffecte = -1;

        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientInsert(?,?)");
            lpst.setInt(1, objet.getIdCategorieClient());
            lpst.setString(2, objet.getCategorieClient());
            lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public List<CategorieClient> selectAll() {

        List<CategorieClient> liste = new ArrayList<>();
        CategorieClient cc = null;

        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientSelectAll()");
            ResultSet lrs = lpst.executeQuery();
            while (lrs.next()) {
                cc = new CategorieClient(lrs.getInt(1), lrs.getString(2));
                liste.add(cc);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liste;
    }

    @Override
    public CategorieClient selectOne(int id) {
        CategorieClient cc = null;

        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientSelectOne(?)");
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();
            if (lrs.next()) {
                cc = new CategorieClient(lrs.getInt(1), lrs.getString(2));
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cc;
    }

    @Override
    public int delete(CategorieClient objet) {
        int liAffecte = -1;

        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientDelete(?)");
            lpst.setInt(1, objet.getIdCategorieClient());
            lpst.executeUpdate();
            icn.commit();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public int update(CategorieClient objet) {
        int liAffecte = -1;

        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_clientUpdate(?,?)");
            lpst.setInt(1, objet.getIdCategorieClient());
            lpst.setString(2, objet.getCategorieClient());
            lpst.executeUpdate();
            icn.commit();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

} /// class
