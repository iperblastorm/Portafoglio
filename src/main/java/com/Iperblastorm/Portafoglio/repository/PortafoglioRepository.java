package com.Iperblastorm.Portafoglio.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Iperblastorm.Portafoglio.model.Portafoglio;

//UN INTERFACCIA CHE ESTENDE JPA REPOSITORY E PRENDE IL MODELLO DATI CHE HO CREATO PRIMA E IL TIPO DI ID IN QUESTO CASO UN INTERO
@Repository
public interface PortafoglioRepository extends JpaRepository<Portafoglio, Integer> {

}
