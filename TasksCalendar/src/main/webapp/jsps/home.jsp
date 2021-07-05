<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="css/stylelog.css">

    <title>TasksCalendar - Identification</title>
</head>
<body>
    <section id=logo class="col-10 col-sm-6 col-lg-3" ${!create ? "" : "hidden"}>
        <img src="img/logoAP.png" alt="logo">
    </section>
    <section id="${!create ?  'connexion' : 'inscription'}" class="col-10 col-sm-6 col-md- col-lg-3">
        <form action="${!create ?  'Connexion' : 'Inscription'}" method="POST" class="col-8">
            <div class="col-12">
                <label for="login">Identifiant</label>
                <input type="text" name="login" id="login" required>
            </div>
            <div class="col-12">
                <label for="password">Mot de passe</label>
                <input type="password" name="password" id="password" required>
            </div>
             <div class="col-12" ${!create ? " hidden " : ""}>
	             <label for="name">Nom</label>
	             <input type="text" name="name" id="name" ${!create ? "disabled" : "required"}>
	        </div>
	        <div class="col-12" ${!create ? " hidden " : ""}>
	            <label for="firstname">Prénom</label>
	            <input type="text" name="firstname" id="firstname" ${!create ? "disabled" : "required"}>
	        </div>
	        <div class="col-12" ${!create ? " hidden " : ""}>
	            <label for="adress">Adresse</label>
	            <input type="text" name="adress" id="adress" ${!create ? "disabled" : "required"}>
	            </div>
	        <div class="col-12" ${!create ? " hidden " : ""}>
	            <label for="phone">Téléphone</label>
	            <input type="tel" name="phone" id="phone" ${!create ? "disabled" : "required"}>
	        </div>
	         <div class="col-12" ${!create ? " hidden " : ""}>
	            <label for="mail">Email</label>
	            <input type="tel" name="mail" id="mail" ${!create ? "disabled" : "required"}>
	        </div>
	        <div id="btn_submit" class="col-12">
	        	<button class="col-6" type="submit">${!create ? "Se connecter" : "Créer un compte"}</button>
	        </div>
        </form>
        <div class="col-8 mdp">
            <a id= "newAccount" href="${!create ? '?action=createAccount' : '?action=signUp'}" class="col-6">${!create ? " Créer un compte " : " Se connecter"}</a>
            <a href="#" class="col-6">Mot de passe oublié</a>
        </div>
    </section>
    <footer>
        <p>&copy;APcopyrigth 2021</p>
    </footer>
</body>
</html>