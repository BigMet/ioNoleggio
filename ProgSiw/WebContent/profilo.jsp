<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
 <c:if test="${not loggato}">
    	<script>window.location = "index.jsp" </script> 
    </c:if>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profilo</title>

    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->


    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">


    
    <!-- <script src="js/custom.js"></script> -->
</head>

<body>
    <!-- Preloader -->
     <div id="preloader">
        <div class="dorne-load"></div>
    </div> 
    
    
<aside class="profile-card" >
	<header>
  
 <link href="css/profilo.css" rel="stylesheet" >
 <link href="css/block.css" rel="stylesheet" >
 
    <!-- here’s the avatar -->
    <a target="_blank" >
      <img src="img/Davide.jpg" class="hoverZoomLink">
    </a>

    <!-- the username -->
    <h1>
            ${nome}
           	
          </h1>

    <!-- and role or location -->
    <h2>
             ${email}
          </h2>

  </header>
  
  
  	 <div class="profile-bio" >

    <p>
      Un semplice ragazzo con evidenti problemi
    </p>

  </div>
  
  <!-- DA QUI FACCIO PROVE -->
  
 
<!-- <!--  <div style="float:left; display:block; width:150px; height:150px;">
  --> 
  
  <a href="prenotazioniCliente" class="btn-toolset">
  <strong>Le mie prenotazioni</strong>
   </a> 
  <!-- </div> -->
  
   <a href="#" class="btn-toolset">
  <strong>I miei noleggi</strong>
  </a>
  
  <a href="#" class="btn-toolset">
  <strong></strong>
  </a>
  
  
  
  </aside>
    

    <!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                        <a class="navbar-brand" href="index.jsp"><img src="img/core-img/logo.png" alt="ciao"></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation"><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item dropdown">
                                    <a class="nav-link" href="index.jsp">Home </a>
                                </li>
                                <li class="nav-item dropdown">
                                	 <a class="nav-link" href="chiSiamo.jsp">Chi siamo </a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="contatti.jsp">Contatti </a>
                                </li>
                                
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="flotta.jsp">La nostra flotta </a>
                                </li>
                            </ul>

   					<c:if test="${not loggato }">                         
                            <!-- Signin btn -->
                            <div class="dorne-signin-btn">
                                <a href="provaLogin.jsp">Accedi</a>
                            </div>
                            
                            </c:if>
                            
                      	<c:if test="${loggato }">    
                            <div class="dorne-signin-btn">
                                <a href="disconnectServlet">Disconnetti</a>
                            </div>
                            
                            <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Il mio profilo <i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    	<a class="dropdown-item" href="profilo.jsp">${nome}</a>
                                        <a class="dropdown-item" href="prenotazioni.jsp">Le tue prenotazioni</a>
                                        <a class="dropdown-item" href="noleggi.jsp">I tuoi noleggi</a>
                                    </div>
                                </li>
                            
                            </c:if>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    
    
    
    
    
    <!-- ***** Header Area End ***** -->
    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap-4 js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/others/plugins.js"></script>
    <!-- Active JS -->
    <script src="js/active.js"></script>

</body>

</html>


