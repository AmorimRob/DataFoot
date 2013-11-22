package br.com.alesil.datafoot.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import br.com.alesil.datafoot.model.FuncaoComissaoTecnica;

public class FuncaoComissaoTecnicaDao extends HibernateDAO{
	
	public String buscarFuncao(String funcao){
		Query consulta;
		FuncaoComissaoTecnica resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from FuncaoComissaoTecnica c where c.nomeFuncao = :n");
			consulta.setString("n", funcao);

			resultado = (FuncaoComissaoTecnica) consulta.uniqueResult();
			
			if(resultado==null){
				resultado = new FuncaoComissaoTecnica();
				resultado.setNomeFuncao(funcao);
			}
			return resultado.getGuidFuncao();

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
	public List<FuncaoComissaoTecnica> listaFuncoes(){
		Query consulta;
		List<FuncaoComissaoTecnica> resultado;
		
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			consulta = sessao.createQuery("from FuncaoComissaoTecnica");
			
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
