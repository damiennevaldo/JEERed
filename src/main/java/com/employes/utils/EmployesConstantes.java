package com.employes.utils;

public final class EmployesConstantes {

    //Requêtes 
    public static final String REQUEST_DELETE_EMPLOYES = "DELETE from Employes e where e.id=:";
    public static final String REQUEST_SELECT_EMPLOYES_ID = "SELECT e from Employes e where e.id=:";
    public static final String REQUEST_SELECT_TOUS_EMPLOYES = "SELECT e from Employes e";
    public static final String REQUEST_SELECT_IDENTIFIANTS = "SELECT i from Identifiants i";  
    public static final String REQUEST_AJOUTER_5_EMPLOYES = "INSERT INTO UTILISATEUR(LOGIN, PASSWORD) VALUES (?,?)";  

    //Constantes lié aux actions / submit
    public static final String ACTION = "action";
    public static final String ACTION_AJOUTER = "Ajouter";
    public static final String ACTION_AJOUTER_5 = "Ajouter5";
    public static final String ACTION_SUPPRIMER = "Supprimer";
    public static final String ACTION_DETAILS = "Details";
    public static final String ACTION_MODIFIER = "Modifier";
    public static final String ACTION_VOIR_LISTE = "VoirListe";
    public static final String ACTION_VOIR_AJOUTER = "VoirAjouter";
    public static final String ACTION_VOIR_AJOUTER_5 = "VoirAjouter5";
    public static final String ACTION_LOGIN = "Login";
    public static final String ACTION_ANNULER = "Annuler";

    //Constantes représentant les input de type text ou radio
    public static final String FRM_LOGIN = "login";
    public static final String FRM_MDP = "mdp";
    public static final String FRM_ID_EMPL_SELECT = "idEmploye";
    
    // Champs du formulaire de détails d'un employé
    public static final String CHAMP_ADRESSE = "frmAdresse";
    public static final String CHAMP_CODEPOSTAL = "frmCodePostal";
    public static final String CHAMP_EMAIL = "frmEmail";
    public static final String CHAMP_NOM = "frmNom";
    public static final String CHAMP_PRENOM = "frmPrenom";
    public static final String CHAMP_TELDOMICILE = "frmTelDomicile";
    public static final String CHAMP_TELPORTABLE = "frmTelPortable";
    public static final String CHAMP_TELPRO = "frmTelPro";
    public static final String CHAMP_VILLE = "frmVille";
    
    public static final String CHAMP_EMAIL_1 = "frmEmail1";
    public static final String CHAMP_NOM_1 = "frmNom1";
    public static final String CHAMP_PRENOM_1 = "frmPrenom1";
    
    public static final String CHAMP_EMAIL_2 = "frmEmail2";
    public static final String CHAMP_NOM_2 = "frmNom2";
    public static final String CHAMP_PRENOM_2 = "frmPrenom2";
    
    public static final String CHAMP_EMAIL_3 = "frmEmail3";
    public static final String CHAMP_NOM_3 = "frmNom3";
    public static final String CHAMP_PRENOM_3 = "frmPrenom3";
    
    public static final String CHAMP_EMAIL_4 = "frmEmail4";
    public static final String CHAMP_NOM_4 = "frmNom4";
    public static final String CHAMP_PRENOM_4 = "frmPrenom4";
    
    public static final String CHAMP_EMAIL_5 = "frmEmail5";
    public static final String CHAMP_NOM_5 = "frmNom5";
    public static final String CHAMP_PRENOM_5 = "frmPrenom5";

    //Messages d'erreur
    public static final String ERREUR_SAISIE_VIDE = "Vous devez renseigner les deux champs";
    public static final String ERREUR_INFOS_CONN_KO = "Echec de la connexion! Verifiez votre login et/ou mot de passe et essayez à nouveau.";
    public static final String ERREUR_SUPPR = "La suppression a échoué !";
    public static final String SUCCES_SUPPR = "La suppression a réussi !";
    public static final String ERREUR_BDD_VIDE = "L'entreprise doit recruter !";

    //URL des pages jsp
    public static final String PAGE_INDEX = "WEB-INF/View/index.jsp";
    public static final String PAGE_TOUS_LES_EMPLOYES = "WEB-INF/View/tableauEmployes.jsp";
    public static final String PAGE_DETAIL_EMPLOYE = "WEB-INF/View/detailsEmploye.jsp";
    public static final String PAGE_CHOIX = "WEB-INF/View/choix.jsp";
    public static final String PAGE_AJOUTER_UN_EMPLOYE = "WEB-INF/View/ajouterUnEmploye.jsp";
    public static final String PAGE_AJOUTER_5_EMPLOYES = "WEB-INF/View/ajouter5Employes.jsp";
}
