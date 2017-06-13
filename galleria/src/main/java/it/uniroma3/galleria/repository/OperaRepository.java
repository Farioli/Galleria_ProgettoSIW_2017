package it.uniroma3.galleria.repository;

import java.util.Date;
import java.util.List;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;

public interface OperaRepository {

	Opera findByCodiceOpera(String codiceOpera);
	
	List<Opera> findByTitolo(String titolo);
	
	List<Opera> findByArtista(Artista artista);
	
	List<Opera> findByTecnica(String tecnica);
	
	List<Opera> findByData(Date data);
	
	List<Opera> findByDimensioneA(int dimensioneA);
	List<Opera> findByDimensioneL(int dimensioneL);

	}
