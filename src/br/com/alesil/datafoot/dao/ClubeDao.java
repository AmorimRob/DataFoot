package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
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
			sessao = HibernateUtil.getSessionFactory();
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
	public List<Clube> pesquisarClube(String nome, String guidCidade, String estado){
		List<Clube> resultado = new ArrayList<Clube>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query consulta = sessao.createSQLQuery("SELECT cl.CL_GUID_CLUBE, cl.CL_NOME_CLUBE, "
					.concat("cl.CL_NOME_CURTO, cl.CL_ESTADO, ci.CI_GUID_CIDADE, ci.CI_NOME_CIDADE FROM df_clube cl ")
					.concat("LEFT JOIN df_cidade ci ON cl.CL_GUID_CIDADE = ci.CI_GUID_CIDADE ")
					.concat("WHERE cl.CL_NOME_CLUBE LIKE :n AND ci.CI_GUID_CIDADE LIKE :cid AND cl.CL_ESTADO LIKE :e "))
					.setParameter("n", nome + "%")
					.setParameter("cid", guidCidade + "%")
					.setParameter("e", estado + "%");
			
			List<Object[]>results = consulta.list();
			
			for(Object[] item : results){
				Clube cl = new Clube();
				cl.setGuidClube(item[0].toString());
				cl.setNomeClube(item[1].toString());
				cl.setNomeCurto(item[2].toString());
				cl.setEstado(item[3].toString());
				cl.setGuidCidade(item[4].toString());
				cl.setNomeCidade(item[5].toString());
				
				resultado.add(cl);
			}
			
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
			sessao = HibernateUtil.getSessionFactory();
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
			sessao = HibernateUtil.getSessionFactory();
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
