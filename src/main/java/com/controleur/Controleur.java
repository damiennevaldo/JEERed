package com.controleur;

import com.employes.utils.EmployesConstantes;
import com.model.Employes;
import com.model.Identifiants;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Groupe Rouge
 */
public class Controleur extends HttpServlet {

    @EJB
    private ConnexionPersistence connexionPersistence;

    ArrayList<Employes> listeEmployes = new ArrayList<>();
    ArrayList<Identifiants> listeIdentifiants = new ArrayList<>();
    Employes employe = new Employes();
    Identifiants identifiants = new Identifiants();
    String idEmploye = EmployesConstantes.FRM_ID_EMPL_SELECT;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String loginForm = request.getParameter(EmployesConstantes.FRM_LOGIN);
        String mdpForm = request.getParameter(EmployesConstantes.FRM_MDP);
        String action = request.getParameter(EmployesConstantes.ACTION);

        if (action == null) {
            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);

        } else if (action != null) {

            switch (action) {

                case EmployesConstantes.ACTION_LOGIN:
                    //Si le nom d'utilisateur et le mot de passe sont vide, renvoyer vers l'index avec un message d'erreur.
                    if (loginForm != null && mdpForm != null) {

                        if (loginForm.isEmpty() || mdpForm.isEmpty()) {
                            request.setAttribute("cleMessageErreur", EmployesConstantes.ERREUR_SAISIE_VIDE);
                            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);
                        } else {
                            listeIdentifiants.addAll(connexionPersistence.getIdentifiants());

                            for (Identifiants i : listeIdentifiants) {

                                if (i.getLogin().equals(loginForm) && i.getMdp().equals(mdpForm)) {
                                    identifiants.setLogin(request.getParameter(EmployesConstantes.FRM_LOGIN));
                                    session.setAttribute("identifiants", identifiants);
                                    request.getRequestDispatcher(EmployesConstantes.PAGE_CHOIX).forward(request, response);

                                }
                            }

                            request.setAttribute("cleMessageErreur", EmployesConstantes.ERREUR_INFOS_CONN_KO);
                            request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);
                        }
                    }
                    break;

                case EmployesConstantes.ACTION_VOIR_AJOUTER:
                    request.getRequestDispatcher(EmployesConstantes.PAGE_AJOUTER_UN_EMPLOYE).forward(request, response);
                    break;

