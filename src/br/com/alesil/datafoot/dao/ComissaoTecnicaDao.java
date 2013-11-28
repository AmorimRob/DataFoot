package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.ComissaoTecnica;

public class ComissaoTecnicaDao extends HibernateDAO{

	@SuppressWarnings("unchecked")
	public List<ComissaoTecnica> listarComissao(String nome, String guidClube, String guidFuncao){
		Query consulta;
		List<ComissaoTecnica> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from ComissaoTecnica ct where ct.apelido like :n AND ct.guidClube like :gc AND ct.guidFuncao like :gf");
			consulta.setString("n", nome + "%");
			consulta.setString("gc", guidClube + "%");
			consulta.setString("gf", guidFuncao + "%");
			
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
	
	public ComissaoTecnica buscarComissao(String guidComissao){
		Query consulta;
		ComissaoTecnica resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
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
			sessao = HibernateUtil.getSessionFactory().openSession();
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
}
