<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateAlien">
	
	<label>ID</label>
	<input type="text" name="aid"><br>
	<label>Name</label>
	<input type="text" name="aname"><br>
	<label>Tech</label>
	<input type="text" name="tech"><br>
	<input type="submit"><br>
	${alien}
</form>	
</body>
</html>