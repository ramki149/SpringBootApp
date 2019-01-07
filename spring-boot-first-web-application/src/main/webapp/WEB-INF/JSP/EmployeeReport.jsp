<html>
<head>
<title>Employee Report!!!!</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	Our Employees are
	<br> ${empList}
	<br>
	<br>
	<c:forEach items = "${empList}" var = "empObj">
	<br>
	Emp Name: ${empObj.empName} Employee ID: ${empObj.empId} Employee DOB: ${empObj.dob}
	</c:forEach>
	<br>
	<br>
	<a href="/employeeForm">Add Employee</a>
	<br>
	<br>
	<a href="/logout">LogOut</a>
</body>
</html>