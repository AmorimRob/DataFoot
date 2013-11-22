package br.com.alesil.datafoot.ctrl;

import java.util.List;
import java.util.UUID;

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
	
	public List<Posicao>listaPosicao;

	public PosicaoCtrl() {
		this.posicao = new Posicao();
		this.dao = new PosicaoDao();
		this.operacao = new CtrlPadrao();
	}

	public void salvar (){
		if(posicao.getGuidPosicao() == null){
			posicao.setGuidPosicao(dao.buscarPosicao(posicao.getNome_posicao()));
			
			if(posicao.getGuidPosicao() != null){	
				operacao.exibeMensagem("FormPosicao", "Posição já cadastrada na base de dados.");	
				
			}else {
				posicao.setGuidPosicao(UUID.randomUUID().toString());
				operacao.salvar(posicao, dao, "FormPosicao");
			}
		} else {
			operacao.salvar(posicao, dao, "FormPosicao");
		}
	}
	
	public void excluir (){
		operacao.excluir(posicao, dao, "FormPosicao");
	}
	
	public void consultar(){
		listaPosicao = dao.listaPosicao();
	}

	//Gets e Sets
	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public List<Posicao> getListaPosicao() {
		return listaPosicao;
	}

	public void setListaPosicao(List<Posicao> listaPosicao) {
		this.listaPosicao = listaPosicao;
	}


}
