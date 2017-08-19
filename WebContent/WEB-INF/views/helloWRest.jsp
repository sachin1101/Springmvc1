<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Msg.jsp</title>
</head>
<body>
The message is:${msg}<br>
The userName is:${varname}
<c:choose>
 <c:when test="${userDataList != null }">
 <c:forEach items="${userDataList}" var="userData">
 <br>
 ${userData.getFirstname()}&nbsp;&nbsp;
 ${userData.getLastname()}&nbsp;&nbsp;
 ${userData.getEmail()}&nbsp;&nbsp;
 ${userData.getUserid()}&nbsp;&nbsp;
 
 
 </c:forEach>
 <br>
</c:when>
</c:choose>

<sql:query var="rs" dataSource="jdbc/myoracle">
select userid from amdd_user
</sql:query>
<c:forEach var="row" items="${rs.rows}">
     ${row.userid}<br/>
    
</c:forEach>
</body>
</html>