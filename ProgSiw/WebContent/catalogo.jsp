<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <c:if test="${not loggato}">
    	<script>window.location = "provaLogin.jsp" </script> 
    </c:if>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo</title>
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
                                
                              <c:if test="${not admin}">
                                <li class="nav-item dropdown">
                                	 <a class="nav-link" href="chiSiamo.jsp">Chi siamo </a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="contatti.jsp">Contatti </a>
                                </li>
                                <li class="nav-item dropdown">
                                	<a class="nav-link" href="flotta.jsp">La nostra flotta </a>
                                </li>
                               </c:if>
                                
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
                            
                            <c:if test="${not admin}">
						    	
                            <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Il mio profilo <i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    	<a class="dropdown-item" href="profilo.jsp">${nome}</a>
                                        <a class="dropdown-item" href="prenotazioniCliente">Le tue prenotazioni</a>
                                        <a class="dropdown-item" href="noleggioCliente">I tuoi noleggi</a>
                                    </div>
                                </li>
						    </c:if>
						    
						    <c:if test="${admin}">
						    <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Gestione <i class="fa fa-angle-down" aria-hidden="true"></i></a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="prenotazioniServlet">Tutte le prenotazioni</a>
                                        <a class="dropdown-item" href="noleggioServlet">Tutti i noleggi</a>
                                    </div>
                                </li>
						    
						    </c:if>
                            
                            </c:if>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/hero-1.jpg)">
    </div>

                      
 <section class="dorne-listing-destinations-area section-padding-100-50">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading dark text-center">
                        <span></span>
                        <h4>Seleziona l'auto</h4>
                        <p>Scegli l'auto piu' adatta alle tue esigenze</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="A" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria A.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 12 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria A</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="B" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria B.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 18 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria B</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                            
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="C" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria C.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 22 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria C</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                            
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="D" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria D.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 30 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria D</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                            
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="I" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria I.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 35 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria I</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                           
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="P" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria P.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 33 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria P</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                           
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="N" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria N.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 25 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria N</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                            <div class="feature-favourite">
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="O" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria O.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 40 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria O</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                        </div>
                        </a>
                    </div>
                </div>
                <!-- Single Features Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="single-features-area mb-50">
                        <a id="L" onclick="cat(this.id)" style="cursor: pointer;"><img src="images/CatalogoAuto/Categoria L.png" alt="">
                        <!-- Price -->
                        <div class="price-start">
                            <p>DA 48 Euro/giorno</p>
                        </div>
                        <div class="feature-content d-flex align-items-center justify-content-between">
                            <div class="feature-title">
                                <h5>Categoria L</h5>
                                <p>L'auto in foto e' puramente indicativa.</p>
                            </div>
                        </div>
                    	</a>
                    </div>
                </div>
            </div>
            
            <div id="dI" data-value="${dataInizio}"></div>
		    <div id="dF" data-value="${dataFine}"></div>
		    <div id="prezzo" data-value="${prezzo}"></div>
        </div>
        
    </section>
    <!-- ***** Listing Destinations Area End ***** -->
    
    
       <!--  Contact Form Area -->
        <div class="contact-form-area equal-height">
            </div>
        
    
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
<div id="i" data-value="${dataInizio}"></div>
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