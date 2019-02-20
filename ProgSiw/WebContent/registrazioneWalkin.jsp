<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>registra Walk-in</title>

	<link rel="icon" href="img/core-img/favicon.ico">
    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="vendor/nouislider/nouislider.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <div class="container">
            <div class="signup-content">
                <div class="signup-img">
                    <img src="images/form-img.jpg" alt="">
                    <div class="signup-img-content">
                        <h2>Inserisci i dati  </h2>
                        <h2>del cliente</h2>
                    </div>
                </div>
                
                <div class="signup-form">
                    <form method="POST" class="register-form" id="register-form">
                        <div class="form-row">
                            <div class="form-group">
                                <div class="form-input">
                                    <label for="first_name" class="required">Nome</label>
                                    <input type="text" name="first_name" id="first_name" />
                                </div>
                                <div class="form-input">
                                    <label for="last_name" class="required">Cognome</label>
                                    <input type="text" name="last_name" id="last_name" />
                                </div>
                                <div class="wrap-input100 validate-input m-b-20">
                                 <label for="dataDiNascita" class="required">Data di nascita</label>
									<input class="input100" type="date" name="datanascita">
									<span class="focus-input100"></span>
								</div>
								<br>
								<div class="form-input">
                                    <label for="CodiceFiscale" class="required">Indirizzo</label>
                                    <input type="text" name="company" id="company" />
                                </div>
                                
                                
                                
                            </div>
                            
                            <!-- fine form sinistro -->
                            <div class="form-group">
                                <div class="form-input">
                                    <label for="phone_number" class="required">Telefono / cellulare</label>
                                    <input type="text" name="phone_number" id="phone_number" />
                                </div>
                                <div class="form-input">
                                    <label for="email" > Email</label>
                                    <input type="text" name="email" id="email" />
                                </div>
                                
                                <div class="form-input">
                                    <label for="cartaDc" class="required">Carta di credito</label>
                                    <input type="text" name="cartaDc" id="cartaDc" />
                                </div>
                                
                                <div class="form-input">
                                    <label for="numPatente" class="required">Numero patente</label>
                                    <input type="text" name="numPatente" id="numPatente" />
                                </div>
                                
                                
                            </div>
                        </div>
                        <br><br>
                        <div class="form-submit">
                            <input type="submit" value="Conferma" class="submit" id="submit" name="submit" />
                            <input type="submit" value="Reset" class="submit" id="reset" name="reset" />
                        </div>
                    </form>
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