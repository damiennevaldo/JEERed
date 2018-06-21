package com.controleur;

import com.employes.utils.EmployesConstantes;
import static com.employes.utils.EmployesConstantes.*;
import com.model.Employes;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Groupe Rouge
 */
@Stateless
public class ConnexionPersistence {

    @PersistenceContext(unitName = "EmployesServletJPAPU")
    private EntityManager em;

    //MODIFIER EMPLOYES (PREPARED STATEMENT) Objet Employes
    public Collection getEmployes() {
        Query q = em.createQuery(REQUEST_SELECT_TOUS_EMPLOYES);
        return q.getResultList();
    }

    public Collection getEmployesId(int idEmp) {
        Query q = em.createQuery(REQUEST_SELECT_EMPLOYES_ID + "idEmp");
        q.setParameter("idEmp", idEmp);
        return q.getResultList();
    }

    public Collection getIdentifiants() {
        Query q = em.createQuery(REQUEST_SELECT_IDENTIFIANTS);
        return q.getResultList();
    }

    public void modifierEmployes(Employes e) {
        Employes emp = (Employes) em.find(Employes.class, e.getId());
        emp.setNom(e.getNom());
        emp.setPrenom(e.getPrenom());
        emp.setTeldom(e.getTeldom());
        emp.setTelport(e.getTelport());
        emp.setTelpro(e.getTelpro());
        emp.setAdresse(e.getAdresse());
        emp.setCodepostal(e.getCodepostal());
        emp.setVille(e.getVille());
        emp.setEmail(e.getEmail());
        this.persist(emp);
    }

    public int supprimerEmployes(int idEmp) {
        Query q = em.createQuery(REQUEST_DELETE_EMPLOYES + "idEmp");
        q.setParameter("idEmp", idEmp);
        return q.executeUpdate();
    }

    //SI NE MARCHE PAS AVEC DES VALEURS NULLES POUR LES CHAMPS NON UTILISES, 
    //FAIRE UNE AUTRE METHODE QUI SET MOINS DE CARACTERISTIQUES
    public void ajouterEmployes(Employes emp) {
        Employes e = new Employes();
        e.setAdresse(emp.getAdresse());
        e.setCodepostal(emp.getCodepostal());
        e.setEmail(emp.getEmail());
        e.setNom(emp.getNom());
        e.setPrenom(emp.getPrenom());
        e.setTeldom(emp.getTeldom());
        e.setTelport(emp.getTelport());
        e.setTelpro(emp.getTelpro());
        e.setVille(emp.getVille());
        if (!emp.getNom().equals("")) {
            this.persist(e);
        }
    }

    public void ajouter5Employes(Employes employe) {
        Query q = em.createNativeQuery(EmployesConstantes.REQUEST_AJOUTER_5_EMPLOYES);
        this.persist(employe);

    }

    public void persist(Object object) {
        em.persist(object);
    }

}
