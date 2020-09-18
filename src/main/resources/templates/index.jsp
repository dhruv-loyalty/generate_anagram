<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate Anagram</title>
<style>
.error {
	color: red;
}

.success {
	color: green;
}
</style>
</head>
<body>
	<form action="anagram" method="POST">
		<h1>Generate Anagram</h1>
		<p>
			<label for="word">What's your word?</label> <input id="word"
				name="word"> <span class="error">${messages.word}</span>
		</p>
		<p>
			<input type="submit"> <span class="success">${messages.success}</span>
		</p>
	</form>
	<table border="1">
		<tr>
			<th>Word</th>
			<th>Anagrams</th>
		</tr>
		<c:forEach items="${anagrams}" var="anagrams">
			<tr>
				<td>${word}</td>
				<td>${anagrams}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>