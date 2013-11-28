package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Jogo;

public class JogoDao extends HibernateDAO{

	@SuppressWarnings("unchecked")
	public List<Jogo> listaJogos(String guidCampeonato, String clubeMandante, String guidEstadio){
		Query consulta;
		List<Jogo> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Jogo j where j.competicao like :guiCamp AND j.guidClubeMandante like :guidClube"
					+ " AND j.guidEstadio like :guidEst");
			consulta.setString("guidCamp", guidCampeonato + "%");
			consulta.setString("guidClube", clubeMandante + "%");
			consulta.setString("guidEstadio", guidEstadio + "%");
			
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
	
	public Jogo buscarJogo(String guidJogo){
		Query consulta;
		Jogo resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Jogo c where c.guidJogo= :gj");
			consulta.setString("gj", guidJogo);
			
			resultado = (Jogo) consulta.uniqueResult();
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
