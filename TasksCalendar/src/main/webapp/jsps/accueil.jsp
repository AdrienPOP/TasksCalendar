<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.tasksCalendar.models.Task"%>
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
<title>TasksCalendar - Accueil</title>
</head>
<body>
	<div id="baniere-princ" class="col-lg-10">
		<%@ include file="header.jsp"%>
		<div id="app" class="col-12">
			<section id="tasksDay" class="col-12 col-lg-4">
				<h1 class="col-12">Bonjour ${ name } !</h1>
				<article class="art col-10 col-lg-10">
					<div class="art_title">
						<h2>${day.getName()}</h2>
						<h3>
							<fmt:parseDate value="${day.getDate()}" pattern="yyyy-MM-dd"
								var="parsedDate" type="date" />
							<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}" />
						</h3>
					</div>
						<c:forEach var="task" items="${day.getTasksDay()}">
							<div class="taskDay col-11">
								<h4>${task.getTitle()}</h4>
								<p>${task.getDescription()}</p>
							</div>
						</c:forEach>
				</article>
			</section>
			<div class="col-12 col-lg-7">
				<aside id="postIt">
				
				</aside>
			</div>


		</div>
		
		
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>