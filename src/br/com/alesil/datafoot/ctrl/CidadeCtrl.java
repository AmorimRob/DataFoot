package br.com.alesil.datafoot.ctrl;

import java.util.List;
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
	
	private List<Cidade>listaCidade;
	
	public CidadeCtrl() {
		this.operacao = new CtrlPadrao();
		this.cidade = new Cidade();
		this.dao = new CidadeDao();
	}
	
	public void salvar (){
		cidade.setGuidCidade(dao.buscarCidade(cidade.getNomeCidade()));
		
		if(cidade.getGuidCidade() != null){	
			operacao.exibeMensagem("FormCidade", "Cidade já cadastrada na base de dados.");	
			
		}else {
			cidade.setGuidCidade(UUID.randomUUID().toString());
			operacao.salvar(cidade, dao, "FormCidade");
		}
	}
	
	public void excluir (){
		operacao.excluir(cidade, dao, "FormCidade");
	}
	
	public void consultar(){
		listaCidade = dao.listaCidade();
	}

	//Gets e Sets
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}
}
