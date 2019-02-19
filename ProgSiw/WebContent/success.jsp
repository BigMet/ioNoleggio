<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> tutto ok !!</h1>
<%
String user = null;
	if(session.getAttribute("user")==null)
			response.sendRedirect("provaLogin.jsp");
	else
		user = (String) session.getAttribute("user");
%>

<h3>Ciao, ${user} </h3>
</body>
</html>