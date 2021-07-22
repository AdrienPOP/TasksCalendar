<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.tasksCalendar.calend.Week"%>
<%@ page import="com.tasksCalendar.calend.Month"%>
<%@ page import="com.tasksCalendar.calend.Day"%>
<%@ page import="com.tasksCalendar.models.Task"%>
<!DOCTYPE html>
<html lang="fr">
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
<title>TasksCalendar - Planning</title>
</head>
<body>
	<div id="baniere-princ" class="col-lg-11">
		<%@ include file="header.jsp"%>
		<div id="app" class="col-12">
			<div id="gest_vue" class="col-12 col-lg-4">
				<ul class="col-11">
					<li class="col-4"><a href="?view=day">Jour</a></li>
					<li class="col-4"><a href="?view=week">Semaine</a></li>
					<li class="col-4"><a href="?view=month">Mois</a></li>
				</ul>
			</div>
			<div
				class='col-12 ${ viewUser.equals("month") ? " hidden" : "" }'>
				<ul id="gest_task" class="col-lg-2">
					<li><a href="?action=createTask">Créer une nouvelle tâche</a></li>
				</ul>
			</div>
			<div
				class='col-12 calend ${ viewUser.equals("week") ? "" : " hidden" }'>
				<!-- Planning  vue semaine-->
				<div class="col-lg-8 week">
					<c:forEach var="day" items="${days}">
						<article class="art col-10">
							<div class="art_title">
								<h2>${day.name}</h2>
								<h3><fmt:parseDate value="${day.date}" pattern="yyyy-MM-dd"
										var="parsedDate" type="date" />
									<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}" />
								</h3>
							</div>
							<c:forEach var="task" items="${day.tasksDay }">
								<div class="taskDay col-11">
									<h4>${task.title }</h4>
									<p class="tooltip">${task.description }</p>
								</div>
							</c:forEach>
						</article>
					</c:forEach>
					<div class="col-12">
						<div class="col-11 btn_gest_vue">
							<div class="col-4">
								<a class="col-2" href="?dateUser=${ week.getPrevious() }">&lt;</a>
								<a class="col-2" href="?dateUser=${ week.getNext() }">&gt; </a>
							</div>
						</div>
					</div>
				</div>
				<aside id="d" class="">
					<h2 class="${!createTask ? '' : 'art_title'}">${!createTask ? '' : 'Nouvelle tâche'}</h2>
					<div class="col-12">
						<form action="Planning" id="select"
							class="col-lg-10 ${!createTask ? 'hidden' : ''} " method="POST">
							<div>
								<label for="name_task">Nom de la tâche</label> <input
									type="text" id="name_task" name="name_task" class="col-lg-12">
							</div>
							<div>
								<label for="date_task">Date</label> <input type="date"
									id="date_task" name="date_task" class="col-lg-12"
									value="${ date }">
							</div>
							<div>
								<label for="time_task">Heure</label> <input type="time"
									id="time_task" name="time_task" class="col-lg-12"
									value="${ date }">
							</div>
							<div>
								<label for="customer_task">Client</label> 
								<input
									type="search" id="customer_task" name="customer_task" class="col-lg-12">
							</div>
							<div>
								<label for="description_task">Description</label>
								<textarea name="description_task" id="description_task"
									maxlength="255" class="col-lg-12"></textarea>
							</div>
							<div id="btn" class="col-lg-10">
								<button type="submit" class="col-lg-12">Créer la tâche</button>
								<button class="col-lg-12">
									<a href="Planning">Annuler</a>
								</button>
							</div>
						</form>
					</div>
				</aside>
			</div>
			<div
				class='col-12 calend ${ viewUser.equals("month") ? "" : " hidden" }'>
				<div class="col-12">
					<div id="gest_vue_month" class="col-12 btn_gest_vue">
						<div class="col-6">
							<a class="col-2" href="?dateUser=${ month.getPrevious() }">&lt;</a>
							<a class="col-2" href="?dateUser=${ month.getNext() }">&gt; </a>
						</div>
					</div>
				</div>
				<c:forEach var="w" items="${weeks}">
					<c:forEach var="day" items="${w.daysOfWeek}" varStatus="theCount">
						<article
							class='art_week ${w.getFirstDay().plusDays((theCount.count) - 1).getMonthValue() != month.getNumber() ? "dayDisable" : "" }'>
							<h2>${day.name}</h2>
							<h3>
								<fmt:parseDate value="${day.date}" pattern="yyyy-MM-dd"
									var="parsedDate" type="date" />
								<fmt:formatDate pattern="dd/MM/yyyy" value="${parsedDate}" />
							</h3>
						</article>
					</c:forEach>
				</c:forEach>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
	<script src="js/script.js"></script>
	<p></p>
</body>
</html>