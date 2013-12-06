package br.com.alesil.datafoot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Competicao;

public class CompeticaoDao extends HibernateDAO{
	
	@SuppressWarnings("unchecked")
	public List<Competicao>pesquisarCompeticao(String nomeComp, Date dataInicio){
		List<Competicao> resultado = new ArrayList<Competicao>();
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			Query consulta = sessao.createSQLQuery("SELECT comp.COMP_GUID_CATEGORIA, comp.COMP_NOME_COMPETICAO, "
					.concat("comp.COMP_DATA_INICIO, cat.CAT_NOME_CATEGORIA FROM df_competicao comp  ") 
					.concat("LEFT JOIN df_categoria cat ON comp.COMP_GUID_CATEGORIA = cat.CAT_GUID_CATEGORIA ")
					.concat("WHERE comp.COMP_NOME_COMPETICAO LIKE :n"))
					.setParameter("n", nomeComp.concat("%"));
			
			List<Object[]>results = consulta.list();
			for(Object[] item : results){
				Competicao comp = new Competicao();
				comp.setGuidCompeticao(item[0].toString());
				comp.setNomeCompeticao(item[1].toString());
				comp.setDataInicio(new SimpleDateFormat().parse(item[2].toString()));
				comp.setNomeCategoria(item[3].toString());
				
				resultado.add(comp);
			}
		
			return resultado;
			
		}catch(HibernateException erro){
				System.out.println("Erro ao executar transação: " + erro.getMessage());
				throw new HibernateException(erro);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}
	@SuppressWarnings("unchecked")
	public List<Competicao>comboCompeticao(){
		Query consulta;
		List<Competicao> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Competicao");

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
	
	public byte[] buscarFoto(String guid){
		
		Query consulta;
		Competicao resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory();
			consulta = sessao.createQuery("from Competicao c where c.guidCompeticao = :gc");
			consulta.setString("gc", guid);

			resultado = (Competicao) consulta.uniqueResult();
			return resultado.getLogo();
			
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
