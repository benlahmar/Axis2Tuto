package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sf;
	public static SessionFactory getSessionFactory()
	{
		 sf=new Configuration().configure().buildSessionFactory();
		 return sf;
	}
}
