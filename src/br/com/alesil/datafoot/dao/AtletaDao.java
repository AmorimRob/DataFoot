package br.com.alesil.datafoot.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Atleta;


public class AtletaDao extends HibernateDAO {
	@SuppressWarnings("unchecked")
	public List<Atleta> listarAtletas(String nome, String categoria, String guidClube){
		Query consulta;
		List<Atleta> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta a where a.apelido like :n AND a.guidClube like :gc");
			consulta.setString("n", nome);
			consulta.setString("gc", guidClube);
			
			resultado = consulta.list();
			return resultado;
			
		}catch(HibernateException erro){
				System.out.println("Erro ao executar transação: " + erro.getMessage());
				throw new HibernateException(erro);
			}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}
	
	public Atleta buscarAtleta(UUID guidAtleta){
		Query consulta;
		Atleta resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta a where a.guidAtleta = :ga;");
			consulta.setString("ga", String.valueOf(guidAtleta));

			
			resultado = (Atleta) consulta.uniqueResult();
			return resultado;
			
		}catch(HibernateException erro){
				System.out.println("Erro ao executar transação: " + erro.getMessage());
				throw new HibernateException(erro);
			}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}
	
}
