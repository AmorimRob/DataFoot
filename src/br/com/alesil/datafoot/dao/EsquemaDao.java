package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Esquema;

public class EsquemaDao extends HibernateDAO {
	
	public Esquema pesquisarPorEsquema(String guidesquema){
		Query consulta;
		Esquema resultado;
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("FROM Esquema e WHERE e.guidesquema = :es");
			consulta.setParameter("es", guidesquema);
			
			resultado = (Esquema)consulta.uniqueResult();
			
			return resultado;
			
		} catch (HibernateException erro) {
			System.out.println("Erro ao executar transação: "+ erro.getMessage());
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
	
	public List<Esquema> listarEsquema(){
		Query consulta;
		List<Esquema>resultado = new ArrayList<Esquema>();
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createSQLQuery("SELECT * FROM df_esquema");
			
			@SuppressWarnings("unchecked")
			List<Object[]> results = consulta.list();
			for(Object[] item : results){
				Esquema esquema = new Esquema();
				esquema.setGuidesquema(item[0].toString());
				esquema.setEsquema(item[1].toString());
				esquema.setA1(item[2].toString());
				esquema.setB1(item[3].toString());
				esquema.setC1(item[4].toString());
				esquema.setA2(item[5].toString());
				esquema.setB2(item[6].toString());
				esquema.setC2(item[7].toString());
				esquema.setA3(item[8].toString());
				esquema.setB3(item[9].toString());
				esquema.setC3(item[10].toString());
				esquema.setD3(item[11].toString());
				esquema.setE3(item[12].toString());
				esquema.setA4(item[13].toString());
				esquema.setB4(item[14].toString());
				esquema.setC4(item[15].toString());
				esquema.setA5(item[16].toString());
				esquema.setB5(item[17].toString());
				esquema.setC5(item[18].toString());
				esquema.setA6(item[19].toString());
				esquema.setB6(item[20].toString());
				esquema.setC6(item[21].toString());
				
				resultado.add(esquema);
			}
			return resultado;
			
		} catch (HibernateException erro) {
			System.out.println("Erro ao executar transação: "+ erro.getMessage());
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
