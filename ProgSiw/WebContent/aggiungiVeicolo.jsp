<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Aggiungi Veicolo</title>

	<link rel="icon" href="img/core-img/favicon.ico">
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="vendor/nouislider/nouislider.min.css">
    
    <link rel="stylesheet" type="text/css" href="css/main.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

	
    <div class="main">

        <div class="container" >
            <div class="signup-content">
                <div class="signup-img">
                    <img src="images/form-img.jpg" alt="">
                    <div class="signup-img-content">
                        <h2>Inserisci i dati  </h2>
                        <h2>del veicolo</h2>
                    </div>
                </div>
                
                <div class="signup-form">
                    <form action="${pageContext.request.contextPath}/registraVeicolo" method="POST" class="register-form" id="register-form">
                        <div class="form-row">
                            <div class="form-group">
                                <div class="form-input">
                                    <label for="targa" class="required">Targa</label>
                                    <input type="text" name="targa" id="targa" />
                                </div>
                                <div class="form-input">
                                    <label for="categoria" class="required">Categoria</label>
                                    <input type="text" name="categoria" id="categoria" />
                                </div>
                                <div class="wrap-input100 validate-input m-b-20">
                                 <label for="dataAcquisto" class="required">Data Acquisto</label>
									<input class="input100" type="date" name="dataAcquisto">
									<span class="focus-input100"></span>
								</div>
								<br>
								<!-- <div class="form-input">
                                    <label for="prezzo" class="required">Prezzo</label>
                                    <input type="text" name="prezzo" id="prezzo" />
                                </div>
                                
                                <div class="form-input">
                                    <label for="casaProduttrice" class="required">Casa Produttrice</label>
                                    <input type="text" name="casaProduttrice" id="casaProduttrice" />
                                </div>
                                
                                 <div class="form-input">
                                    <label for="modello" class="required">Modello</label>
                                    <input type="text" name="modello" id="modello" />
                                </div> -->
                                
                                
                                
                            </div>
                            
                            <!-- fine form sinistro -->
                            <div class="form-group">
                                <div class="form-input">
                                    <label for="prezzo" class="required">Prezzo</label>
                                    <input type="text" name="prezzo" id="prezzo" />
                                </div>
                                
                                <div class="form-input">
                                    <label for="casaProduttrice" class="required">Casa Produttrice</label>
                                    <input type="text" name="casaProduttrice" id="casaProduttrice" />
                                </div>
                                
                                 <div class="form-input">
                                    <label for="modello" class="required">Modello</label>
                                    <input type="text" name="modello" id="modello" />
                                </div>
                                
                                
                            </div>
                        </div>
                        <br><br>
                        <div class="form-submit">
                            <input type="submit" value="Conferma" class="submit" id="submit" name="submit" />
                            <input type="submit" value="Reset" class="submit" id="reset"  name="reset" />
                        </div>
                    </form>
                            <a href="indexAdmin.jsp"><input type="submit" value="Home" class="submit" id="home"  name="submit" /></a>
                </div>
            </div>
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/nouislider/nouislider.min.js"></script>
    <script src="vendor/wnumb/wNumb.js"></script>
    <script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="js/mainRegistrazione.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>