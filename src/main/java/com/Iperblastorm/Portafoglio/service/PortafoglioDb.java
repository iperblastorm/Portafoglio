package com.Iperblastorm.Portafoglio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.Iperblastorm.Portafoglio.model.Portafoglio;
import com.Iperblastorm.Portafoglio.repository.PortafoglioRepository;

@Service
public class PortafoglioDb implements PortafoglioInterfaccia {

	//CREO UN ISTANZA DELLA REPOSITORY TRAMITE SETTER
	private PortafoglioRepository repository;
	
	@Autowired
	public void setRepository(PortafoglioRepository repository) {
		this.repository = repository;
	}
	
	
	//ORA VADO AD IMPLEMENTARE TUTTI I METODI DEL INTERFACCIA

	@Override
	@Cacheable("Portafoglio")
	public List<Portafoglio> tutteLeSchede() {
		return repository.findAll();
	}

	@Override
	@Cacheable("Portafoglio")
	public Portafoglio unaScheda(int id) {
		//CREO UNA LISTA SENZA ELEMENTI VUOTI CON LA POSSIBILITA DI USARE PRESENT PER SAPERE SE UN ELEMENTO CE O NO
		Optional<Portafoglio> temp = this.repository.findById(id);
		//SE L'ELEMENTO CE ALLORA RITORNA L'ELEMENTO, ALTRIMENTI RITORNA NULL 
		if(temp.isPresent())
		{
			return temp.get();
		}
		else {
			
			return null;
		}
	}

	
	@Override
	@Cacheable("Portafoglio")
	public void aggiungiElemento(Portafoglio elemento) {
		repository.save(elemento);		
	}

	@Override
	@CachePut(value = "Portafoglio", key = "#Portafoglio.id")
	public void rimuovereElemento(int id) {
		repository.deleteById(id);
	}

	@Override
	@CachePut(value = "Ingredienti", key = "#ingrediente.id")
	public void aggiornaScheda(int id, Portafoglio elemento) {
		repository.save(elemento);
	}
	
	

}
