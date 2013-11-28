package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Clube;

public class ClubeDao extends HibernateDAO {

	@SuppressWarnings("unchecked")
	public List<Clube> comboClubes(){
		Query consulta;
		List<Clube> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Clube");
			
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
	
	@SuppressWarnings("unchecked")
	public List<Clube> listaClube(String nome, String guidCidade, String estado){
		Query consulta;
		List<Clube> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Clube c where c.nomeCurto like :n AND c.guidCidade like :gc AND c.estado like :e");
			consulta.setString("n", nome + "%");
			consulta.setString("gc", guidCidade + "%");
			consulta.setString("e", estado + "%");
			
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
	
	public Clube buscarClube(String guidClube){
		Query consulta;
		Clube resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Clube c where c.guidClube = :gc");
			consulta.setString("gc", guidClube);
			
			resultado = (Clube) consulta.uniqueResult();
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
		Clube resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Clube c where c.guidClube = :gc");
			consulta.setString("gc", guid);

			
			resultado = (Clube) consulta.uniqueResult();
			return resultado.getEscudo();
			
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
