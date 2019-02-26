<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>La nostra flotta</title>
	<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->


	
	
    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="style.css" rel="stylesheet">
	<link rel="stylesheet" href="css/slideshow.css" >

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
                                <li class="nav-item dropdown">
                                	 <a class="nav-link" href="chiSiamo.jsp">Chi siamo </a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="contatti.jsp">Contatti </a>
                                </li>
                                <li class="nav-item active">
                                	<a class="nav-link" href="flotta.jsp">La nostra flotta <span class="sr-only">(current)</span></a>
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
   <section class="dorne-listing-destinations-area section-padding-100-50">
	<div class="container">
		<div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <h4>Scopri il nostro catalogo</h4>
                        <p>Individua l'auto che fa al caso tuo.</p>
                    </div>
                </div>
            </div>
           </div>
       </section>
    

        
         <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                        <img src="img/1e2.png"  alt="immagine 1 e 2">
                       <div class="editors-pick-info">
                           
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                    
                    <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                       <img src="img/3e4.png"  alt="immagine 1 e 2">
                       <div class="editors-pick-info">
                           
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                    
                    <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                        <img src="img/5e6.png"  alt="immagine 1 e 2">
                       <div class="editors-pick-info">
                           
                            <div class="add-more">
                            </div>
                        </div>
                    </div> 
        
    <!-- ***** Contact Area End ***** -->

    <!-- ****** Footer Area Start ****** -->
    <br><br><br><br><br><br><br><br>
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
    
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
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
    <script src="js/slideshowjs.js"></script>
    
</body>
</html>