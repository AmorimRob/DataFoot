package br.com.alesil.datafoot.ctrl;

import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.CategoriaDao;
import br.com.alesil.datafoot.model.Categoria;

@ManagedBean(name="categoriaCtrl")
@ViewScoped
public class CategoriaCtrl {
	private CtrlPadrao operacao;
	private Categoria categoria;
	private CategoriaDao dao;
	
	private List<Categoria>listaCategoria;
	
	public CategoriaCtrl() {
		this.operacao = new CtrlPadrao();
		this.categoria = new Categoria();
		this.dao = new CategoriaDao();
	}
	
	public void salvar (){
		if(categoria.getGuidCategoria() == null){
			categoria.setGuidCategoria(dao.buscarCategoria(categoria.getNomeCategoria()));
			if(categoria.getGuidCategoria() == null){
				categoria.setGuidCategoria(UUID.randomUUID().toString());
				operacao.salvar(categoria, dao, "FormCategoria");
			}else{
				operacao.exibeMensagem("FormCadCategoria", "Categoria ja cadastrada na base de dados.");
			}
		} else {
			operacao.salvar(categoria, dao, "FormCategoria");
		}
	}
	
	public void excluir (){
		operacao.excluir(categoria, dao, "FormCategoria");
	}
	
	public void consultar(){
		listaCategoria = dao.listaCategoria();
	}
	
//Gets e set
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
}
