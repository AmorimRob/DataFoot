package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

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
	
	//Listas que preenchem o PickList da escalação
	private DualListModel<Atleta>listaAtleta;
	private List<Atleta> source = new ArrayList<Atleta>();  
	private List<Atleta> target = new ArrayList<Atleta>();
    
    private List<Escalacao>escalMandante;
    private List<Escalacao>escalVisitante;
    
    private List<SelectItem>comboCompeticao;
    private List<SelectItem>comboJogos;
    
    private String guidCompeticao;
    private Jogo jogoSelecionado;
	
	public EscalacaoCtrl() {
		this.operacao = new CtrlPadrao();
		this.escalacao = new Escalacao();
		this.dao = new EscalacaoDao();
		this.daoAtleta = new AtletaDao();

        source = daoAtleta.listarAtletas();
        
        listaAtleta = new DualListModel<Atleta>(source, target);  
	}
	
	public void salvar (){
		operacao.salvar(escalacao, dao, "FormClube");
	}
	
	public void excluir (){
		operacao.excluir(escalacao, dao, "FormClube");
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
        for(Object item : event.getItems()) {  
        	escalacao.setGuidAtleta((String)item);
        }  

    }  
	
	public List<Jogo> consultarJogos(){
		return new JogoDao().jogosPorCompeticao(guidCompeticao);
	}
	
	public void setarClubes(){
		//campo de texto que receberá o clube mandante e clube visitante
		String mandante = jogoSelecionado.getGuidClubeMandante();
		String visitante = jogoSelecionado.getGuidClubeVisitante();
	}

	public Escalacao getEscalacao() {
		return escalacao;
	}

	public void setEscalacao(Escalacao escalacao) {
		this.escalacao = escalacao;
	}

	public DualListModel<Atleta> getListaAtleta() {
		return listaAtleta;
	}

	public void setListaAtleta(DualListModel<Atleta> listaAtleta) {
		this.listaAtleta = listaAtleta;
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
				comboJogos.add(new SelectItem(jogo, String.valueOf(jogo.getData())
						.concat(" - ")
						.concat(jogo.getGuidClubeMandante()
						.concat(" x ")
						.concat(jogo.getGuidClubeVisitante()))));
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

	public Jogo getJogoSelecionado() {
		return jogoSelecionado;
	}

	public void setJogoSelecionado(Jogo jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

}
