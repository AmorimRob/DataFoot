package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.model.Clube;

@ManagedBean (name="clubeCtrl")
@ViewScoped
public class ClubeCtrl{
	public CtrlPadrao operacao;
	public Clube clube = new Clube();
	public ClubeDao dao;
	
	public ClubeCtrl() {
		this.operacao = new CtrlPadrao();
		this.clube = new Clube();
		this.dao = new ClubeDao();
	}
	
	public void salvar (){
		operacao.salvar(clube, dao, "FormClube");
	}
	
	public void excluir (){
		operacao.excluir(clube, dao, "FormClube");
	}

	//Gets e Sets
	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}
}
