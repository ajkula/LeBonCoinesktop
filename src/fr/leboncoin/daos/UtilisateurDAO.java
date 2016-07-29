package fr.leboncoin.daos;

import fr.leboncoin.entities.Utilisateur;
import java.sql.*;
import java.util.List;

/**
 *
 * @author pascal
 */
public class UtilisateurDAO implements IDAO<Utilisateur> {

    private Connection icn;

    /**
     *
     * @param acn
     */
    public UtilisateurDAO(Connection acn) {
        icn = acn;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int insert(Utilisateur objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public List<Utilisateur> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Utilisateur selectOne(int id) {
        Utilisateur u = null;

        try {
            // id
            PreparedStatement lpst = icn.prepareStatement("CALL clientsSelectOne(?)");
            lpst.setInt(1, id);
            ResultSet lrs = lpst.executeQuery();

            if (lrs.next()) {
                u = new Utilisateur(lrs.getInt(1), lrs.getString(2), lrs.getString(3));
            }
            lrs.close();
            lpst.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;
    } /// selectOne

    public Utilisateur selectOne(String asPseudo, String asMDP) {
        Utilisateur u = null;

        try {
            // id
            String lsSQL = "SELECT * FROM utilisateurs WHERE pseudo_utilisateur = ? AND mdp_utilisateur = ?";
            PreparedStatement lpst = icn.prepareStatement(lsSQL);
            lpst.setString(1, asPseudo);
            lpst.setString(2, asMDP);
            ResultSet lrs = lpst.executeQuery();

            if (lrs.next()) {
                u = new Utilisateur(lrs.getInt(1), lrs.getString(2), lrs.getString(3));
            }
            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            u = new Utilisateur(0, "Erreur", e.getMessage());
            System.out.println(e.getMessage());
        }

        return u;
    } /// selectOne

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int delete(Utilisateur objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int update(Utilisateur objet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} /// class UtilisateurDAO
