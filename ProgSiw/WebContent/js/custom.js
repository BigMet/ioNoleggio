function cat(categoria){
	$.ajax({
		type:"GET",
		url:"categoriaA",
		data:{categ:categoria},
		success:function(response){
			if(response=="noLog"){
				window.location="provaLogin.jsp" ;
			}
			swal({
				  title: "Sei Sicuro?",
				  text: " Verra' effettuata una prenotazione dal: "+document.getElementById("dI").getAttribute("data-value")+ " Al: "+document.getElementById("dF").getAttribute("data-value")+" "+response+ " EURO",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
				    $.ajax({
				    	type:"POST",
				    	url:"prenotazione",
				    	success:function(response){
				    		console.log(response);
				    		swal( {
								  title: "Congratulazioni! La prenotazione e' andata a buon fine",
								  text: "Codice Prenotazione: "+response,
							      icon: "success",
							      button:true,
							    });
				    	}
				    });
					  
					
					  } else {
				    swal("Perfetto! Hai annullato la prenotazione");
				  }
				});
			
		}
	})
}

function creaNoleggio(){
	console.log(document.getElementById("idPrenotazione").value);
	$.ajax({
	type:"GET",
	data:{idP:document.getElementById("idPrenotazione").value},
	url:"cercaPrenotazione",
	success:function(response){
		console.log(response);
		if(response=="notfound")
			swal({
				  title:"OPS!",
				  text: "Prenotazione Inesistente!",
				  icon: "error",
		});
		else{ 	
		swal({
			  title: "Sei Sicuro?",
			  text: "Il totale e' "+response+" Euro. Confermare Il Noleggio?",
			  icon: "success",
			  buttons:true,
			}).then((willDelete) => {
				  if (willDelete) {
					    $.ajax({
					    	type:"POST",
					    	url:"cercaPrenotazione",
					    	data:{idP:document.getElementById("idPrenotazione").value,nP:document.getElementById("numPatente").value,nC:document.getElementById("numCarta").value},
					    });
				  }
					    });}
	}
	
	});
	
}

