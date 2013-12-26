package br.com.alesil.datafoot.ctrl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

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

@ManagedBean(name = "escalCtrl")
@ViewScoped
public class EscalacaoCtrl {

	private CtrlPadrao operacao;
	private Escalacao escalacao;
	private EscalacaoDao dao;

	private boolean mandante = true;

	// Listas que preenchem o PickList da escalação
	private DualListModel<Atleta> listaAtletaMandante;
	private DualListModel<Atleta> listaAtletaVisitante;

	private List<Atleta> source = new ArrayList<Atleta>();
	private List<Atleta> targetMandante = new ArrayList<Atleta>();
	private List<Atleta> targetVisitante = new ArrayList<Atleta>();

	private List<Escalacao> escalMandante;
	private List<Escalacao> escalVisitante;

	private List<SelectItem> comboCompeticao;
	private List<SelectItem> comboJogos;

	private String guidCompeticao;
	private String jogoSelecionado;

	private String timeMandante;
	private String timeVisitante;

	public EscalacaoCtrl() {
		this.operacao = new CtrlPadrao();
		this.escalacao = new Escalacao();
		this.dao = new EscalacaoDao();

		this.listaAtletaMandante = new DualListModel<Atleta>(source, targetMandante);
		this.listaAtletaVisitante = new DualListModel<Atleta>(source, targetVisitante);
	}

	public void salvarMandante() {

		for (Escalacao item : escalMandante) {
			item.setGuidJogo(jogoSelecionado);
			item.setGuidClube(timeMandante);
			operacao.salvar(item, dao, "FormClube");
		}
	}

	public void salvarVisitante() {

		for (Escalacao item : escalVisitante) {
			item.setGuidClube(timeVisitante);
			operacao.salvar(item, dao, "FormClube");
		}
	}

	public void excluir() {
		if (mandante) {
			escalacao.setGuidClube(timeMandante);
			operacao.excluir(escalacao, dao, "FormClube");
		} else {
			escalacao.setGuidClube(timeVisitante);
			operacao.excluir(escalacao, dao, "FormClube");
		}

	}

	/*
	 * public void consultar(){ if(clube.getGuidClube()!= null){ clube =
	 * dao.buscarClube(clube.getGuidClube());
	 * 
	 * } else { listaClube = new ArrayList<Clube>(); listaClube =
	 * dao.listaClube(clube.getNomeCurto(), clube.getGuidCidade(),
	 * clube.getEstado()); if(listaClube.isEmpty())
	 * operacao.exibeMensagem("FormComissao",
	 * "Não foi possível localizar o staff com os dados informados." +
	 * " Verifique as informações e tente novamente."); } }
	 */
	public void onTransfer(TransferEvent event) {
		if (mandante) {
			escalacao.setGuidClube(timeMandante);
			if (escalMandante == null)
				this.escalMandante = new ArrayList<Escalacao>();
			for (Object item : event.getItems()) {
				escalacao.setGuidAtleta(((Atleta) item).getGuidAtleta());
				escalacao.setGuidJogo(jogoSelecionado);
				escalacao.setNomeAtleta(((Atleta) item).getNome());
				escalacao.setNumero(((Atleta) item).getNumeroPadrao());

				if (event.isAdd()) {
					Escalacao clone = new Escalacao(escalacao);
					this.escalMandante.add(clone);
				} else if (event.isRemove())
					for(int i=0; i < escalMandante.size(); i++){
						if(escalMandante.get(i).getGuidAtleta().equals(((Atleta)item).getGuidAtleta())){
							this.escalMandante.remove(i);	
							operacao.excluir(escalacao, dao, "FormClube");
						}
						
					}	
			}

		} else {
			escalacao.setGuidClube(timeVisitante);
			if (escalVisitante == null)
				this.escalVisitante = new ArrayList<Escalacao>();

			for (Object item : event.getItems()) {
				escalacao.setGuidAtleta(((Atleta) item).getGuidAtleta());
				escalacao.setGuidJogo(jogoSelecionado);
				escalacao.setNomeAtleta(((Atleta) item).getNome());
				escalacao.setNumero(((Atleta) item).getNumeroPadrao());

				if (event.isAdd()) {
					Escalacao clone = new Escalacao(escalacao);
					this.escalVisitante.add(clone);
				} else if (event.isRemove())
					for(int i=0; i < escalVisitante.size(); i++){
						if(escalVisitante.get(i).getGuidAtleta().equals(((Atleta)item).getGuidAtleta())){
							this.escalVisitante.remove(i);	
							operacao.excluir(escalacao, dao, "FormClube");
						}
					}
					
			}
		}
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			this.escalacao.setNumero((int) newValue);
		}
	}

	public void condicaoTimeMandante() {
		this.mandante = true;
	}

	public void condicaoTimeVisitante() {
		this.mandante = false;
	}

	public List<Jogo> consultarJogos() throws ParseException {
		return new JogoDao().listaJogos(guidCompeticao);
	}

	public void setarClubes() {
		Jogo jogo = new Jogo();
		jogo = new JogoDao().buscarJogo(jogoSelecionado);
		timeMandante = jogo.getGuidClubeMandante();
		timeVisitante = jogo.getGuidClubeVisitante();

		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.getExternalContext().getSessionMap().put("jogoselcionado", jogoSelecionado);
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);

