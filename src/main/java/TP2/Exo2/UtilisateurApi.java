package TP2.Exo2;

import com.google.protobuf.ServiceException;

public interface UtilisateurApi {
    void creerUtilisateur(Utilisateur utilisateur) throws ServiceException;
}