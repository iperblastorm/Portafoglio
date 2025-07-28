package com.Iperblastorm.Portafoglio.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//MODELLO DATI CHE ANDRA A RAPPRESENTARE LA TABELLA DEL DB SECONDO IL MODELLO POYO

@Entity
@Table(name="portafoglio")
public class Portafoglio {
	
	//LE VARIABILI DELLA CLASSE SONO LE COLONNE DELLA TABELLA
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String servizio;
	private String username;
	private String password;
	
	//COSTRUTTORE VUOTO E CON ELEMENTO, NON SI METTE ID PERCHE È AUTOGENERATO
	public Portafoglio() {
		super();
	}
	
	public Portafoglio(String servizio, String username, String password) {
		super();
		this.servizio = servizio;
		this.username = username;
		this.password = password;
	}


	//GETTER E SETTER 
	public int getId() {
		return id;
	}


	public String getServizio() {
		return servizio;
	}

	public void setServizio(String servizio) {
		this.servizio = servizio;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
