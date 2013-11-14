package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.model.Competicao;

@ManagedBean(name="compCtrl")
@ViewScoped
public class CompeticaoCtrl {
	public CtrlPadrao operacao;
	public Competicao competicao;
	public CompeticaoDao dao;
	
	public CompeticaoCtrl() {
		this.operacao = new CtrlPadrao();
		this.competicao = new Competicao();
		this.dao = new CompeticaoDao();
	}
	
	public void salvar (){
		operacao.salvar(competicao, dao, "FormCompeticao");
	}
	
	public void excluir (){
		operacao.excluir(competicao, dao, "FormCompeticao");
	}

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}


}
