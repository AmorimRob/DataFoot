package br.com.alesil.datafoot.dao;

import org.hibernate.*;

public class HibernateDAO {
	protected Session sessao = null;
	protected Transaction transacao = null;
	
	public void executaTransacao(Object dados, int operacao){
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			transacao = sessao.beginTransaction();
			if (operacao == 1) sessao.saveOrUpdate(dados);
			else if (operacao == 2) sessao.delete(dados);
			transacao.commit();
			}
		catch(HibernateException erro){
			System.out.println("Erro ao executar transação: " + erro.getMessage());
			throw new HibernateException(erro);
			}
		finally{
			try{ sessao.close(); }
			catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
		}
	}
