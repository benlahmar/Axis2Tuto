package com.services;

import java.util.List;

import com.dao.CusomerDao;
import com.model.Account;

public class CutomerManager {

	CusomerDao dao;

	public CutomerManager() {
		dao=new CusomerDao();
	}
	
	public int addprofile(String nom,String prenom)
	{
		return dao.addProfile(nom, prenom);
	}
	
	public int addAccount(String log,String pass, String role,int idp)
	{
		return dao.addAccount(log, pass, role, idp);
	}
	public Account signin(String log,String pass)
	{
		return dao.authentificat(log, pass);
	}
	
	public List<Account> allacc(int idp)
	{
		return dao.allAccount(idp);
	}
	
	
	public int addgamer(String psd, int idacc)
	{
		return dao.addGamer(psd, idacc);
	}
	
	public int addconf(String lib, int nbe, int nbj,long time)
	{
		return dao.addConf(lib, nbe, time, nbj);
	}
	
	public int addresult(int idp, double score, boolean isa)
	{
		return dao.addresult(idp, score, isa);
	}
	
	public int addpartie(int idg1,int idg2, int idconf)
	{
		return dao.addPartie(idg1, idg2, idconf);
	}
}
