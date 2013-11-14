package br.com.alesil.datafoot.ctrl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.PosicaoDao;
import br.com.alesil.datafoot.model.Posicao;

@ManagedBean(name="posicaoCtrl")
@ViewScoped
public class PosicaoCtrl {
	public CtrlPadrao operacao;
	private Posicao posicao;
	private PosicaoDao dao;

	public PosicaoCtrl() {
		this.posicao = new Posicao();
		this.dao = new PosicaoDao();
	}

	public void salvar (){
		operacao.salvar(posicao, dao, "FormPosicao");
	}
	
	public void excluir (){
		operacao.excluir(posicao, dao, "FormPosicao");
	}

	//Gets e Sets
	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}


}
