package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.alesil.datafoot.dao.CidadeDao;
import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.model.Cidade;
import br.com.alesil.datafoot.model.Clube;
import br.com.alesil.datafoot.model.Estadio;

@ManagedBean (name="clubeCtrl")
@ViewScoped
public class ClubeCtrl{
	private CtrlPadrao operacao;
	private Clube clube;
	private ClubeDao dao;
	
	private List<SelectItem> comboCidade;
	private List<SelectItem> comboEstadio;
	
	private List<Clube> listaClube;
	
	public ClubeCtrl() {
		this.operacao = new CtrlPadrao();
		this.clube = new Clube();
		this.dao = new ClubeDao();
	}
	
	public void salvar (){
		if(clube.getGuidClube() == null)
			clube.setGuidClube(UUID.randomUUID().toString());
		operacao.salvar(clube, dao, "FormClube");
	}
	
	public void excluir (){
		operacao.excluir(clube, dao, "FormClube");
	}
	
	public void consultar(){
		if(clube.getGuidClube()!= null){
			clube = dao.buscarClube(clube.getGuidClube());
			
		} else {
			listaClube = new ArrayList<Clube>();
			listaClube = dao.listaClube(clube.getNomeCurto(), clube.getGuidCidade(), clube.getEstado());
			if(listaClube.isEmpty()) operacao.exibeMensagem("FormComissao", "Não foi possível localizar o staff com os dados informados."
					+ " Verifique as informações e tente novamente.");
		} 
	}

	//Gets e Sets
	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public List<SelectItem> getComboCidade() {
		try{
			List<Cidade> lista = new CidadeDao().listaCidade();
			comboCidade = new ArrayList<SelectItem>();
			for (Cidade cidade: lista){
				comboCidade.add(new SelectItem(cidade.getGuidCidade(), cidade.getNomeCidade()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormClube", "Problemas de conexão com banco");
		}
		return comboCidade;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
	}

	public List<SelectItem> getComboEstadio() {
		try{
			List<Estadio> lista = new EstadioDao().listaEstadio();
			comboEstadio = new ArrayList<SelectItem>();
			for (Estadio estadio: lista){
				comboEstadio.add(new SelectItem(estadio.getGuidEstadio(), estadio.getApelido()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormClube", "Problemas de conexão com banco");
		}
		
		return comboEstadio;
	}

	public void setComboEstadio(List<SelectItem> comboEstadio) {
		this.comboEstadio = comboEstadio;
	}

	public List<Clube> getListaClube() {
		return listaClube;
	}

	public void setListaClube(List<Clube> listaClube) {
		this.listaClube = listaClube;
	}
}
