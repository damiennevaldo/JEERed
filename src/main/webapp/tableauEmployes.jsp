<%-- 
    Document   : tableauEmployes
    Created on : 3 nov. 2016, 11:13:04
    Author     : Jacques Augustin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
    <body>

        <div class="container" >
            <div class="row col-md-6 col-md-offset-0 custyle">

                <form method="post" action="Controleur" name="suppression">
                    <table class="table table-striped custab">
                        
                        <!--permet de faire disparaitre entrée du tableau s'il n'y a plus d'employé-->
                        <c:if test="${!empty cleListeEmployes}">
                            <thead>
                            <h1>Liste des employés</h1>
                            <tr class="text-center">
                                <th>Sél</th>
                                <th>NOM</th>
                                <th>PRENOM</th>
                                <th>TEL DOMICILE</th>
                                <th>TEL PORTABLE</th>
                                <th>TEL PRO</th>
                                <th>ADRESSE</th>
                                <th>CODE POSTAL</th>
                                <th>VILLE</th>
                                <th>EMAIL</th>
                            </tr>
                            </thead>

                            </tr>
                        </c:if>
                            
                            
                        <c:forEach items="${cleListeEmployes}" var="employe">
                            <tr>
                                <td><input type="radio" name="idEmploye" value="${employe.id}" CHECKED></td>
                                <td>${employe.nom}</td>
                                <td>${employe.prenom}</td>
                                <td>${employe.teldom}</td>
                                <td>${employe.telport}</td>
                                <td>${employe.telpro}</td>
                                <td>${employe.adresse}</td>
                                <td>${employe.codepostal}</td>
                                <td>${employe.ville}</td>
                                <td>${employe.email}</td>

                            </tr>                         

                        </c:forEach>



                    </table>



                    <input type="submit" name="action" value="Details" class="btn btn-primary"/>

                    <!--bouton supprimer avec message conditionnel--> 
                    <input type="submit" name="action" value="Supprimer" class="btn btn-primary"/>
                    </br><p><font color="${cleCouleur}"> ${cleMessageSuppr} </font></p>


                    <!--bouton conditionnel supprimer-->
                    <c:if test="${empty cleListeEmployes}">
                        <input type="submit" value="créer 5 employes" name="bouton" class="btn btn-primary">
                        <h2><font color="red"> /!\ L'entreprise a besoin de recruter /!\</font></h2>
                        </c:if>




                </form>
            </div>
        </div>         
    </body>
</html>
