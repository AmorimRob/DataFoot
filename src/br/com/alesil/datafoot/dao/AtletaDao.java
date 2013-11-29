package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Atleta;


public class AtletaDao extends HibernateDAO {
	@SuppressWarnings("unchecked")
	public List<Atleta> pesquisarAtletas(String nome, String categoria, String guidClube){
		Query consulta;
		List<Atleta> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta a where a.apelido like :n AND a.guidClube like :gc");
			consulta.setString("n", nome + "%");
			consulta.setString("gc", guidClube + "%");
			
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
	
	public Atleta buscarAtletaPorGuid(String guidAtleta){
		Query consulta;
		Atleta resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta a where a.guidAtleta = :ga");
			consulta.setString("ga", guidAtleta);

			
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
	
	public byte[] buscarFoto(String guid){
		
		Query consulta;
		Atleta resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta a where a.guidAtleta = :ga");
			consulta.setString("ga", guid);

			
			resultado = (Atleta) consulta.uniqueResult();
			return resultado.getFoto();
			
		}catch(HibernateException erro){
				System.out.println("Erro ao executar transação: " + erro.getMessage());
				throw new HibernateException(erro);
			}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}

	
	@SuppressWarnings("unchecked")
	public List<Atleta> listarAtletas(){		
		Query consulta;
		List<Atleta> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Atleta");
			
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
	
}
