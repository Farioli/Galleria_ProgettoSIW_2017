package it.uniroma3.galleria.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "trovaTuttiArtisti", query = "SELECT a FROM Artista a")
public class Artista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int artistaId;							//artistaId e' la chiave primaria generata dal sistema
	
	@Column(nullable = false, unique = true)
	private String codiceArtista;					//codiceArtista e' una chiave di ricerca assegnata dagli admin
	
	@Column(nullable = false)
	private String nomeArtista;
	
	@Column(nullable = false)
	private String cognomeArtista;
	
	@Column(nullable = false)
	private String nazionalita;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date annoNascita;
	
	@Temporal(TemporalType.DATE)
	private Date annoMorte;
	
	@OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@OrderBy("anno asc")
	private List<Opera> opere;
	
	
	public Artista(String codiceArtista, String nomeArtista, String cognomeArtista, String nazionalita,
			Date annoNascita, Date annoMorte) {
		super();
		this.codiceArtista = codiceArtista;
		this.nomeArtista = nomeArtista;
		this.cognomeArtista = cognomeArtista;
		this.nazionalita = nazionalita;
		this.annoNascita = annoNascita;
		this.annoMorte = annoMorte;
	}

	

	public int getArtistaId() {
		return artistaId;
	}
	
	public String getCodiceArtista() {
		return codiceArtista;
	}

	public void setCodiceArtista(String codiceArtista) {
		this.codiceArtista = codiceArtista;
	}

	
	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}


	public String getCognomeArtista() {
		return cognomeArtista;
	}

	public void setCognomeArtista(String cognomeArtista) {
		this.cognomeArtista = cognomeArtista;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getAnnoNascita() {
		return annoNascita;
	}

	public void setAnnoNascita(Date annoNascita) {
		this.annoNascita = annoNascita;
	}

	public Date getAnnoMorte() {
		return annoMorte;
	}

	public void setAnnoMorte(Date annoMorte) {
		this.annoMorte = annoMorte;
	}


	@Override
	public int hashCode() {
		return this.codiceArtista.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Artista artista = (Artista) obj;
		return this.getCodiceArtista().equals(artista.getCodiceArtista());
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Artista");
        sb.append("{id=").append(artistaId);
        sb.append(", codice=").append(codiceArtista);
        sb.append(", nome=").append(nomeArtista);
        sb.append(", cognome=").append(cognomeArtista);
        sb.append(", anno nascita=").append(annoNascita);
        if(annoMorte != null) {sb.append(", anno morte=").append(annoMorte);}
        sb.append(", nazionalita'=").append(nazionalita);
        sb.append("}\n");
        return sb.toString();
    }

}
