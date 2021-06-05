package com.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Partie {

	@Id
	@GeneratedValue
	int id;
	LocalDate date;
	long time;
	double score;
	
	@ManyToOne
	Gamer g1;
	@ManyToOne
	Gamer g2;
	
	boolean isAchever;

	@ManyToOne
	Config conf;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Gamer getG1() {
		return g1;
	}

	public void setG1(Gamer g1) {
		this.g1 = g1;
	}

	public Gamer getG2() {
		return g2;
	}

	public void setG2(Gamer g2) {
		this.g2 = g2;
	}

	public boolean isAchever() {
		return isAchever;
	}

	public void setAchever(boolean isAchever) {
		this.isAchever = isAchever;
	}

	public Config getConf() {
		return conf;
	}

	public void setConf(Config conf) {
		this.conf = conf;
	}
	
	
	
}
