package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.dao.EscalacaoDao;
import br.com.alesil.datafoot.dao.JogoDao;
import br.com.alesil.datafoot.model.Atleta;
import br.com.alesil.datafoot.model.Competicao;
import br.com.alesil.datafoot.model.Escalacao;
import br.com.alesil.datafoot.model.Jogo;

@ManagedBean(name="escalCtrl")
@ViewScoped
public class EscalacaoCtrl {
	
	private CtrlPadrao operacao;
	
	private Escalacao escalacao;
	
	private EscalacaoDao dao;
	private AtletaDao daoAtleta;
	
	private boolean mandante = true;
	
	//Listas que preenchem o PickList da escalação
	private DualListModel<Atleta>listaAtletaMandante;
	private DualListModel<Atleta>listaAtletaVisitante;
	
	private List<Atleta> source = new ArrayList<Atleta>();  
	private List<Atleta> target = new ArrayList<Atleta>();
    
    private List<Escalacao>escalMandante;
    private List<Escalacao>escalVisitante;
    
    private List<SelectItem>comboCompeticao;
    private List<SelectItem>comboJogos;
    
    private String guidCompeticao;
    private String jogoSelecionado;
    
    private String timeMandante;
    private String timeVisitante;
	
	public EscalacaoCtrl() {
		this.operacao = new CtrlPadrao();
		this.escalacao = new Escalacao();
		this.dao = new EscalacaoDao();
		this.daoAtleta = new AtletaDao();

        source = daoAtleta.listarAtletas();
        
        listaAtletaMandante = new DualListModel<Atleta>(source, target);
        listaAtletaVisitante = new DualListModel<Atleta>(source, target); 
	}
	
	public void salvar (){
		if(mandante){
			escalacao.setGuidClube(timeMandante);
			operacao.salvar(escalacao, dao, "FormClube");
		}else{
			escalacao.setGuidClube(timeVisitante);
			operacao.salvar(escalacao, dao, "FormClube");
		}
	}
	
	public void excluir (){
		if(mandante){
			escalacao.setGuidClube(timeMandante);
			operacao.excluir(escalacao, dao, "FormClube");
		}else{
			escalacao.setGuidClube(timeVisitante);
			operacao.excluir(escalacao, dao, "FormClube");
		}
		
	}
	/*
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
	
	*/
	public void onTransfer(TransferEvent event) {
		if(escalMandante== null)
			this.escalMandante = new ArrayList<Escalacao>();
		for(Object item : event.getItems()) {  
        	if(mandante){
    			escalacao.setGuidClube(timeMandante);
    		}else{
    			escalacao.setGuidClube(timeVisitante);
    		}
        	
        	escalacao.setGuidAtleta((String)item);
        	escalacao.setGuidJogo(jogoSelecionado);
        	
        	this.salvar();
        	
        	this.escalMandante.add(escalacao);
        }  

    }
	
	 public void onCellEdit(CellEditEvent event) {  
	        Object oldValue = event.getOldValue();  
	        Object newValue = event.getNewValue();  
	          
	        if(newValue != null && !newValue.equals(oldValue)) {  
	        	this.salvar();
	        }  
	    }  
	
	public void condicaoTimeMandante(){
		this.mandante = true;
	}
	
	public void condicaoTimeVisitante(){
		this.mandante = false;
	}
	
	public List<Jogo> consultarJogos(){
		if(escalMandante == null){
			//metodo de busca da escalação
		}
		return new JogoDao().jogosPorCompeticao(guidCompeticao);
	}
	
	public void setarClubes(){
		Jogo jogo = new Jogo();
		jogo = new JogoDao().buscarJogo(jogoSelecionado);
		timeMandante = jogo.getGuidClubeMandante();
		timeVisitante = jogo.getGuidClubeVisitante();
	}

	public DualListModel<Atleta> getListaAtletaMandante() {
		return listaAtletaMandante;
	}

	public void setListaAtletaMandante(DualListModel<Atleta> listaAtleta) {
		this.listaAtletaMandante = listaAtleta;
	}

	public List<Escalacao> getEscalMandante() {
		return escalMandante;
	}

	public void setEscalMandante(List<Escalacao> escalMandante) {
		this.escalMandante = escalMandante;
	}

	public List<Escalacao> getEscalVisitante() {
		return escalVisitante;
	}

	public void setEscalVisitante(List<Escalacao> escalVisitante) {
		this.escalVisitante = escalVisitante;
	}

	public List<SelectItem> getComboCompeticao() {
		try{
			List<Competicao> lista = new CompeticaoDao().comboCompeticao();
			comboCompeticao = new ArrayList<SelectItem>();
			for (Competicao comp : lista){
				comboCompeticao.add(new SelectItem(comp.getGuidCompeticao(), comp.getNomeCompeticao()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormJogo", "Problemas de conexão com banco");
		}
		return comboCompeticao;
	}

	public void setComboCompeticao(List<SelectItem> comboCompeticao) {
		this.comboCompeticao = comboCompeticao;
	}

	public List<SelectItem> getComboJogos() {
		try{
			List<Jogo> lista = consultarJogos();
			comboJogos = new ArrayList<SelectItem>();
			for (Jogo jogo : lista){
				comboJogos.add(new SelectItem(jogo.getGuidJogo(), jogo.getGuidClubeVisitante()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormJogo", "Problemas de conexão com banco");
		}
		return comboJogos;
	}

	public void setComboJogos(List<SelectItem> comboJogos) {
		this.comboJogos = comboJogos;
	}

	public String getGuidCompeticao() {
		return guidCompeticao;
	}

	public void setGuidCompeticao(String guidCompeticao) {
		this.guidCompeticao = guidCompeticao;
	}

	public String getJogoSelecionado() {
		return jogoSelecionado;
	}

	public void setJogoSelecionado(String jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

	public DualListModel<Atleta> getListaAtletaVisitante() {
		return listaAtletaVisitante;
	}

	public void setListaAtletaVisitante(DualListModel<Atleta> listaAtletaVisitante) {
		this.listaAtletaVisitante = listaAtletaVisitante;
	}

	public Escalacao getEscalacao() {
		return escalacao;
	}

	public void setEscalacao(Escalacao escalacao) {
		this.escalacao = escalacao;
	}


}
