<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<style>
background-color: #dae1e7;
</style>
</head>
<body>
	<form:form id="regForm" modelAttribute="user" action="save"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" name="username" id="username" cssStyle="error"/>
				<td><form:errors path="username" cssStyle="error"/></td>
				</td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" name="password"
						id="password" cssStyle="error"/></td>
						<td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><form:label path="firstname">FirstName</form:label></td>
				<td><form:input path="firstname" name="firstname" id="firstname" cssStyle="error" /></td>
				<td><form:errors path="firstname" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">LastName</form:label></td>
				<td><form:input path="lastname" name="lastname" id="lastname" cssStyle="error" />
				</td>
				<td><form:errors path="lastname" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" name="email" id="email"  cssStyle="error"/></td>
				<td><form:errors path="email" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><form:label path="address">Address</form:label></td>
				<td><form:input path="address" name="address" id="address" cssStyle="error" />
				</td>
				<td><form:errors path="address" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><form:label path="phoneno">Phone</form:label></td>
				<td><form:input path="phoneno" name="phoneno" id="phoneno"  cssStyle="error"/></td>
				<td><form:errors path="phoneno" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="register" name="register">Register</form:button>
				</td>
				
			</tr>
			<tr></tr>
			<tr>
				<td></td>
				<td><a href="/">Home</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>