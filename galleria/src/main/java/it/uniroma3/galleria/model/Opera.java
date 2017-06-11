package it.uniroma3.galleria.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "trovaTutteOpere", query = "SELECT o FROM Opera o")
public class Opera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int operaId;							//operaId e' la chiave primaria generata dal sistema
	
	@Column(nullable = false, unique = true)
	private String CodiceOpera;						//CodiceOpera e' una chiave di ricerca assegnata dagli admin
	
	@Column(nullable=false)
	private String titolo;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "artista")
	private Artista artista;						//artista che ha creato l'opera
	
	@Column(nullable = false)
	private String tecnica;
	
	@Temporal(TemporalType.DATE)
	private Date anno;
	
	@Column(nullable = false)
	private int dimensioneL;
	
	@Column(nullable = false)
	private int dimensioneA;
	
	public Opera(){}
	public Opera(String codiceOpera, String titolo, Artista artista, String tecnica, Date anno,
			int dimensioneL, int dimensioneA) {
		super();
		CodiceOpera = codiceOpera;
		this.artista = artista;
		this.tecnica = tecnica;
		this.anno = anno;
		this.dimensioneL = dimensioneL;
		this.dimensioneA = dimensioneA;
	}
	
	

	public String getCodiceOpera() {
		return CodiceOpera;
	}
	
	public void setCodiceOpera(String codiceOpera) {
		CodiceOpera = codiceOpera;
	}
	
	public int getOperaId() {
		return operaId;
	}
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public Date getAnno() {
		return anno;
	}

	public void setAnno(Date anno) {
		this.anno = anno;
	}

	public int getDimensioneL() {
		return dimensioneL;
	}

	public void setDimensioneL(int dimensioneL) {
		this.dimensioneL = dimensioneL;
	}

	public int getDimensioneA() {
		return dimensioneA;
	}

	public void setDimensioneA(int dimensioneA) {
		this.dimensioneA = dimensioneA;
	}
	
	
	
    @Override
	public int hashCode() {
		return this.getCodiceOpera().hashCode();
    }
    
    
	@Override
	public boolean equals(Object obj) {
		Opera opera = (Opera) obj;
		return this.getCodiceOpera().equals(opera.getCodiceOpera());
	}
	
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Opera");
        sb.append("{id=").append(operaId);
        sb.append(", codice=").append(CodiceOpera);
        sb.append(", titolo=").append(titolo);
        sb.append(", artista=").append(artista.getNomeArtista()).append("' ").append(artista.getCognomeArtista());
        sb.append(", anno=").append(anno);
        sb.append(", tecnica=").append(tecnica);
        sb.append(", dimensioni=").append(dimensioneL).append("X").append(dimensioneA);
        sb.append("}\n");
        return sb.toString();
    }

}
