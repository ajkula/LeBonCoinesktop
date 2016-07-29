package fr.leboncoin.daos;

import fr.leboncoin.entities.CategorieProduit;
import java.util.*;
import java.sql.*;

/**
 *
 * @author pascal
 */
public class CategorieProduitDAO implements IDAO<CategorieProduit> {

    private Connection icn;

    public CategorieProduitDAO(Connection icn) {
        this.icn = icn;
    }

    @Override
    public int insert(CategorieProduit objet) {
        int liAffecte = -1;
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_produitInsert(?,?)");
            lpst.setInt(1, 0);
            lpst.setString(2, objet.getCategorieProduit());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
        }
        return liAffecte;
    }

    @Override
    public List<CategorieProduit> selectAll() {
        List<CategorieProduit> liste = new ArrayList();
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_produitSelectAll()");
            ResultSet lrs = lpst.executeQuery();
            CategorieProduit cp;
            while (lrs.next()) {
                cp = new CategorieProduit(lrs.getInt(1), lrs.getString(2));
                liste.add(cp);
            }
            lrs.close();
            lpst.close();
        } catch (SQLException e) {
        }
        return liste;
    }

    @Override
    public CategorieProduit selectOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(CategorieProduit objet) {
        int liAffecte = -1;
        try {
            PreparedStatement lpst = icn.prepareStatement("CALL categorie_produitDelete(?)");
            lpst.setInt(1, objet.getIdCategorieProduit());
            liAffecte = lpst.executeUpdate();
            lpst.close();
        } catch (SQLException e) {
        }
        return liAffecte;
    }

    @Override
    public int update(CategorieProduit objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} /// class
