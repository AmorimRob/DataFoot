package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Cidade;

public class CidadeDao extends HibernateDAO{

	public String buscarCidade(String cidade){
		Query consulta;
		Cidade resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Cidade c where c.nomeCidade = :n");
			consulta.setString("n", cidade);

			resultado = (Cidade) consulta.uniqueResult();
			
			if(resultado==null){
				resultado = new Cidade();
				resultado.setNomeCidade(cidade);
			}
			return resultado.getGuidCidade();

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
	public List<Cidade> listaCidade(){
		Query consulta;
		List<Cidade> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Cidade");
			
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
