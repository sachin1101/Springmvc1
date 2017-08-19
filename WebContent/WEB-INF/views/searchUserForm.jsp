<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<form id="searchUserForm" action="${pageContext.request.contextPath}/getUserDetails"  method="post" >
		<p>Input User ID: <input type="text" name="userid" /></p>
        <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
	</form>
</body>
</html>