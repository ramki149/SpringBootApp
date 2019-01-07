<html>
<head>
<title>Employee Report!!!!</title>
</head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
	Employee Details:
	<br>
	<br>
	<br>
	Emp Name: ${empObj.empName} Employee ID: ${empObj.empId} Employee DOB: ${empObj.dob}
	<br>
	<br>
	<br>
	<a href="/logout">LogOut</a>
</body>
</html>