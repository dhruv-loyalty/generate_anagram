<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Anagrams</title>
<style type="text/css">
span {
	display: inline-block;
	width: 200px;
	text-align: left;
}

label {
	display: inline-block;
	width: 200px;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select {
	width: 200px;
}

button {
	padding: 10px;
	margin: 10px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Get Anagram</h2>
		<form:form action="anagrams" method="post" modelAttribute="form">
			<form:label path="word">What's the word?</form:label>
			<form:input path="word" />
			<span class="error">${form.message}</span>
			</p>
			<br />
			<form:button>Submit</form:button>
			<br />
			<table>
				<tr>
					<th>Anagrams</th>
				</tr>
				<c:forEach items="${form.anagrams}" var="anagrams">
					<tr>
						<td>${anagrams}</td>
					</tr>
				</c:forEach>
			</table>
		</form:form>
	</div>
</body>
</html>