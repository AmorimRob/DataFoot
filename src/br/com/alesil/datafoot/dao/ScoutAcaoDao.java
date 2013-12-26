package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Posicao;
import br.com.alesil.datafoot.model.ScoutAcao;

public class ScoutAcaoDao extends HibernateDAO{
	
	public List<ScoutAcao> listaOperacoes(){
		Query consulta;
		List<ScoutAcao> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from ScoutAcao");
			
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
