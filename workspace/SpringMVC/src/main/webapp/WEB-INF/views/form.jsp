<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<style>
body {
	background: rgba(54, 112, 119, 0.11);
}

table {
	background-color: powderblue;
}

table, th, td {
	border: 0.5px solid gray;
}

th, td {
	padding: 10px;
	text-align: center;
}

table {
	border-spacing: 1px;
	width: 50%;
}

th {
	background: rgba(114, 130, 134, 0.3);
}

td {
	background: whitesmoke;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Input Form</title>
</head>
<body>
<table>
	<form:form action="result" modelAttribute="user" method="GET">
		<tr>
			<td>Name</td>
			<td><input type="text" name="name" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><select name="gender">
					<option value="male">Male</option>
					<option value="female">Female</option>
			</select></td>
		</tr>
		<tr>
			<td>
			</td>
			<td>
				<form:button value="Submit">Submit</form:button>
			</td>
		</tr>
	</form:form>
</table>
</body>
</html>