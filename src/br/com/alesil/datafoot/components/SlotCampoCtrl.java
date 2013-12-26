package br.com.alesil.datafoot.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.event.DragDropEvent;

import br.com.alesil.datafoot.ctrl.CtrlPadrao;
import br.com.alesil.datafoot.dao.EsquemaDao;
import br.com.alesil.datafoot.dao.ScoutDao;
import br.com.alesil.datafoot.dao.ScoutEsquemaDao;
import br.com.alesil.datafoot.model.Escalacao;
import br.com.alesil.datafoot.model.Esquema;
import br.com.alesil.datafoot.model.ScoutEsquema;

@ManagedBean(name = "slotCtrl")
@ViewScoped
public class SlotCampoCtrl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CtrlPadrao operacao; 
	private Escalacao atleta;
	private ScoutEsquema scoutEsquema;
	private SlotCampo slotCampo;
	
	private Esquema esquema;
	private List<SelectItem>comboEsquema;

	public SlotCampoCtrl(){
		this.operacao = new CtrlPadrao(); 
		this.slotCampo = new SlotCampo();
		this.scoutEsquema = new ScoutEsquema();
		this.esquema = new Esquema();
	}
	
	public void salvar() {
		operacao.salvar(scoutEsquema, new ScoutEsquemaDao(), "FormScout");
	}
	
	public void onDrop(DragDropEvent event) {
		atleta = (Escalacao) event.getData();

		SlotCampoAux aux = new SlotCampoAux();
		aux.setNome(atleta.getNomeAtleta());
		aux.setNumero(atleta.getNumero());
		aux.setGuidAtleta(atleta.getGuidAtleta());
		aux.setPosicao_campo(event.getDropId());

		this.setarNoCampo(aux);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		String guidScout = (String) sessao.getAttribute("guidScout");
	
		scoutEsquema.setGuidAtleta(atleta.getGuidAtleta());
		scoutEsquema.setGuidClube(atleta.getGuidClube());
		scoutEsquema.setGuidEsquema(esquema.getGuidesquema());
		scoutEsquema.setGuidScout(guidScout);
		scoutEsquema.setPosicao_campo(event.getDropId());

		this.salvar();

	}

	public void buscarScout() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		String jogoSelecionado = (String) sessao.getAttribute("jogoSelecionado");
		
		this.selecionaEsquema(new ScoutDao().buscarEsquemaPorJogo(jogoSelecionado)); 
		List<ScoutEsquema> scoutEsquema = new ScoutEsquemaDao().buscarScout(jogoSelecionado);
		for (ScoutEsquema item : scoutEsquema) {
			SlotCampoAux aux = new SlotCampoAux();
			aux.setNome(item.getNomeAtleta());
			aux.setNumero(item.getNumeroAtleta());
			aux.setPosicao_campo(item.getPosicao_campo());
			aux.setGuidAtleta(item.getGuidAtleta());
			
			this.setarNoCampo(aux);
		}

	}

	public void setarNoCampo(SlotCampoAux aux) {
		switch (aux.getPosicao_campo()) {
		case "a1":
			slotCampo.setA1(aux);
			break;

		case "b1":
			slotCampo.setB1(aux);
			break;

		case "c1":
			slotCampo.setC1(aux);
			break;

		case "a2":
			slotCampo.setA2(aux);
			break;

		case "b2":
			slotCampo.setB2(aux);
			break;

		case "c2":
			slotCampo.setC2(aux);
			break;

		case "a3":
			slotCampo.setA3(aux);
			break;

		case "b3":
			slotCampo.setB3(aux);
			break;

		case "c3":
			slotCampo.setC3(aux);
			break;

		case "d3":
			slotCampo.setD3(aux);
			break;

		case "e3":
			slotCampo.setE3(aux);
			break;

		case "a4":
			slotCampo.setA4(aux);
			break;

		case "b4":
			slotCampo.setB4(aux);
			break;

		case "c4":
			slotCampo.setC4(aux);
			break;

		case "a5":
			slotCampo.setA5(aux);
			break;

		case "b5":
			slotCampo.setB5(aux);
			break;

		case "c5":
			slotCampo.setC5(aux);
			break;

		case "a6":
			slotCampo.setA6(aux);
			break;

		case "b6":
			slotCampo.setB6(aux);
			break;

		case "c6":
			slotCampo.setC6(aux);
			break;

		case "b7":
			slotCampo.setB7(aux);
			break;
		}
	}
	
	public void selecionarEsquema(){
		this.selecionaEsquema(this.esquema.getGuidesquema());
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		@SuppressWarnings("unused")
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		contexto.getExternalContext().getSessionMap().put("esquema", this.esquema.getGuidesquema());
	}
	
	public void selecionaEsquema(String guidEsquema){
		Esquema esq = new EsquemaDao().pesquisarPorEsquema(guidEsquema);
			if(esq.getA1().equals("1"))
				esquema.setA1("visible");
			else if(esq.getA1().equals("0"))
				esquema.setA1("hidden");
			
			if(esq.getB1().equals("1"))
				esquema.setB1("visible");
			else if(esq.getB1().equals("0"))
				esquema.setB1("hidden");
			
			if(esq.getC1().equals("1"))
				esquema.setC1("visible");
			else if(esq.getC1().equals("0"))
				esquema.setC1("hidden");
			
			if(esq.getA2().equals("1"))
				esquema.setA2("visible");
			else if(esq.getA2().equals("0"))
				esquema.setA2("hidden");
			
			if(esq.getB2().equals("1"))
				esquema.setB2("visible");
			else if(esq.getB2().equals("0"))
				esquema.setB2("hidden");
			
			if(esq.getC2().equals("1"))
				esquema.setC2("visible");
			else if(esq.getC2().equals("0"))
				esquema.setC2("hidden");
			
			if(esq.getA3().equals("1"))
				esquema.setA3("visible");
			else if(esq.getA3().equals("0"))
				esquema.setA3("hidden");
			
			if(esq.getB3().equals("1"))
				esquema.setB3("visible");
			else if(esq.getB3().equals("0"))
				esquema.setB3("hidden");
			
			if(esq.getC3().equals("1"))
				esquema.setC3("visible");
			else if(esq.getC3().equals("0"))
				esquema.setC3("hidden");
			
			if(esq.getD3().equals("1"))
				esquema.setD3("visible");
			else if(esq.getD3().equals("0"))
				esquema.setD3("hidden");
			
			if(esq.getE3().equals("1"))
				esquema.setE3("visible");
			else if(esq.getE3().equals("0"))
				esquema.setE3("hidden");
			
			if(esq.getA4().equals("1"))
				esquema.setA4("visible");
			else if(esq.getA4().equals("0"))
				esquema.setA4("hidden");
			
			if(esq.getB4().equals("1"))
				esquema.setB4("visible");
			else if(esq.getB4().equals("0"))
				esquema.setB4("hidden");
			
			if(esq.getC4().equals("1"))
				esquema.setC4("visible");
			else if(esq.getC4().equals("0"))
				esquema.setC4("hidden");
			
			if(esq.getA5().equals("1"))
				esquema.setA5("visible");
			else if(esq.getA5().equals("0"))
				esquema.setA5("hidden");
			
			if(esq.getB5().equals("1"))
				esquema.setB5("visible");
			else if(esq.getB5().equals("0"))
				esquema.setB5("hidden");
			
			if(esq.getC5().equals("1"))
				esquema.setC5("visible");
			else if(esq.getC5().equals("0"))
				esquema.setC5("hidden");
			
			if(esq.getA6().equals("1"))
				esquema.setA6("visible");
			else if(esq.getA6().equals("0"))
				esquema.setA6("hidden");
			
			if(esq.getB6().equals("1"))
				esquema.setB6("visible");
			else if(esq.getB6().equals("0"))
				esquema.setB6("hidden");
			
			if(esq.getC6().equals("1"))
				esquema.setC6("visible");
			else if(esq.getC6().equals("0"))
				esquema.setC6("hidden");
	}


	public SlotCampo getSlotCampo() {
		return slotCampo;
	}

	public void setSlotCampo(SlotCampo slotCampo) {
		this.slotCampo = slotCampo;
	}

	public Esquema getEsquema() {
		return esquema;
	}

	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}
	
	public List<SelectItem> getComboEsquema() {
		try{
			List<Esquema> lista = new EsquemaDao().listarEsquema();
			comboEsquema = new ArrayList<SelectItem>();
			for (Esquema esquema: lista){
				comboEsquema.add(new SelectItem(esquema.getGuidesquema(), esquema.getEsquema()));
			}
		}catch (Exception e){
			System.out.print(e.toString());
		}
		return comboEsquema;
	}
	public void setComboEsquema(List<SelectItem> comboEsquema) {
		this.comboEsquema = comboEsquema;
	}
}
