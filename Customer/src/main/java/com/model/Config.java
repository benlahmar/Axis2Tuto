package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Config {

	@Id
	@GeneratedValue
	int id;
	String libelle;
	int nbessai;
	long time;
	int nbgamer;
	
	@OneToMany(mappedBy = "conf")
	List<Partie> parties;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNbessai() {
		return nbessai;
	}

	public void setNbessai(int nbessai) {
		this.nbessai = nbessai;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getNbgamer() {
		return nbgamer;
	}

	public void setNbgamer(int nbgamer) {
		this.nbgamer = nbgamer;
	}

	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}
	
	public double calcscore()
	{
		double x = 1/(time * nbessai);
		return x;
	}
	
}
