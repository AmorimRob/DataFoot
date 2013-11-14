package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.ComissaoTecnicaDao;
import br.com.alesil.datafoot.model.ComissaoTecnica;

@ManagedBean(name="comissaoCtrl")
@ViewScoped
public class ComissaoTecnicaCtrl {
	public CtrlPadrao operacao;
	public ComissaoTecnica comissao;
	public ComissaoTecnicaDao dao;
	
	public ComissaoTecnicaCtrl() {
		this.operacao = new CtrlPadrao();
		this.comissao = new ComissaoTecnica();
		this.dao = new ComissaoTecnicaDao();
	}
	
	public void salvar (){
		operacao.salvar(comissao, dao, "FormComissao");
	}
	
	public void excluir (){
		operacao.excluir(comissao, dao, "FormComissao");
	}

	//Gets e Sets
	public ComissaoTecnica getComissao() {
		return comissao;
	}

	public void setComissao(ComissaoTecnica comissao) {
		this.comissao = comissao;
	}
}
