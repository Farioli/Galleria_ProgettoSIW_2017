package it.uniroma3.galleria.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.galleria.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Long> {
	
	List<Artista> findByCodiceArtista(String codiceArtista);
	
	List<Artista> findByNomeArtista(String nomeArtista);
	
	List<Artista> findByCogomeArtista(String cognomeArtista);
   
    List<Artista> findByNazionalita(String nazione);
    
    List<Artista> findByDataNascita(Date dataNascita);
    
    List<Artista> findByDataMorte(Date dataMorte);

}
