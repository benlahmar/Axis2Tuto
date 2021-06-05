package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Account;
import com.model.Config;
import com.model.Gamer;
import com.model.Partie;
import com.model.Profile;
import com.util.HibernateUtil;

public class CusomerDao implements Idao{

	@Override
	public int addAccount(String log, String pass, String role, int idp) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
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
		ses.close();
		sf.close();
		return 1;
	}

	@Override
	public int addProfile(String nom, String prenom) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
			Session ses = sf.openSession();
			ses.beginTransaction();
			Profile p=new Profile();
			p.setNom(nom);
			p.setPrenom(prenom);
			ses.persist(p);
			ses.getTransaction().commit();
			ses.close();
			sf.close();
		return 1;
	}

	@Override
	public Account authentificat(String log, String pass) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		List<Account> ls = ses.createQuery("from Account c where c.log='"+log+"' and c.pass='"+pass+"'").list();
		ses.getTransaction().commit();
		ses.close();
		sf.close();
		if(ls.size()>0)
		return ls.get(0);
		else
			return null;
		
		
	}

	@Override
	public List<Account> allAccount(int idp) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		List<Account> ls = ses.createQuery("from Account c where c.profile.id="+idp).list();
		ses.getTransaction().commit();
		ses.close();
		
		return ls;
	}

	@Override
	public int addGamer(String psudo, int idacc) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Gamer g=new Gamer();
		g.setPsudo(psudo);
		Account acc = ses.get(Account.class, idacc);
		g.setAccount(acc);
		//acc.setGamer(g);
		ses.save(g);
		ses.getTransaction().commit();
		ses.close();
		return 1;
	}

	@Override
	public int addaccountgamer(int idg, int idacc) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addConf(String lib, int nbessais, long time, int nbj) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Config cf = new Config();
		cf.setLibelle(lib);
		cf.setNbessai(nbessais);
		cf.setNbgamer(nbj);
		cf.setTime(time);
		ses.save(cf);
		ses.getTransaction().commit();
		ses.close();
		return 1;
		
	}

	@Override
	public int addPartie(int idg1, int idg2, int idconf) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Partie p=new Partie();
		Gamer g1 = ses.get(Gamer.class, idg1);
		Gamer g2 = ses.get(Gamer.class, idg2);
		Config cf = ses.get(Config.class, idconf);
		p.setG1(g1);
		p.setG2(g2);
		p.setDate(LocalDate.now());
		p.setConf(cf);
		ses.save(p);
		ses.getTransaction().commit();
		ses.close();
		return 1;
		
	}

	@Override
	public int addresult(int partie, double score, boolean isachever) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Partie part = ses.get(Partie.class, partie);
		part.setAchever(isachever);
		part.setScore(score);
		ses.update(part);
		ses.getTransaction().commit();
		ses.close();
		return 1;
	}

	@Override
	public List<Gamer> allGamersort() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		List<Gamer> ls = ses.createQuery("from Gamer").list();
		ses.getTransaction().commit();
		ses.close();
		
		return ls;
	}

	@Override
	public Gamer findGamer(int idg) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		Gamer g = ses.get(Gamer.class, idg);
		ses.getTransaction().commit();
		ses.close();
		
		return g;
	}

	@Override
	public Config getconfig(int id) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		 Config cf = ses.get(Config.class, id);
		ses.getTransaction().commit();
		ses.close();
		
		return cf;
	}

	@Override
	public List<Config> allconfigs() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		  List<Config> cf = ses.createQuery("from Config").list();
		ses.getTransaction().commit();
		ses.close();
		
		return cf;
	}

	@Override
	public List<Partie> allpartie4gamer(int idg) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		List<Partie> ps = ses.createQuery("from Partie p where p.g1.id="+idg+" or p.g2.id="+idg).list();
		ses.getTransaction().commit();
		ses.close();
		
		return ps;
		
	}

	@Override
	public Config getconfig4partie(int idp) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		ses.beginTransaction();
		 Partie pr = ses.get(Partie.class, idp);
		 Config cf = pr.getConf();
		ses.getTransaction().commit();
		ses.close();
		
		return cf;
	}

}
