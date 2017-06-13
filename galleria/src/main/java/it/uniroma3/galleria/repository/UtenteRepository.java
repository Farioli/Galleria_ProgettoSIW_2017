package it.uniroma3.galleria.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.galleria.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {

	Utente findByCodiceUtente(String codiceUtente);
	
	List<Utente> findByPermesso(String permesso);
	
	List<Utente> findByNomeAccount(String nomeAccount);
	
	List<Utente> findByNomeUtente(String nomeUtente);
	
	List<Utente> findByCogomeUtente(String cognomeUtente);
    
    List<Utente> findByDataNascita(Date dataNascita);
    
    Utente findByEmail(String email);

}