//                case EmployesConstantes.ACTION_AJOUTER:
//                    employe = creerEmploye(request);
//                    connexionPersistence.ajouterEmployes(employe);
//                    listeEmployes.clear();
//                    listeEmployes.addAll(connexionPersistence.getEmployes());
//                    request.setAttribute("cleListeEmployes", listeEmployes);
//                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
//                    break;
                    
                case EmployesConstantes.ACTION_AJOUTER:
                    employe = new Employes(
                            request.getParameter(EmployesConstantes.CHAMP_NOM),
                            request.getParameter(EmployesConstantes.CHAMP_PRENOM),
                            request.getParameter(EmployesConstantes.CHAMP_TELDOMICILE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPORTABLE),
                            request.getParameter(EmployesConstantes.CHAMP_TELPRO),
                            request.getParameter(EmployesConstantes.CHAMP_ADRESSE),
                            request.getParameter(EmployesConstantes.CHAMP_CODEPOSTAL),
                            request.getParameter(EmployesConstantes.CHAMP_VILLE),
                            request.getParameter(EmployesConstantes.CHAMP_EMAIL));
                    connexionPersistence.ajouterEmployes(employe);
                    listeEmployes.clear();
                    listeEmployes.addAll(connexionPersistence.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;
                    
                case EmployesConstantes.ACTION_SUPPRIMER:
                    if (request.getParameter(idEmploye) != null) {
                        int i = 0;
                        int idClientASupprimer = Integer.parseInt(request.getParameter(idEmploye));
                        i = connexionPersistence.supprimerEmployes(idClientASupprimer);
                        if (i == 0) {
                            request.setAttribute("cleMessageSuppr", EmployesConstantes.ERREUR_SUPPR);
                            request.setAttribute("cleCouleur", "red");
                        } else if (i > 0) {
                            request.setAttribute("cleMessageSuppr", EmployesConstantes.SUCCES_SUPPR);
                            request.setAttribute("cleCouleur", "green");

                        }
                        listeEmployes.clear();

                        listeEmployes.addAll(connexionPersistence.getEmployes());
                        request.setAttribute("cleListeEmployes", listeEmployes);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    }
                    break;

                case EmployesConstantes.ACTION_AJOUTER_5:
                    employe = new Employes();
                    employe.setNom(request.getParameter("frmNom1"));
                    employe.setPrenom(request.getParameter("frmPrenom1"));
                    employe.setEmail(request.getParameter("frmEmail1"));
                    if (!request.getParameter("frmNom1").equals("") || !request.getParameter("frmPrenom1").equals("")) {
                        connexionPersistence.ajouter5Employes(employe);
                    }

                    employe = new Employes();
                    employe.setNom(request.getParameter("frmNom2"));
                    employe.setPrenom(request.getParameter("frmPrenom2"));
                    employe.setEmail(request.getParameter("frmEmail2"));
                    if (!request.getParameter("frmNom2").equals("") || !request.getParameter("frmPrenom2").equals("")) {
                        connexionPersistence.ajouter5Employes(employe);
                    }
                    employe = new Employes();
                    employe.setNom(request.getParameter("frmNom3"));
                    employe.setPrenom(request.getParameter("frmPrenom3"));
                    employe.setEmail(request.getParameter("frmEmail3"));
                    if (!request.getParameter("frmNom3").equals("") || !request.getParameter("frmPrenom3").equals("")) {
                        connexionPersistence.ajouter5Employes(employe);
                    }

                    employe = new Employes();
                    employe.setNom(request.getParameter("frmNom4"));
                    employe.setPrenom(request.getParameter("frmPrenom4"));
                    employe.setEmail(request.getParameter("frmEmail4"));
                    if (!request.getParameter("frmNom4").equals("") || !request.getParameter("frmPrenom4").equals("")) {
                        connexionPersistence.ajouter5Employes(employe);
                    }
                    employe = new Employes();
                    employe.setNom(request.getParameter("frmNom5"));
                    employe.setPrenom(request.getParameter("frmPrenom5"));
                    employe.setEmail(request.getParameter("frmEmail5"));
                    if (!request.getParameter("frmNom5").equals("") || !request.getParameter("frmPrenom5").equals("")) {
                        connexionPersistence.ajouter5Employes(employe);
                    }

                    listeEmployes.clear();
                    listeEmployes.addAll(connexionPersistence.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_MODIFIER:

                    employe = creerEmploye(request);

                    connexionPersistence.modifierEmployes(employe);

                    listeEmployes.clear();
                    listeEmployes.addAll(connexionPersistence.getEmployes());
                    System.out.println(listeEmployes.get(0).getId());
                    System.out.println(listeEmployes.get(0).getAdresse());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_DETAILS:
                    if (request.getParameter(idEmploye) != null) {
                        int idEmployeSelect = Integer.parseInt(request.getParameter(idEmploye));
                        listeEmployes.clear();
                        listeEmployes.addAll(connexionPersistence.getEmployesId(idEmployeSelect));
                        employe = listeEmployes.get(0);
                        session.setAttribute("employe", employe);
                        request.getRequestDispatcher(EmployesConstantes.PAGE_DETAIL_EMPLOYE).forward(request, response);

                    }
                    break;

                case EmployesConstantes.ACTION_VOIR_AJOUTER_5:
                    request.getRequestDispatcher(EmployesConstantes.PAGE_AJOUTER_5_EMPLOYES).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_VOIR_LISTE:
                    listeEmployes.clear();
                    listeEmployes.addAll(connexionPersistence.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;

                case EmployesConstantes.ACTION_ANNULER:
                    listeEmployes.clear();
                    listeEmployes.addAll(connexionPersistence.getEmployes());
                    request.setAttribute("cleListeEmployes", listeEmployes);
                    request.getRequestDispatcher(EmployesConstantes.PAGE_TOUS_LES_EMPLOYES).forward(request, response);
                    break;
            }

        }

    }

    //REGROUPE DU CODE REPETE : PRENDS LA REQUETE CONTENANT LES INFOS D'UN FORMULAIRE ET CREE UN OBJET EMPLOYES 
    private Employes creerEmploye(HttpServletRequest request) {
        employe.setAdresse(request.getParameter(EmployesConstantes.CHAMP_ADRESSE));
        employe.setCodepostal(request.getParameter(EmployesConstantes.CHAMP_CODEPOSTAL));
        employe.setEmail(request.getParameter(EmployesConstantes.CHAMP_EMAIL));
        employe.setNom(request.getParameter(EmployesConstantes.CHAMP_NOM));
        employe.setPrenom(request.getParameter(EmployesConstantes.CHAMP_PRENOM));
        employe.setTeldom(request.getParameter(EmployesConstantes.CHAMP_TELDOMICILE));
        employe.setTelport(request.getParameter(EmployesConstantes.CHAMP_TELPORTABLE));
        employe.setTelpro(request.getParameter(EmployesConstantes.CHAMP_TELPRO));
        employe.setVille(request.getParameter(EmployesConstantes.CHAMP_VILLE));
        return employe;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
