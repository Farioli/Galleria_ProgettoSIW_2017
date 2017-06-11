package it.uniroma3.galleria.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int utenteId;
	
	@Column(nullable=false)
	private String nomeAccount;
	
	@Column(nullable=false)
	private String permesso;
	
	@Column(nullable = false)
	private String nomeUtente;
	
	@Column(nullable = false)
	private String cognomeUtente;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Column(nullable = false, unique = true)
	private String email;

	
	public Utente(String nomeAccount, String permesso, String nomeUtente, String cognomeUtente, Date dataNascita, String email) {
		super();
		this.nomeAccount = nomeAccount;
		this.permesso = permesso;
		this.nomeUtente = nomeUtente;
		this.cognomeUtente = cognomeUtente;
		this.dataNascita = dataNascita;
		this.email = email;
	}
	
	
	public int getUtenteId() {
		return utenteId;
	}

	public String getNomeAccount() {
		return nomeAccount;
	}

	public void setNomeAccount(String nomeAccount) {
		this.nomeAccount = nomeAccount;
	}

	public String getPermesso() {
		return permesso;
	}


	public void setPermesso(String permesso) {
		this.permesso = permesso;
	}


	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return this.email.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		Utente accountUtente = (Utente) obj;
		return this.getEmail().equals(accountUtente.getEmail());
	}
	
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Account utente");
        sb.append("{id=").append(utenteId);
        sb.append(", nome account=").append(nomeAccount);
        sb.append(", privilegi account=").append(permesso);
        sb.append(", nome utente=").append(nomeUtente);
        sb.append(", cognome utente=").append(cognomeUtente);
        sb.append(", email'=").append(email);
        sb.append(", data nascita=").append(dataNascita);
        sb.append("}\n");
        return sb.toString();
    }

}
