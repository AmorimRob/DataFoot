package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.Posicao;

public class PosicaoDao extends HibernateDAO{

	public String buscarPosicao(String posicao){
		Query consulta;
		Posicao resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Posicao a where a.nome_posicao = :n");
			consulta.setString("n", posicao);

			resultado = (Posicao) consulta.uniqueResult();
			
			if(resultado==null){
				resultado = new Posicao();
				resultado.setNome_posicao(posicao);
			}
			return resultado.getGuidPosicao();

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
	public List<Posicao> listaPosicao(){
		Query consulta;
		List<Posicao> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from Posicao");
			
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
