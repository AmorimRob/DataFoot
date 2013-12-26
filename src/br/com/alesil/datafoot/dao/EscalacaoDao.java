package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Escalacao;

public class EscalacaoDao extends HibernateDAO{
	
	public List<Escalacao> atletasPorClube(String guidClube, String guidJogo){
		Query consulta;
		List<Escalacao> resultado = new ArrayList<Escalacao>();
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createSQLQuery("SELECT e.ES_GUID_ATLETA, e.ES_NUMERO, e.ES_GUID_CLUBE, "
					.concat("atl.ATL_APELIDO, atl.ATL_FOTO ")
					.concat("FROM df_escalacao e ")
					.concat("LEFT JOIN df_atleta atl on e.ES_GUID_ATLETA = atl.ATL_GUID_ATLETA ")
					.concat("LEFT JOIN df_clube cl on e.ES_GUID_CLUBE = CL_GUID_CLUBE ")
					.concat("WHERE e.ES_GUID_CLUBE = :gc AND e.ES_GUID_JOGO = :gj"))
					.setParameter("gc", guidClube)
					.setParameter("gj", guidJogo);
			
			List<Object[]>results = consulta.list();
			for(Object[] item : results){
				Escalacao escal = new Escalacao();
				escal.setGuidAtleta(item[0].toString());
				escal.setNumero(Integer.parseInt(item[1].toString()));
				escal.setGuidClube(item[2].toString());
				escal.setNomeAtleta(item[3].toString());
				escal.setFotoAtleta((byte[])item[4]);
				
				resultado.add(escal);
			}
			
			return resultado;
			
		} catch (HibernateException erro) {
				System.out.println("Erro ao executar transação: "
						+ erro.getMessage());
				throw new HibernateException(erro);
		}

		finally {
			try {
				sessao.close();
			} catch (Throwable erro) {
				System.out.println("Erro ao fechar a sessao");
			}
		}
	}
	
	public void excluirPorGuids(String guidAtleta, String guidJogo, String guidClube){
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query consulta = sessao.createSQLQuery("DELETE FROM df_escalacao WHERE ES_GUID_ATLETA = :ga AND ES_GUID_JOGO = :gj AND ES_GUID_CLUBE = :gc")
					.setParameter("ga", guidAtleta)
					.setParameter("gj", guidAtleta)
					.setParameter("gc", guidAtleta);
			consulta.executeUpdate();
		} catch (HibernateException erro) {
				System.out.println("Erro ao executar transação: "
						+ erro.getMessage());
				throw new HibernateException(erro);
		}

		finally {
			try {
				sessao.close();
			} catch (Throwable erro) {
				System.out.println("Erro ao fechar a sessao");
			}
		}
	}
}
