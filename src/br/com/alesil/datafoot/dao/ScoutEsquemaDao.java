package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.ScoutEsquema;

public class ScoutEsquemaDao extends HibernateDAO{

	public List<ScoutEsquema> buscarScout(String guidJogo){
		Query consulta;
		List<ScoutEsquema>resultado = new ArrayList<ScoutEsquema>();;
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createSQLQuery("SELECT sce.SCE_GUID_ATLETA, atl.ATL_APELIDO, SCE_POSICAO_CAMPO, esc.ES_NUMERO "
					.concat("FROM df_scout_esquema sce ")
					.concat("LEFT JOIN df_atleta atl on atl.ATL_GUID_ATLETA = sce.SCE_GUID_ATLETA ")
					.concat("LEFT JOIN df_escalacao esc on esc.ES_GUID_ATLETA = sce.SCE_GUID_ATLETA"));
			
			List<Object[]>results = consulta.list();
			for(Object[] item : results){
				ScoutEsquema esquema = new ScoutEsquema();
				esquema.setGuidAtleta(item[0].toString());
				esquema.setNomeAtleta(item[1].toString());
				esquema.setPosicao_campo(item[2].toString());
				esquema.setNumeroAtleta(Integer.parseInt(item[3].toString()));
				resultado.add(esquema);	
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
}
