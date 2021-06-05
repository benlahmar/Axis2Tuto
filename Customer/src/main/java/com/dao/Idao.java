package com.dao;

import java.util.List;

import com.model.Account;
import com.model.Config;
import com.model.Gamer;
import com.model.Partie;

public interface Idao {

	public int addAccount(String log,String pass,String role, int idp);
	public int addProfile(String nom, String prenom);
	public Account authentificat(String log,String pass);
	public List<Account> allAccount(int idp);
	
	
	public int addGamer(String psudo, int idacc);
	public int addaccountgamer(int idg, int idacc);
	
	public int addConf(String lib, int nbessais, long time, int nbj);
	
	public int addPartie(int idg1, int idg2, int idconf);
	public int addresult(int partie, double score, boolean isachever);
	public List<Gamer> allGamersort();
	public Gamer findGamer(int idg);
	public Config getconfig(int id);
	
	public Config getconfig4partie(int idp);
	
	public List<Config> allconfigs();
	public List<Partie> allpartie4gamer(int idg);
}
