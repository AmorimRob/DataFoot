package br.com.alesil.datafoot.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Competicao;

public class CompeticaoDao extends HibernateDAO{
	
	@SuppressWarnings("unchecked")
	public List<Competicao>listarCompeticao(String nomeComp, Date dataInicio){
		Query consulta;
		List<Competicao> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Competicao c where c.nomeCompeticao like :n AND c.dataInicio <= :d");
			consulta.setString("n", nomeComp.concat("%"));
			consulta.setDate("d", dataInicio);
			
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
	public List<Competicao>comboCompeticao(){
		Query consulta;
		List<Competicao> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Competicao");

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
	
	public byte[] buscarFoto(String guid){
		
		Query consulta;
		Competicao resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Competicao c where c.guidCompeticao = :gc");
			consulta.setString("gc", guid);

			resultado = (Competicao) consulta.uniqueResult();
			return resultado.getLogo();
			
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
