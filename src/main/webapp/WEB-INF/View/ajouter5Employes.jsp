<%-- 
    Document   : ajouter5Employes
    Created on : 19 juin 2018, 15:38:38
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
    <body>

        <div class="row">
            <div class="col-md-4 col-md-offset-2">
                <form class="form-horizontal" action="Controleur" >
                    <fieldset>
                        <legend>Membre n°1 à ajouter</legend>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom1" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom1"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmEmail1" class="form-control" maxlength="25">
                            </div>
                        </div>
                        <legend>Membre n°2 à ajouter</legend>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom2" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom2"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmEmail2" class="form-control" maxlength="25">
                            </div>
                        </div>
                        <legend>Membre n°3 à ajouter</legend>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom3" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom3"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmEmail3" class="form-control" maxlength="25">
                            </div>
                        </div>
                        <legend>Membre n°4 à ajouter</legend>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom4" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom4"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmEmail4" class="form-control" maxlength="25">
                            </div>
                        </div>
                        <legend>Membre n°5 à ajouter</legend>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Nom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmNom5" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Prénom</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmPrenom5"  class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="textinput">Adresse e-mail</label>
                            <div class="col-sm-10">
                                <input type="text" name="frmEmail5" class="form-control" maxlength="25">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="pull-right">
                                    <button type="submit" id="a" name="action" value="Ajouter5" class="btn btn-primary">Ajouter</button>
                                    <button type="submit" name="action" value="VoirListe" class="btn btn-default" >Voir liste</button>
                                </div>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
    </body>
    
    <script type="text/javascript">
        var btn = document.getElementById('a');

        btn.addEventListener('click', disableBtn);

        function disableBtn() {
            window.setTimeout(function () { btn.disabled = true;}, 0);
        }</script>
</html>
