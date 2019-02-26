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
    <link href="style.css" rel="stylesheet">
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
                    <div class="register-form">
                        <div class="form-row">
                            <div class="form-group">
                                <div class="form-input">
                                    <label for="targa" class="required">Targa</label>
                                    <input type="text" name="targa"  id="targa" required>
                                </div>
                                <div class="form-input">
                                    <label for="categoria" class="required">Categoria</label>
                                    <input type="text" name="categoria" id="categoria" required/>
                                </div>
                                <div class="wrap-input100 validate-input m-b-20">
                                 <label for="dataAcquisto" class="required">Data Acquisto</label>
									<input class="input100" type="date" value="1997-01-01" name="dataAcquisto" id="dataAcquisto" required>
									<span class="focus-input100"></span>
								</div>
								<br>
                            </div>
                            
                            <!-- fine form sinistro -->
                            <div class="form-group">
                                
                                <div class="form-input">
                                    <label for="casaProduttrice" class="required">Casa Produttrice</label>
                                    <input type="text" name="casaProduttrice" required id="casaProduttrice" />
                                </div>
                                
                                 <div class="form-input">
                                    <label for="modello" class="required">Modello</label>
                                    <input type="text" name="modello" id="modello" required/>
                                </div>
                            </div>
                            
                        </div>
                        <br><br>
                        <div class="form-submit">
                        <button onclick="aggiungiVeicolo()" class="btn dorne-btn"> Conferma</button>
                        <a href="aggiungiVeicolo.jsp"><input type="submit" value="Reset" class="submit" id="reset"  name="reset" /></a>
                        <a href="indexAdmin.jsp"><input type="submit" value="Home" class="submit"   name="submit" /></a>
                        </div>
                    </div>
                    <!--         <a href="indexAdmin.jsp"><input type="submit" value="Home" class="submit" id="home"  name="submit" /></a> -->
                            
                </div>
            </div>
        </div>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="vendor/nouislider/nouislider.min.js"></script>
    <script src="vendor/wnumb/wNumb.js"></script>
    <script src="vendor/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="vendor/jquery-validation/dist/additional-methods.min.js"></script>
    <script src="js/mainRegistrazione.js"></script>
    <script src="js/custom.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>