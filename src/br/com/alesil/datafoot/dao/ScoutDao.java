package br.com.alesil.datafoot.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ScoutDao extends HibernateDAO{
	public String buscarEsquemaPorJogo(String guidJogo){
		Query consulta;
		String resultado;
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("Select sc.guidEsquemaTatico FROM Scout sc WHERE sc.guidJogo = :gj");
			consulta.setString("gj", guidJogo);
			resultado = (String) consulta.uniqueResult();
			
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
