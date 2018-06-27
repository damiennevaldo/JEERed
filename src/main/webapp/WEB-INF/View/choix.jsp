<%-- 
    Document   : choix
    Created on : 19 juin 2018, 14:13:52
    Author     : Groupe Rouge
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
    <title>JSP Page</title>
</head>
<body> 
    <form action="Controleur" method="post">
        Bonjour ${identifiants.login} ! <br /><br />
        Choisissez votre action : <br /><br />

        <button type="submit" name="action" value="VoirListe" class="btn btn-primary">Voir la liste des employés</button>
        <button type="submit" name="action" value="VoirAjouter" class="btn btn-primary">Ajouter un employé</button>
    </form>
</body>
</html>
