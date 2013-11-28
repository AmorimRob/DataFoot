package br.com.alesil.datafoot.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory(){
		try{
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure("hibernate.cfg.xml");
			return cfg.buildSessionFactory();
			}
		catch(Throwable e){
			System.out.println("Erro ao abrir conexão! Erro: " + e);
			throw new ExceptionInInitializerError();
			}
		}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
		}
	}







