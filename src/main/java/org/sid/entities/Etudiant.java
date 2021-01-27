package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity

public class Etudiant  {
	@Id   @GeneratedValue
  private Long idEtudiant;
  public Etudiant(String nom, String prenom, Date datedeNaissance) {
		super();
		Nom = nom;
		Prenom = prenom;
		DatedeNaissance = datedeNaissance;
	}
public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
public Long getIdEtudiant() {
		return idEtudiant;
	}
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Date getDatedeNaissance() {
		return DatedeNaissance;
	}
	public void setDatedeNaissance(Date datedeNaissance) {
		DatedeNaissance = datedeNaissance;
	}
  private String Nom;
  private String Prenom;
  private Date DatedeNaissance;
}
