package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Gamer {

	@Id
	@GeneratedValue
	int id;
	String psudo;
	
	@OneToMany()
	List<Partie> parties;
	
	@OneToOne(mappedBy = "gamer")
	Account account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPsudo() {
		return psudo;
	}
	public void setPsudo(String psudo) {
		this.psudo = psudo;
	}
	public List<Partie> getParties() {
		return parties;
	}
	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
