package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.model.Estadio;

@ManagedBean(name="estadioCtrl")
@ViewScoped
public class EstadioCtrl {
	public CtrlPadrao operacao;
	public Estadio estadio;
	public EstadioDao dao;
	
	public EstadioCtrl() {
		this.operacao = new CtrlPadrao();
		this.estadio = new Estadio();
		this.dao = new EstadioDao();
	}
	
	public void salvar (){
		operacao.salvar(estadio, dao, "FormEstadio");
	}
	
	public void excluir (){
		operacao.excluir(estadio, dao, "FormEstadio");
	}

	//Gets e sets
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

}
