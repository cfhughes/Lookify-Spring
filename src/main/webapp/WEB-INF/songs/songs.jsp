<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
<title>Lookify App</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/songs/new">Add New</a> | <a href="/songs/topTen">Top Ten</a></h3>
			<form action="/songs/search" class="float-right">
				<input type="text" name="artist"/>
				<button class="btn btn-primary">Search Artists</button>
			</form>
		</nav>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ songs }" var="song">
				<tr>
					<td><a href="/songs/${ song[0].id }">${ song[0].name }</a></td>
					<td>${ song[1].name }</td>
					<td>${ song[0].rating }</td>
					<td><a class="btn btn-danger" href="/delete/${ song[0].id }">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>