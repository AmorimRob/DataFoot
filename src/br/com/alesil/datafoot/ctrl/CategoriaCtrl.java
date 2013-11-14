package br.com.alesil.datafoot.ctrl;

import br.com.alesil.datafoot.dao.CategoriaDao;
import br.com.alesil.datafoot.model.Categoria;

public class CategoriaCtrl {
	public CtrlPadrao operacao;
	public Categoria categoria;
	public CategoriaDao dao;
	
	public CategoriaCtrl() {
		this.operacao = new CtrlPadrao();
		this.categoria = new Categoria();
		this.dao = new CategoriaDao();
	}
	
	public void salvar (){
		operacao.salvar(categoria, dao, "FormCategoria");
	}
	
	public void excluir (){
		operacao.excluir(categoria, dao, "FormCategoria");
	}
	
//Gets e set
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
