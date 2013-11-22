package br.com.alesil.datafoot.ctrl;

import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.CidadeDao;
import br.com.alesil.datafoot.model.Cidade;

@ManagedBean(name="cidadeCtrl")
@ViewScoped	
public class CidadeCtrl {
	public CtrlPadrao operacao;
	public Cidade cidade;
	public CidadeDao dao;
	
	public CidadeCtrl() {
		this.operacao = new CtrlPadrao();
		this.cidade = new Cidade();
		this.dao = new CidadeDao();
	}
	
	public void salvar (){
		cidade.setGuidCidade(dao.buscarCidade(cidade.getNomeCidade()));
		
		if(cidade.getGuidCidade() != null){	
			operacao.exibeMensagem("FormPosicao", "Cidade já cadastrada na base de dados.");	
			
		}else {
			cidade.setGuidCidade(UUID.randomUUID().toString());
			operacao.salvar(cidade, dao, "FormCidade");
		}
	}
	
	public void excluir (){
		operacao.excluir(cidade, dao, "FormCidade");
	}

	//Gets e Sets
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
}
