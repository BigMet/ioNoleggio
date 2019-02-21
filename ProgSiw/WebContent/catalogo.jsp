<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

	 <c:if test="${not loggato}">
    	<script>window.location = "index.jsp" </script> 
    </c:if>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalogo Categorie</title>

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

 
        
           

   

   

    <!-- ***** Editor Pick Area Start ***** -->
    <section class="dorne-editors-pick-area bg-img bg-overlay-9 section-padding-100" style="background-image: url(img/bg-img/hero-2.jpg);">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="section-heading text-center">
                       <div class="hero-content">
                       	<br><br>
                        <h2>Seleziona la categoria </h2>
                        <h4>Più adatta a te</h4>
                    </div>
                    </div>
                </div>
            </div>

                     <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                        <a id="A" onclick="cat(this.id)" style="cursor: pointer;"><img src="img/bg-img/categoriaA.png" alt=""></a>
                       <div class="editors-pick-info">
                           <div class="places-total-destinations d-flex">
                               <a id="A" onclick="cat(this.id)">Categoria A</a>
                            </div>
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                    <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                    <a id="B" onclick="cat(this.id)" style="cursor: pointer;"> <img src="img/bg-img/categoriaB.png" alt=""></a>
                        <div class="editors-pick-info">
                            <div class="places-total-destinations d-flex">
                                <a id="B" onclick="cat(this.id)">Categoria B</a>
                               <!--  <p align = "right"><h3> ciao</h3> </p> -->
                            </div>
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                   
                    <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                       <a id="C" onclick="cat(this.id)" style="cursor: pointer;"> <img src="img/bg-img/categoriaC.png" alt=""></a>
                        <div class="editors-pick-info">
                            <div class="places-total-destinations d-flex">
                                <a id="C" onclick="cat(this.id)">Categoria C</a>
                            </div>
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                    <div class="single-editors-pick-area wow fadeInUp" data-wow-delay="0.6s">
                     <a id="D" onclick="cat(this.id)" style="cursor: pointer;">   <img src="img/bg-img/categoriaD.png" alt=""></a>
                        <div class="editors-pick-info">
                            <div class="places-total-destinations d-flex">
                                <a id="D" onclick="cat(this.id)">Categoria D</a>
                            </div>
                            <div class="add-more">
                            </div>
                        </div>
                    </div>
                    
                </div>

                <div id="dI" data-value="${dataInizio}"></div>
                <div id="dF" data-value="${dataFine}"></div>
                <div id="prezzo" data-value="${prezzo}"></div>
    </section>
    <!-- ***** Editor Pick Area End ***** -->

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