<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<header class="col-12">
	<div id="header" class="col-12">
		<div id="logo" class="col-lg-1">
			<img src="" alt="image de logo">
		</div>
		<div id="hamburger" class="col-3">
			<a href="#">&#x2630;</a>
		</div>
		<section id="baniere" class=""></section>
		<div id="profil_mobile" class="col-3">
			<a href="#"><img src="img/logoAP.png" alt=""></a>
		</div>
		<div id="profil" class="col-3 col-sm-2 col-lg-1">
			<img src="img/logoAP.png" alt="logo admin" class="col-12"> <a
				href="#" class="col-12">Profil</a>
		</div>
	</div>
</header>
<nav class="col-lg-12">

	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ accueil.equals(uri) ? "nav_selection" : ""}' href="Accueil">Accueil</a></li>
	</ul>
	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ planning.equals(uri) ? "nav_selection" : ""}' href="Planning">Planning</a></li>
	</ul>
	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ client.equals(uri) ? "nav_selection" : ""}' href="Customer">Clients</a></li>
	</ul>
	<ul class="col-lg-2">
		<li class="col-lg-12"><a class=' ${ parametre.equals(uri) ? "nav_selection" : ""}' href="Parametre">Paramètres</a></li>
	</ul>	
</nav>
