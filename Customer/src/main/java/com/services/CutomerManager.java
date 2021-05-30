package com.services;

import com.dao.CusomerDao;

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
}
