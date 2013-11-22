package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Estadio;

public class EstadioDao extends HibernateDAO{

	public String buscarEstadio(String estadio){
		Query consulta;
		Estadio resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Estadio e where e.nomeCompleto = :n");
			consulta.setString("n", estadio);

			resultado = (Estadio) consulta.uniqueResult();
			
			if(resultado==null){
				resultado = new Estadio();
				resultado.setNomeCompleto(estadio);
			}
			return resultado.getGuidCidade();

		}catch(HibernateException erro){
				System.out.println("Erro ao executar transa��o: " + erro.getMessage());
				throw new HibernateException(erro);
			}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estadio> listaEstadio(){
		Query consulta;
		List<Estadio> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Estadio");
			resultado = consulta.list();
			return resultado;
			
		}catch(HibernateException erro){
				System.out.println("Erro ao executar transa��o: " + erro.getMessage());
				throw new HibernateException(erro);
			}
		
		finally{
				try{ sessao.close(); }
				catch(Throwable erro){ System.out.println("Erro ao fechar a sessao");}
			}
	}
}
