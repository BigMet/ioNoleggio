<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chi Siamo</title>
	<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


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


     <!-- ***** Header Area Start ***** -->
    <header class="header_area" id="header">
        <div class="container-fluid h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
                    <nav class="h-100 navbar navbar-expand-lg">
                        <a class="navbar-brand" href="index.jsp"><img src="img/core-img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#dorneNav" aria-controls="dorneNav" aria-expanded="false" aria-label="Toggle navigation"><span class="fa fa-bars"></span></button>
                        <!-- Nav -->
                        <div class="collapse navbar-collapse" id="dorneNav">
                            <ul class="navbar-nav mr-auto" id="dorneMenu">
                                <li class="nav-item dropdown">
                                    <a class="nav-link" href="index.jsp">Home </a>
                                </li>
                                <li class="nav-item active">
                                	 <a class="nav-link" href="chiSiamo.jsp">Chi siamo <span class="sr-only">(current)</span></a>
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
                                        <a class="dropdown-item" href="prenotazioniCliente">Le tue prenotazioni</a>
                                        <a class="dropdown-item" href="noleggioCliente">I tuoi noleggi</a>
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


    <!-- ***** Breadcumb Area Start ***** -->
    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/hero-1.jpg)">
    </div>
    <!-- ***** Breadcumb Area End ***** -->

    <div class="dorne-contact-area d-md-flex" id="contact">
        <!-- Contact Form Area -->
        <div class="contact-form-area equal-height">
            <div class="contact-text"> 
                <h4>Brevi cenni storici</h4>
            
                <div style=’text-align:justify’>
                ioNoleggio ha sempre nutrito una profonda passione per i motori. Gia' negli anni Venti, il fondatore si distingue partecipando con successo alle piu' prestigiose competizioni su strada e nel 1924, a cavallo della fedelissima Harley Davidson, si aggiudica l'ambito primo posto sul podio. 
        L'azienda ha rappresentato fino al 2014 la piu' grande realta' a capitale interamente italiano operante nel settore del noleggio a breve e medio termine di auto e veicoli commerciali, basando la sua forza nella imprenditorialita' familiare che ne ha caratterizzato lo sviluppo nel corso dei vari decenni e che ha continuato anche nella terza generazione della famiglia: un primato che possono vantare solo pochissime aziende italiane. 
        Nei suoi 67 anni di attivita', ioNoleggio ha sviluppato una rete sempre piu' capillare sul territorio nazionale, anche per noleggio furgoni, con una flotta veicoli davvero degna di nota.
         
              </div>  
            </div> 
            </div>
        </div>

    <!-- ****** Footer Area Start ****** -->
    <footer class="dorne-footer-area">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12 d-md-flex align-items-center justify-content-between">
                    <div class="footer-text">
                    
  
	<p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> A cura di Matteo e Davide | Un semplice sito di noleggio by M&D </p>
	
                        
                    </div>
                    <div class="footer-social-btns">
                        <a href="#"><i class="fa fa-linkedin" aria-haspopup="true"></i></a>
                        <a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>
                        <a href="#"><i class="fa fa-twitter" aria-haspopup="true"></i></a>
                        <a href="#"><i class="fa fa-facebook" aria-haspopup="true"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ****** Footer Area End ****** -->

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