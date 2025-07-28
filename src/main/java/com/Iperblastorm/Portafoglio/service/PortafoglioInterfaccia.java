package com.Iperblastorm.Portafoglio.service;

import java.util.List;

import com.Iperblastorm.Portafoglio.model.Portafoglio;

//QUI CI SONO TUTTI I METODI CHE DOVRA' USARE LA CLASSE CHE ACCEDE AL DB
public interface PortafoglioInterfaccia {
	
	// RICHIAMA TUTTE LE SCHEDE DENTRO AL PORTAFOGLIO
	public List<Portafoglio> tutteLeSchede();
	
	//RICHIAMA UNA SCHEDA ALLA VOLTA TRAMITE L'ID
	public Portafoglio unaScheda(int id);
	
	//AGGIUNGE UN ELEMENTO
	public void aggiungiElemento(Portafoglio elemento);
	
	//RIMUOVE UN ELEMENTO TRAMITE ID
	public void rimuovereElemento(int id);
	
	//AGGIORNARE UNA SCHEDA
	public void aggiornaScheda(int id, Portafoglio elemento);
	

}
