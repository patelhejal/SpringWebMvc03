<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Report App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div>
		<h3>Report Application </h3>
	</div>
	
	<form:form action="" modelAttribute="search" method="POST">
		<table>
			<tr>
				<td>Plan Name :</td>
				<td>
					<form:select path="planName">
						<form:option value="">-Select-</form:option>
							<form:options items="${names}"/>
					</form:select>
				</td>
				<td>Plan Status :</td>
				<td>
					<form:select path="planStatus">
						<form:option value="">-Select-</form:option>
						<form:options items="${status}"/>
					</form:select>
				</td>
				<td>Gender :</td>
				<td>
					<form:select path="gender">
						<form:option value="">-Select-</form:option>
						<form:option value="Male">Male</form:option>
						<form:option value="Female">Female</form:option>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><form:input type= "date" path="startDate"/></td>
				<td>End Date :</td>
				<td><form:input type="date" path="endDate"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" class="btn btn-primary"/></td>
			</tr>
		</table>
	</form:form>
	<hr/>
	<table class="table table-stripped table-hover">
		<thead>
			<tr>
				<th>ID</th>
				<th>Holder Name</th>
				<th>Plan Name</th>
				<th>Plan Status</th>
				<th>Start Date</th>
				<th>End Date</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="plan :${plans}"></tr>
		
		</tbody>
	</table>
	<hr/>
	Export : <a href="" >Excel</a>
	Export : <a href="" >PDF</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>