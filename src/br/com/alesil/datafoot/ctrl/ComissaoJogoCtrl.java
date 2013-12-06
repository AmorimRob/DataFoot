package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.com.alesil.datafoot.dao.ComissaoTecnicaDao;
import br.com.alesil.datafoot.dao.ComissaoTecnicaJogoDao;
import br.com.alesil.datafoot.dao.JogoDao;
import br.com.alesil.datafoot.model.ComissaoTecnica;
import br.com.alesil.datafoot.model.ComissaoTecnicaJogo;
import br.com.alesil.datafoot.model.Jogo;

@ManagedBean(name = "comissaoJogoCtrl")
@ViewScoped
public class ComissaoJogoCtrl {
	private CtrlPadrao operacao;
	private ComissaoTecnicaJogo comissaoJogo;
	private ComissaoTecnicaJogoDao dao;

	private boolean mandante = true;

	// Listas que preenchem o PickList da escalação
	private DualListModel<ComissaoTecnica> listaComissaoMandante;
	private DualListModel<ComissaoTecnica> listaComissaoVisitante;

	private List<ComissaoTecnica> source = new ArrayList<ComissaoTecnica>();
	private List<ComissaoTecnica> target = new ArrayList<ComissaoTecnica>();

	private List<ComissaoTecnicaJogo> comissaoMandante;
	private List<ComissaoTecnicaJogo> comissaoVisitante;

	private String jogoSelecionado;

	private String timeMandante;
	private String timeVisitante;

	public ComissaoJogoCtrl() {
		this.operacao = new CtrlPadrao();
		this.comissaoJogo = new ComissaoTecnicaJogo();
		this.dao = new ComissaoTecnicaJogoDao();

		this.listaComissaoMandante = new DualListModel<ComissaoTecnica>(source,
				target);
		this.listaComissaoVisitante = new DualListModel<ComissaoTecnica>(
				source, target);

	}

	public void salvarMandante() {

		for (ComissaoTecnicaJogo item : comissaoMandante) {
			item.setGuidClube(timeMandante);
			operacao.salvar(item, dao, "FormClube");
		}
	}

	public void salvarVisitante() {

		for (ComissaoTecnicaJogo item : comissaoVisitante) {
			item.setGuidClube(timeVisitante);
			operacao.salvar(item, dao, "FormClube");

		}
	}

	public void excluir() {
		/*
		 * if(mandante){ escalacao.setGuidClube(timeMandante);
		 * operacao.excluir(escalacao, dao, "FormClube"); }else{
		 * escalacao.setGuidClube(timeVisitante); operacao.excluir(escalacao,
		 * dao, "FormClube"); }
		 */
	}

	public void onTransfer(TransferEvent event) {
		if (mandante) {
			comissaoJogo.setGuidClube(timeMandante);
			if (comissaoMandante == null)
				this.comissaoMandante = new ArrayList<ComissaoTecnicaJogo>();
			for (Object item : event.getItems()) {
				comissaoJogo.setGuidFuncao(((ComissaoTecnica) item).getGuidFuncao());
				comissaoJogo.setGuidJogo(jogoSelecionado);
				comissaoJogo.setGuidComissaoTecnica(((ComissaoTecnica) item).getGuidComissaoTecnica());
				comissaoJogo.setNomeStaff(((ComissaoTecnica) item).getApelido());
				comissaoJogo.setNomeFuncao(((ComissaoTecnica) item).getNomeFuncao());

				if (event.isAdd()) {
					ComissaoTecnicaJogo clone = new ComissaoTecnicaJogo(
							comissaoJogo);
					this.comissaoMandante.add(clone);
				} else if (event.isRemove())
					this.comissaoMandante.remove(comissaoJogo);
			}

		} else {
			comissaoJogo.setGuidClube(timeVisitante);
			if (comissaoVisitante == null)
				this.comissaoVisitante = new ArrayList<ComissaoTecnicaJogo>();
			for (Object item : event.getItems()) {
				comissaoJogo.setGuidFuncao(((ComissaoTecnica) item).getGuidFuncao());
				comissaoJogo.setGuidJogo(jogoSelecionado);
				comissaoJogo.setGuidComissaoTecnica(((ComissaoTecnica) item).getGuidComissaoTecnica());
				comissaoJogo.setNomeStaff(((ComissaoTecnica) item).getApelido());
				comissaoJogo.setNomeFuncao(((ComissaoTecnica) item).getNomeFuncao());

				if (event.isAdd()) {
					ComissaoTecnicaJogo clone = new ComissaoTecnicaJogo(
							comissaoJogo);
					this.comissaoVisitante.add(clone);
				} else if (event.isRemove())
					this.comissaoVisitante.remove(comissaoJogo);
			}
		}
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			// this.escalacao.setNumero((int)newValue);
		}
	}

	public void condicaoTimeMandante() {
		this.mandante = true;
	}

	public void condicaoTimeVisitante() {
		this.mandante = false;
	}

	public void setarClubes() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		jogoSelecionado = (String) sessao.getAttribute("jogoselcionado");

		Jogo jogo = new Jogo();
		jogo = new JogoDao().buscarJogo(jogoSelecionado);
		timeMandante = jogo.getGuidClubeMandante();
		timeVisitante = jogo.getGuidClubeVisitante();

		listaComissaoMandante = new DualListModel<ComissaoTecnica>(
				new ComissaoTecnicaDao().pesquisarComissaoPorClube(timeMandante),
				target);
		listaComissaoVisitante = new DualListModel<ComissaoTecnica>(
				new ComissaoTecnicaDao().pesquisarComissaoPorClube(timeVisitante),
				target);
	}

	// Gets e Sets
	public ComissaoTecnicaJogo getComissaoJogo() {
		return comissaoJogo;
	}

	public void setComissaoJogo(ComissaoTecnicaJogo comissaoJogo) {
		this.comissaoJogo = comissaoJogo;
	}

	public DualListModel<ComissaoTecnica> getListaComissaoMandante() {
		return listaComissaoMandante;
	}

	public void setListaComissaoMandante(
			DualListModel<ComissaoTecnica> listaComissaoMandante) {
		this.listaComissaoMandante = listaComissaoMandante;
	}

	public DualListModel<ComissaoTecnica> getListaComissaoVisitante() {
		return listaComissaoVisitante;
	}

	public void setListaComissaoVisitante(
			DualListModel<ComissaoTecnica> listaComissaoVisitante) {
		this.listaComissaoVisitante = listaComissaoVisitante;
	}

	public String getJogoSelecionado() {
		return jogoSelecionado;
	}

	public void setJogoSelecionado(String jogoSelecionado) {
		this.jogoSelecionado = jogoSelecionado;
	}

	public List<ComissaoTecnicaJogo> getComissaoMandante() {
		return comissaoMandante;
	}

	public void setComissaoMandante(List<ComissaoTecnicaJogo> comissaoMandante) {
		this.comissaoMandante = comissaoMandante;
	}

	public List<ComissaoTecnicaJogo> getComissaoVisitante() {
		return comissaoVisitante;
	}

	public void setComissaoVisitante(List<ComissaoTecnicaJogo> comissaoVisitante) {
		this.comissaoVisitante = comissaoVisitante;
	}

}
