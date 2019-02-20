<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <link href="css/block.css" rel="stylesheet" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prenotazioni</title>
</head>
<body>
		<c:forEach items="${prenotazioni}" var="p">
		  <a class="btn-toolset">
  					<strong> 
						ID prenotazione: ${p.idPrenotazione} Prezzo: ${p.prezzo}Euro Effettuata in data: ${p.dataPrenotazione.getDate()}/${p.dataPrenotazione.getMonth()+1}/${p.dataPrenotazione.getYear()+1900}
					</strong>
   			</a>
   				<br>
					</c:forEach>
</body>
</html>