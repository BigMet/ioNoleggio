<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prenotazioni</title>
</head>
<body>
 <link href="css/block.css" rel="stylesheet" >
		<c:forEach items="${prenotazioni}" var="p">
		<a  class="btn-toolset">
  			<strong>
						Numero prenotazione: ${p.idPrenotazione} Prezzo: ${p.prezzo}
			</strong>
		</a>
		<br>
		</c:forEach>
		<script type="text/javascript">

var data = new Date();
var dd, mm, aaaa;
dd = data.getDate() + ":";
mm = data.getMonth()+1 + ":";
aaaa = data.getFullYear() + ":";
document.write("Sono le ore " + dd + mm + aaaa);

</script>
</body>
</html>