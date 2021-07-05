<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="col-12">
	<section id="header" class="col-12">
		<section id="logo" class="col-lg-1">
			<img src="" alt="image de logo">
		</section>
		<section id="hamburger" class="col-3">
			<a href="#">&#x2630;</a>
		</section>
		<section id="baniere" class=""></section>
		<section id="profil_mobile" class="col-3">
			<a href="#"><img src="img/logoAP.png" alt=""></a>
		</section>
		<section id="profil" class="col-3 col-sm-2 col-lg-1">
			<img src="img/logoAP.png" alt="logo admin" class="col-12"> <a
				href="#" class="col-12">Profil</a>
		</section>
	</section>
</header>
<nav class="col-lg-12">

	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ accueil.equals(uri) ? "nav_selection" : ""}' href="Accueil">Accueil</a></li>
	</ul>
	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ planning.equals(uri) ? "nav_selection" : ""}' href="Planning">Planning</a></li>
	</ul>
	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ parametre.equals(uri) ? "nav_selection" : ""}' href="Parametre">Paramètres</a></li>
	</ul>
		
		
</nav>
<script src="js/appHeader.js"></script>
