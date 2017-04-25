package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Universite implements Serializable {
	@Id @GeneratedValue
	private Long id_universite;
	private String nom;
	private String region;
	public Universite() {
		super();
	}
	public Universite(String nom, String region) {
		super();
		this.nom = nom;
		this.region = region;
	}
	
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Long getId_universite() {
		return id_universite;
	}
	public void setId_universite(Long id_universite) {
		this.id_universite = id_universite;
	}
	
	

}
