package br.com.alesil.datafoot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.alesil.datafoot.model.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(Atleta.class)
				.addAnnotatedClass(Clube.class).addAnnotatedClass(Cidade.class)
				.addAnnotatedClass(Categoria.class)
				.addAnnotatedClass(Posicao.class)
				.addAnnotatedClass(ComissaoTecnica.class)
				.addAnnotatedClass(FuncaoComissaoTecnica.class)
				.addAnnotatedClass(ComissaoTecnicaJogo.class)
				.addAnnotatedClass(Competicao.class)
				.addAnnotatedClass(CompeticaoClube.class)
				.addAnnotatedClass(Escalacao.class)
				.addAnnotatedClass(Estadio.class).addAnnotatedClass(Jogo.class)
				.addAnnotatedClass(Scout.class)
				.addAnnotatedClass(ScoutAcao.class)
				.addAnnotatedClass(ScoutDetalhes.class);

		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSessionFactory() {
		Session session = sessionFactory.openSession();
		return session;
	}
}
