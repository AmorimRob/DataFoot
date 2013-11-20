package br.com.alesil.datafoot.ctrl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.PosicaoDao;
import br.com.alesil.datafoot.model.Atleta;
import br.com.alesil.datafoot.model.Clube;
import br.com.alesil.datafoot.model.Posicao;

@ManagedBean(name="atletasCtrl")
@ViewScoped
public class AtletaCtrl {
	private Atleta atleta;
	
	private AtletaDao dao;

	private List<Atleta> listaAtletas;
	
	private List<SelectItem>comboPosicao;
	private List<SelectItem>comboClubes;

	public AtletaCtrl() {
		this.atleta = new Atleta();
		this.dao = new AtletaDao();
	}	

	public void salvar() {
		try {
			if(atleta.getDataNasc() != null){
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
				dateFormat.format(atleta.getDataNasc());
			}
			UUID guid = new UUID(0, 20);
			atleta.setGuidAtleta(guid);
			dao.executaTransacao(atleta, 1);
			exibeMensagem("FormAtleta", "Atleta salvo/atualizado com sucesso!");
		} catch (Exception erro) {
			exibeMensagem("FormAtleta", "Erro ao salvar/atualizar, Verifique os campos de cadastro e tente novamente.");
		}

	}

	public String excluir() {
		try {
			dao.executaTransacao(atleta, 2);
			exibeMensagem("FormAtleta", "Exclusão Realizada!");
		} catch (Exception erro) {
			exibeMensagem("FormAtleta", "Erro ao Excluir!");
		}

		return null;
	}
	
	public void consultar(){
		System.out.print("passou");
		if(atleta.getGuidAtleta()!= null){
			atleta = dao.buscarAtleta(atleta.getGuidAtleta());
			
		} else if(atleta.getApelido() != null || atleta.getGuidClube() != null){
			listaAtletas = new ArrayList<Atleta>();
			listaAtletas = dao.listarAtletas(atleta.getApelido(), null, atleta.getGuidClube());
			if(listaAtletas.isEmpty()) exibeMensagem("FormAtleta", "Não foi possível localizar o atleta com os dados informados."
					+ " Verifique as informações e tente novamente.");
		} else {
			exibeMensagem("FormAtleta", "Não foi possível localizar o atleta com os dados informados."
					+ " Verifique as informações e tente novamente.");
		}
		
	}
	
	public void exibeMensagem(String form, String msn) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(msn);
		contexto.addMessage(form, mensagem);
	}

	//Gets e Sets
	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	public List<Atleta> getListaAtletas() {
		return listaAtletas;
	}


	public void setListaAtletas(List<Atleta> listaAtletas) {
		this.listaAtletas = listaAtletas;
	}

	public List<SelectItem> getComboPosicao() {		
		List<Posicao> lista = new PosicaoDao().listaPosicao();
		comboPosicao = new ArrayList<SelectItem>();
		for (Posicao pos: lista){
			comboPosicao.add(new SelectItem(pos.getGuidPosicao(), pos.getNome_posicao()));
		}
		
		return comboPosicao;
	}


	public void setComboPosicao(List<SelectItem> comboPosicao) {
		this.comboPosicao = comboPosicao;
	}

	public List<SelectItem> getComboClubes() {
		List<Clube> lista = new ClubeDao().listaClubes();
		comboClubes = new ArrayList<SelectItem>();
		for (Clube clube: lista){
			comboClubes.add(new SelectItem(clube.getGuidClube(), clube.getNomeCurto()));
		}
		
		return comboClubes;
	}

	public void setComboClubes(List<SelectItem> comboClubes) {
		this.comboClubes = comboClubes;
	}
}
