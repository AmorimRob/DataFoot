package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
		operacao.salvar(cidade, dao, "FormCidade");
		System.out.print("teste passou por aqui");
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
