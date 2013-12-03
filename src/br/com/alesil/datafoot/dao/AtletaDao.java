package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Atleta;


public class AtletaDao extends HibernateDAO {
	@SuppressWarnings("unchecked")
	public List<Atleta> pesquisarAtletas(String nome, String categoria, String guidClube){
		List<Atleta> resultado = new ArrayList<Atleta>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();		
			Query query  = sessao.createSQLQuery("SELECT atl.ATL_GUID_ATLETA, atl.ATL_NOME,  atl.ATL_APELIDO, cl.CL_NOME_CLUBE, "
							.concat("POS_NOME_POSICAO, atl.ATL_GUID_CLUBE FROM df_atleta atl ") 
							.concat("LEFT JOIN df_posicao pos ON atl.ATL_GUID_POSICAO_ORIGINAL = pos.POS_GUID_POSICAO ") 
							.concat("LEFT JOIN df_clube cl ON atl.ATL_GUID_CLUBE = cl.CL_GUID_CLUBE ")
							.concat("WHERE atl.ATL_APELIDO LIKE :ap AND atl.ATL_GUID_CLUBE LIKE :gc"))
							.setParameter("ap", nome.concat("%"))
							.setParameter("gc", guidClube.concat("%"));
			
			List<Object[]> result = query.list();
					
			for(Object[] item : result){
				Atleta atl = new Atleta();
				atl.setGuidAtleta(item[0].toString());
				atl.setNome(item[1].toString());
				atl.setApelido(item[2].toString());
				atl.setNomeClube(item[3].toString());
				atl.setNome_posicao(item[4].toString());
				
				resultado.add(atl);
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
	
	public Atleta buscarAtletaPorGuid(String guidAtleta){
		Query consulta;
		Atleta resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Atleta a where a.guidAtleta = :ga");
			consulta.setString("ga", guidAtleta);

			
			resultado = (Atleta) consulta.uniqueResult();
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
		Atleta resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Atleta a where a.guidAtleta = :ga");
			consulta.setString("ga", guid);

			
			resultado = (Atleta) consulta.uniqueResult();
			return resultado.getFoto();
			
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
	public List<Atleta> listarAtletas(){		
		Query consulta;
		List<Atleta> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Atleta");
			
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
