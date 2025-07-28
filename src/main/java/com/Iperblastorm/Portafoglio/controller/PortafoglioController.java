package com.Iperblastorm.Portafoglio.controller;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Iperblastorm.Portafoglio.model.Portafoglio;
import com.Iperblastorm.Portafoglio.service.PortafoglioDb;

@RestController
public class PortafoglioController {
	
	//SI INSERISCE LA CLASSE SERVICE E SI FA INJECTION
	private PortafoglioDb portafoglioDb;

	@Autowired
	public void setPortafoglioDb(PortafoglioDb portafoglioDb) {
		this.portafoglioDb = portafoglioDb;
	}
	
	//ORA CREO TUTTI GLI END-POINT
	
	@GetMapping("/Portafoglio")
	public List<Portafoglio> portafoglioCompleto(){
		return portafoglioDb.tutteLeSchede();
		}
	
	@GetMapping("/Portafoglio/{id}")
	// QUI STO DICENDO CHE L'ID VERRA DATO TRAMITE L'ENDPOINT QUINDI È IN UNA POSIZIONE VARIABILE
	public Portafoglio unaScheda(@PathVariable int id) {
		return portafoglioDb.unaScheda(id);
	}
	
	@PostMapping("/Portafoglio")
	//QUI GLI DICO CHE IL CORPO VERRA DATO TRAMITE RICHIESTA HTTP CIOE VIA ENDPOINT
	public ResponseEntity<Portafoglio> aggiungiScheda (@RequestBody Portafoglio scheda) {
		portafoglioDb.aggiungiElemento(scheda);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.contentType(MediaType.APPLICATION_JSON)
				.body(scheda);

}
	
	@PutMapping("/Portafoglio/{id}")
	public void aggiornaScheda(@PathVariable int id, @RequestBody Portafoglio scheda) {
		portafoglioDb.aggiornaScheda(id, scheda);
	}
	
	@DeleteMapping("/Portafoglio/{id}")
	public void eliminaScheda(@PathVariable int id) {
		portafoglioDb.rimuovereElemento(id);
	}
	
}
