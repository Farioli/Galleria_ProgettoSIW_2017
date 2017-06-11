package it.uniroma3.galleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
    private ArtistaRepository artistaRepository; 
	
	public Iterable<Artista> findAll() {
        return this.artistaRepository.findAll();
    }

    @Transactional
    public void add(final Artista artista) {
        this.artistaRepository.save(artista);
    }

	public Artista findbyId(Long id) {
		return this.artistaRepository.findOne(id);
	}
	
	public void delete(Artista artista){
		this.artistaRepository.delete(artista);
	}


	

}
