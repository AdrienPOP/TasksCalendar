<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css">
<title>TasksCalendar - Clients</title>
</head>
<body>
	<section id="baniere-princ" class="col-lg-10">
		<%@ include file="header.jsp"%>
		<div id="app" class="col-12">
			<table class="">
				<thead>
					<tr>
						<th colspan="5">Liste des clients</th>
					</tr>
				</thead>
				<tbody>
					<tr class="">
						<td>Nom</td>
						<td>Prénom</td>
						<td>Adresse</td>
						<td>Téléphone</td>
						<td>Mail</td>
					</tr>
					<tr class="">
						<td>${ u.name }</td>
						<td>${u.surname }</td>
						<td>${u.adress }</td>
						<td>${u.phone }</td>
						<td>${u.mail }</td>
					</tr>

				</tbody>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</section>
</body>
</html>