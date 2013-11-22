package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Categoria;

public class CategoriaDao extends HibernateDAO{
	
	public String buscarCategoria(String categoria){
		Query consulta;
		Categoria resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Categoria c where c.nomeCategoria = :n");
			consulta.setString("n", categoria);

			resultado = (Categoria) consulta.uniqueResult();
			
			if(resultado==null){
				resultado = new Categoria();
				resultado.setNomeCategoria(categoria);
			}
			return resultado.getGuidCategoria();

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
	public List<Categoria> listaCategoria(){
		Query consulta;
		List<Categoria> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Categoria");
			
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