//		listaAtletaMandante = new DualListModel<Atleta>(
	//			new AtletaDao().pesquisarAtletasPorClube(timeMandante), targetMandante);
		//listaAtletaVisitante = new DualListModel<Atleta>(
			//	new AtletaDao().pesquisarAtletasPorClube(timeVisitante), targetVisitante);
	}
	
	public void listaEscaladosMandante(){
		//lista jogadores ja escalados
		List<Atleta>listaNaoEscalados = new AtletaDao().pesquisarAtletasPorClube(timeMandante);
		Collections.reverse(listaNaoEscalados);
		escalMandante = new EscalacaoDao().atletasPorClube(timeMandante, jogoSelecionado);
		for(Escalacao item : escalMandante){
			Atleta atl = new Atleta();
			atl.setGuidAtleta(item.getGuidAtleta());
			atl = new AtletaDao().buscarAtletaPorGuid(atl.getGuidAtleta());
			targetMandante.add(atl);
		}
		
		List<Atleta> atletasEscalados = new ArrayList<Atleta>();
		for(Atleta item : listaNaoEscalados){
			for(Atleta item2 : targetMandante){
				if(item.getGuidAtleta().equals(item2.getGuidAtleta())){
					atletasEscalados.add(item);
				}
			}
		}
		
		for(Atleta item : atletasEscalados){
			listaNaoEscalados.remove(item);
		}
		listaAtletaMandante = new DualListModel<Atleta>(listaNaoEscalados, targetMandante);
	}
	
	public void listaEscaladosVisitante(){
		//lista jogadores ja escalados
		List<Atleta>listaNaoEscalados = new AtletaDao().pesquisarAtletasPorClube(timeVisitante);
		Collections.reverse(listaNaoEscalados);
		escalVisitante = new EscalacaoDao().atletasPorClube(timeVisitante, jogoSelecionado);
		for(Escalacao item : escalVisitante){
			Atleta atl = new Atleta();
			atl.setGuidAtleta(item.getGuidAtleta());
			atl = new AtletaDao().buscarAtletaPorGuid(atl.getGuidAtleta());
			targetVisitante.add(atl);
		}
		
		List<Atleta> atletasEscalados = new ArrayList<Atleta>();
		for(Atleta item : listaNaoEscalados){
			for(Atleta item2 : targetVisitante){
				if(item.getGuidAtleta().equals(item2.getGuidAtleta())){
					atletasEscalados.add(item);
				}
			}
		}
		
		for(Atleta item : atletasEscalados){
			listaNaoEscalados.remove(item);
		}
		listaAtletaVisitante = new DualListModel<Atleta>(listaNaoEscalados, targetVisitante);
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
		try {
			List<Competicao> lista = new CompeticaoDao().comboCompeticao();
			comboCompeticao = new ArrayList<SelectItem>();
			for (Competicao comp : lista) {
				comboCompeticao.add(new SelectItem(comp.getGuidCompeticao(),
						comp.getNomeCompeticao()));
			}
		} catch (Exception e) {
			operacao.exibeMensagem("FormJogo", "Problemas de conexão com banco");
		}
		return comboCompeticao;
	}

	public void setComboCompeticao(List<SelectItem> comboCompeticao) {
		this.comboCompeticao = comboCompeticao;
	}

	public List<SelectItem> getComboJogos() {
		try {
			List<Jogo> lista = consultarJogos();
			comboJogos = new ArrayList<SelectItem>();
			for (Jogo jogo : lista) {
				comboJogos.add(new SelectItem(jogo.getGuidJogo(), String
						.valueOf(
								new SimpleDateFormat("dd-MM-yyyy").format(jogo
										.getData())).concat(" - ")
						.concat(jogo.getNomeMandante()).concat(" x ")
						.concat(jogo.getNomeVisitante())));
			}
		} catch (Exception e) {
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

	public void setListaAtletaVisitante(
			DualListModel<Atleta> listaAtletaVisitante) {
		this.listaAtletaVisitante = listaAtletaVisitante;
	}

	public Escalacao getEscalacao() {
		return escalacao;
	}

	public void setEscalacao(Escalacao escalacao) {
		this.escalacao = escalacao;
	}

}
