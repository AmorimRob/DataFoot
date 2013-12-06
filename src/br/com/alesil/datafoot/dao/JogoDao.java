package br.com.alesil.datafoot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Jogo;

public class JogoDao extends HibernateDAO{

	@SuppressWarnings("unchecked")
	public List<Jogo> listaJogos(String guidCampeonato) throws ParseException{
		Query consulta;
		List<Jogo> resultado = new ArrayList<Jogo>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createSQLQuery("SELECT jogo.JG_GUID_JOGO, jogo.JG_DATA, jogo.JG_HORARIO, es.EST_APELIDO, jogo.JG_GUID_COMPETICAO, "
					.concat("cl.CL_NOME_CLUBE as mandante, jogo.JG_GOLS_MANDANTE, jogo.JG_GOLS_VISITANTE, clube.CL_NOME_CLUBE as visitante ")
					.concat("FROM df_jogo jogo ")
					.concat("LEFT JOIN df_clube cl ON jogo.JG_GUID_CLUBE_MANDANTE = cl.CL_GUID_CLUBE ")
					.concat("LEFT JOIN df_clube clube ON jogo.JG_GUID_CLUBE_VISITANTE = clube.CL_GUID_CLUBE ")
					.concat("LEFT JOIN df_estadio es ON jogo.JG_GUID_ESTADIO = es.EST_GUID_ESTADIO ")
					.concat("WHERE jogo.JG_GUID_COMPETICAO = :guidCamp"))
					.setParameter("guidCamp", guidCampeonato);
			List<Object[]>results = consulta.list();
			for(Object[] item : results){
				Jogo jogo = new Jogo();
				jogo.setGuidJogo(item[0].toString());
				jogo.setData(new SimpleDateFormat("yyyy-MM-dd").parse(item[1].toString()));
				jogo.setHorario(item[2].toString());
				jogo.setNomeEstadio(item[3].toString());
				jogo.setNomeMandante(item[5].toString());
				jogo.setGolsMandante(Integer.parseInt(item[6].toString()));
				jogo.setGolsVisitante(Integer.parseInt(item[7].toString()));
				jogo.setNomeVisitante(item[8].toString());
				
				resultado.add(jogo);
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
	
	public Jogo buscarJogo(String guidJogo){
		Query consulta;
		Jogo resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
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
	
	@SuppressWarnings("unchecked")
	public List<Jogo> jogosPorCompeticao(String guidCompeticao){
		Query consulta;
		List<Jogo> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Jogo j where j.competicao = :gc");
			consulta.setString("gc", guidCompeticao);
			
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
