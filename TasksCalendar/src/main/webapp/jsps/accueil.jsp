<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.tasksCalendar.models.Task"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
	<title>TasksCalendar - Accueil</title>
</head>
<body>
<section id="baniere-princ" class="col-lg-10">
	<%@ include file ="header.jsp"%> 
	<section id="app" class="col-12">
		<section class="col-lg-7">
			<h1 class="col-12">Bonjour ${ name } !</h1>
			<h2 class="col-12">Vos tâches du jours :</h2>
		
			<c:forEach var="task" items="${dataTasks}">
				<article class="art col-10 col-lg-10 taskDay">
					<h2>${task.getTitle()}</h2>
					<p>${task.getDescription()}</p>
				</article>
			</c:forEach>
		</section>
		<section class="col-lg-5">
			<aside>
			
			</aside>
		</section>
		
		
	</section>
	
	<%@ include file ="footer.jsp"%>
</section>
</body>
</html>