<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

 <!-- PER NON METTERE NEL "URL" LA PAGINA DI ADMIN SENZA POTERLO FARE -->
    <c:if test="${not admin}">
    	<script>window.location = "index.jsp" </script> 
    </c:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IndexAdmin</title>

    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>M&D - ioNoleggio</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">

    <!-- Responsive CSS -->
    <link href="css/responsive/responsive.css" rel="stylesheet">
    

</head>

<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="dorne-load"></div>
    </div>

    <!-- ***** Search Form Area ***** -->
    <div class="dorne-search-form d-flex align-items-center">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-close-btn" id="closeBtn">
                        <i class="pe-7s-close-circle" aria-hidden="true"></i>
                    </div>
                    <form action="#" method="get">
                        <input type="search" name="caviarSearch" id="search" placeholder="Search Your Desire Destinations or Events">
                        <input type="submit" class="d-none" value="submit">
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                        <a class="navbar-brand" href="indexAdmin.jsp"><img src="img/core-img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation"><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item active">
                                    <a class="nav-link" href="indexAdmin.jsp">Home <span class="sr-only">(current)</span></a>
                                </li>
                            </ul>
                           
 					
                            
                      	<c:if test="${loggato }">    
                            <div class="dorne-signin-btn">
                                <a href="disconnectServlet">Disconnetti</a>
                            </div>
                            
                            <div class="dorne-signin-btn">
                                <a href="prenotazioniServlet">Prenotazioni</a>
                            </div>
                            
                            </c:if>
 
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Welcome Area Start ***** -->
    <section class="dorne-welcome-area bg-img bg-overlay" style="background-image: url(img/bg-img/home-bg.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center justify-content-center">
                <div class="col-12 col-md-10">
                    <div class="hero-content">
                        <h3> Scegli dal menu' sottostante l'azione di gestione </h3>
                        
                    </div>
                    <!-- Hero Search Form -->
                    <div class="hero-search-form">
                    
                        <!-- Tabs -->
                        <div class="nav nav-tabs" id="heroTab" role="tablist">
                            <a class="nav-item nav-link active" id="nav-places-tab" data-toggle="tab" href="#nav-places" role="tab" aria-controls="nav-places" aria-selected="true">Conferma</a>
                            <a class="nav-item nav-link" id="nav-events-tab" data-toggle="tab" href="#nav-events" role="tab" aria-controls="nav-events" aria-selected="false">Walk-in</a>
                            <a class="nav-item nav-link" id="nav-rientro-tab" data-toggle="tab" href="#nav-rientro" role="tab" aria-controls="nav-events" aria-selected="false">Rientro</a>
                        </div>
                        <!-- Tabs Content -->
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="nav-places" role="tabpanel" aria-labelledby="nav-places-tab" >
                                <h6>Finalizza una prenotazione</h6>
		                        <div style="display: flex">
		                        <input type="text" name="idP" id="idPrenotazione" placeholder="Id prenotazione" >
		             			<input type="text" name="nP" id="numPatente" placeholder="N Patente" >
		             			<input type="text" name="nC" id="numCarta" placeholder="N carta">
                                    <button onclick="creaNoleggio()" class="btn dorne-btn"> Conferma</button>
                            	</div>
                            </div>
                            
                            <!-- RIMANDO ALLA SERVLET  CHE DOVREBBE RIMANDARMI AL CATALOGO DOVE POI CI SARA' IL NUM DELLE AUTO DISPONIBILI SU OGNI CATEGORIA-->
                            <div class="tab-pane fade" id="nav-events" role="tabpanel" aria-labelledby="nav-events-tab">
                                <h6>Aggiungi una prenotazione</h6>
                                <form action="${pageContext.request.contextPath}/walkIn" method="GET">

			             			
			             			<input type="date" id="start" name="walkin-start"
										       value="2019-03-01"
										       min="2019-03-01" max="2019-12-31">
										       
										<!-- DATA FINE -->
	                                 <input type="date" id="end" name="walkin-end"
										       value="2019-03-02"
										       min="2019-03-02" max="2019-12-31">
	                                    <button type="submit" class="btn dorne-btn"> Conferma</button>
                                </form>
                            </div>
                            
                            <!-- RIMANDO ALLA PAGINA IN CUI SELEZIONI TUTTI I DANNI CHE L'AUTO HA AVUTO O NO -->
                           <div class="tab-pane fade" id="nav-rientro" role="tabpanel" aria-labelledby="nav-events-tab">
                                <h6>Termina un noleggio</h6>
                               <form action="${pageContext.request.contextPath}/terminaNoleggio" method="GET">
                             <!--    <input type="text" name="nomeUtente" id="idPrenotazione" placeholder="Nome">
		                        <input type="text" name="cognomeUtente" id="idPrenotazione" placeholder="Cognome"> -->
		                        <input type="date" id="endRent" name="rent-end"
										       value="2019-03-01"
										       min="2019-03-01" max="2019-12-31">
		                        
		             			<input type="text" name="nP" id="numPatente" placeholder="N Patente">
		             			<input type="text" name="nC" id="numCarta" placeholder="N noleggio">
                                    <button type="submit" class="btn dorne-btn"> Conferma</button>
                                </form>
                            </div> 
                            
                            
                          </div>
                          
                          
                        </div>
                    </div>
                </div>
            </div>
       
        
           

   

    

   

    <!-- ***** Clients Area Start ***** -->
    <div class="dorne-clients-area section-padding-100">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <div class="clients-logo d-md-flex align-items-center justify-content-around">
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Clients Area End ***** -->

    <!-- ****** Footer Area Start ****** -->
    <footer class="dorne-footer-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 d-md-flex align-items-center justify-content-between">
                    <div class="footer-text">
                        <p>
                        
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
	Copyright &copy;<script>document.write(new Date().getFullYear());</script> A cura di Matteo e Davide | Un semplice sito di noleggio by M&D
	<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </p>
                    </div>
                    
                </div>
            </div>
        </div>
    </footer>
    <!-- ****** Footer Area End ****** -->

    <!-- jQuery-2.2.4 js -->
    <script src="js/jquery/jquery-2.2.4.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <!-- Popper js -->
    <script src="js/bootstrap/popper.min.js"></script>
    <!-- Bootstrap-4 js -->
    <script src="js/bootstrap/bootstrap.min.js"></script>
    <!-- All Plugins js -->
    <script src="js/others/plugins.js"></script>
    <!-- Active JS -->
    <script src="js/active.js"></script>
    <script src="js/custom.js"></script>
    
    
</body>

</html>