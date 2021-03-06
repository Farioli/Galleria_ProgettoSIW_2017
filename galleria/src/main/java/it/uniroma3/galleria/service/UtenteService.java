package it.uniroma3.galleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
    private UtenteRepository utenteRepository; 
	
	public Iterable<Utente> findAll() {
        return this.utenteRepository.findAll();
    }

    @Transactional
    public void add(final Utente utente) {
        this.utenteRepository.save(utente);
    }

	public Utente findbyId(Long id) {
		return this.utenteRepository.findOne(id);
	}
	
	public void delete(Utente utente){
		this.utenteRepository.delete(utente);
	}


}
