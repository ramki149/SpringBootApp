<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="bootstrap-datepicker.js"></script>

<head>
<title>Employee Info Request</title>
</head>

<body>
	<form:form method="post" modelAttribute="employee">
		Employee Name: <form:input value="" type="text" path="empName"
			required="required" class="form-control"></form:input>
		<br>
		<form:errors path="empName" cssClass="text-warning"></form:errors>
		Employee ID:   <form:input value="" type="text" path="empId"
			required="required" class="form-control"></form:input>
		<br>
		Employe DOB:   <form:input value="" type="text" path="dob"></form:input>
		<form:button type="submit" value="Submit"></form:button>
		
		<script>
			$('#dob').datepicker({
				format : 'dd/MM/yyyy'
			});
		</script>
	</form:form>
</body>

</html>