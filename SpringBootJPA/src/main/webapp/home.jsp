<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addAlien">
	<label>ID</label>
	<input type="text" name="aid"><br>
	<label>Name</label>
	<input type="text" name="aname"><br>
	<label>Technology</label>
	<input type="text" name="tech"><br>
	<input type="submit"><br>
</form>	
<br>
<form action="getAlien">
	<label>Type ID</label>
	<input type="text" name="aid"><br>
	<input type="submit"><br>
</form>

<form action="updateAlien">
<label>Search by ID</label>
	<input type="text" name="aid"><br>
	<input type="submit"><br>
</form>>

<form action="deleteAlien">
<label>Delete by ID</label>
	<input type="text" name="aid"><br>
	<input type="submit"><br>
</form>>


</body>
</html>