<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Save Cutomer</title>
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-stylestyle.css">
</head>

<body>

	<div id="wrapper">
		
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="cutomer" method="POST">
			
			<form:hidden path="id" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/></td>
						
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/></td>
						
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
						
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer">Back to List</a>
		</p>
	</div>


</body>
</html>