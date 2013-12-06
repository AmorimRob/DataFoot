package br.com.alesil.datafoot.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.ComissaoTecnica;

public class ComissaoTecnicaDao extends HibernateDAO{

	@SuppressWarnings("unchecked")
	public List<ComissaoTecnica> pesquisarComissao(String nome, String guidClube, String guidFuncao){
		List<ComissaoTecnica> resultado = new ArrayList<ComissaoTecnica>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query query = sessao.createSQLQuery("SELECT com.CT_GUID_COMISSAO_TECNICA, com.CT_GUID_CLUBE, com.CT_GUID_FUNCAO, "
					.concat("com.CT_NOME, com.CT_APELIDO, cl.CL_NOME_CLUBE FROM df_comissao_tecnica com ")
					.concat("LEFT JOIN df_clube cl ON com.CT_GUID_CLUBE = cl.CL_GUID_CLUBE ")
					.concat("WHERE com.CT_APELIDO LIKE :ap AND com.CT_GUID_CLUBE LIKE :gc AND com.CT_GUID_FUNCAO LIKE :gf"))
					.setParameter("ap", nome.concat("%"))
					.setParameter("gc", guidClube.concat("%"))
					.setParameter("gf", guidFuncao.concat("%"));
			
			List<Object[]> result = query.list();
			
			for (Object[] item : result){
				ComissaoTecnica ct = new ComissaoTecnica();
				ct.setGuidComissaoTecnica(item[0].toString());
				ct.setGuidClube(item[1].toString());
				ct.setGuidFuncao(item[2].toString());
				ct.setNome(item[3].toString());
				ct.setApelido(item[4].toString());
				if(item[5] != null)
					ct.setNomeClube(item[5].toString());
				
				resultado.add(ct);
			}
			//resultado = consulta.list();
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
	
	public ComissaoTecnica buscarComissao(String guidComissao){
		Query consulta;
		ComissaoTecnica resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from ComissaoTecnica ct where ct.guidComissaoTecnica = :gc");
			consulta.setString("gc", guidComissao);
			
			resultado = (ComissaoTecnica) consulta.uniqueResult();
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
		ComissaoTecnica resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from ComissaoTecnica c where c.guidComissaoTecnica = :gc");
			consulta.setString("gc", guid);

			
			resultado = (ComissaoTecnica) consulta.uniqueResult();
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
	
	public List<ComissaoTecnica> pesquisarComissaoPorClube(String guidClube){
		List<ComissaoTecnica> resultado = new ArrayList<ComissaoTecnica>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query query = sessao.createSQLQuery("SELECT com.CT_GUID_COMISSAO_TECNICA, com.CT_GUID_CLUBE, com.CT_GUID_FUNCAO, "
					.concat("com.CT_APELIDO, fct.FCT_NOME_FUNCAO FROM df_comissao_tecnica com ")
					.concat("LEFT JOIN df_clube cl ON com.CT_GUID_CLUBE = cl.CL_GUID_CLUBE ")
					.concat("LEFT JOIN df_funcao_comissao_tecnica fct ON com.CT_GUID_FUNCAO = fct.FCT_GUID_FUNCAO ")
					.concat("WHERE com.CT_GUID_CLUBE = :gc"))
					.setParameter("gc", guidClube);

			
			@SuppressWarnings("unchecked")
			List<Object[]> result = query.list();
			
			for (Object[] item : result){
				ComissaoTecnica ct = new ComissaoTecnica();
				ct.setGuidComissaoTecnica(item[0].toString());
				ct.setGuidClube(item[1].toString());
				ct.setGuidFuncao(item[2].toString());
				ct.setApelido(item[3].toString());
				ct.setNomeFuncao(item[4].toString());
								
				resultado.add(ct);
			}
			//resultado = consulta.list();
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
	
	public List<ComissaoTecnica> listarComissao(){
		List<ComissaoTecnica> resultado = new ArrayList<ComissaoTecnica>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query query = sessao.createSQLQuery("SELECT com.CT_GUID_COMISSAO_TECNICA, com.CT_GUID_CLUBE, com.CT_GUID_FUNCAO, "
					.concat("com.CT_APELIDO, fct.FCT_NOME_FUNCAO FROM df_comissao_tecnica com ")
					.concat("LEFT JOIN df_clube cl ON com.CT_GUID_CLUBE = cl.CL_GUID_CLUBE ")
					.concat("LEFT JOIN df_funcao_comissao_tecnica fct ON com.CT_GUID_FUNCAO = fct.FCT_GUID_FUNCAO "));

			
			@SuppressWarnings("unchecked")
			List<Object[]> result = query.list();
			
			for (Object[] item : result){
				ComissaoTecnica ct = new ComissaoTecnica();
				ct.setGuidComissaoTecnica(item[0].toString());
				ct.setGuidClube(item[1].toString());
				ct.setGuidFuncao(item[2].toString());
				ct.setApelido(item[3].toString());
				ct.setNomeFuncao(item[4].toString());
								
				resultado.add(ct);
			}
			//resultado = consulta.list();
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
