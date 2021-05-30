package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Account;
import com.model.Profile;

public class CusomerDao implements Idao{

	@Override
	public int addAccount(String log, String pass, String role, int idp) {
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Account acc=new Account();
		Profile p;
		acc.setRole(role);
		acc.setLog(log);
		acc.setPass(pass);
		p=ses.find(Profile.class, idp);
		acc.setProfile(p);
		ses.persist(acc);
		ses.getTransaction().commit();
		
		return 1;
	}

	@Override
	public int addProfile(String nom, String prenom) {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			Profile p=new Profile();
			p.setNom(nom);
			p.setPrenom(prenom);
			ses.persist(p);
			ses.getTransaction().commit();
			
		return 1;
	}

}
