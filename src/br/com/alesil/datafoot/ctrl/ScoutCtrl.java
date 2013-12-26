package br.com.alesil.datafoot.ctrl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.com.alesil.datafoot.components.CronometroCtrl;
import br.com.alesil.datafoot.components.SlotCampoAux;
import br.com.alesil.datafoot.converters.AtletaConverter;
import br.com.alesil.datafoot.converters.OcorrenciaConverter;
import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.dao.EscalacaoDao;
import br.com.alesil.datafoot.dao.JogoDao;
import br.com.alesil.datafoot.dao.ScoutAcaoDao;
import br.com.alesil.datafoot.dao.ScoutDao;
import br.com.alesil.datafoot.dao.ScoutDetalhesDao;
import br.com.alesil.datafoot.model.Atleta;
import br.com.alesil.datafoot.model.Competicao;
import br.com.alesil.datafoot.model.Escalacao;
import br.com.alesil.datafoot.model.Jogo;
import br.com.alesil.datafoot.model.Scout;
import br.com.alesil.datafoot.model.ScoutAcao;
import br.com.alesil.datafoot.model.ScoutDetalhes;

@ManagedBean(name="scoutCtrll")
@SessionScoped
public class ScoutCtrl implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CtrlPadrao operacao;
	
	private List<SelectItem>comboJogos;
	private List<SelectItem>comboCompeticao;
	
	private Scout scout;
	private ScoutDetalhes scoutDetalhes;
	private ScoutAcao acao = new ScoutAcao();

	private String guidCompeticao;
	private String jogoSelecionado;
	private String timeMandante;
	private String timeVisitante;
	
	private List<Atleta> listaAtletasMandante; 
	private List<Escalacao> listaEscalcaoMandante;
	private List<ScoutAcao>listaOperacoes;

	//listas do converter
	private List<ScoutAcao>listaAcoes;
	private List<Atleta>listaAtleta;
	
	private SlotCampoAux scoutAcao;
	private String tempoJogo;
	private String atletaSelecionado;

	public ScoutCtrl(){
		this.operacao = new CtrlPadrao();
		this.scout = new Scout();
		this.scoutDetalhes = new ScoutDetalhes();
		this.scoutAcao = new SlotCampoAux();
		
		this.listaAcoes = OcorrenciaConverter.lstAcoes;
		this.listaAtleta = AtletaConverter.lstAtleta;
	}
	
	public void salvarScoutDetalhes(ScoutDetalhes scoutDetalhes){
		scoutDetalhes.setGuidScout(scout.getGuidScout());
		if(scoutDetalhes.getGuidScoutDetalhes() == null)
			scoutDetalhes.setGuidScoutDetalhes(UUID.randomUUID().toString());		
		operacao.salvar(scoutDetalhes, new ScoutDetalhesDao(), "FormScout");
		
	}
	
	public String realizaAcao(){
		if(scoutDetalhes.getGuidAcao().isEmpty()){
			this.scoutDetalhes.setGuidAcao(acao.getGuidAcao());
		}
		if(scoutDetalhes.getAtleta().isEmpty()){
			this.scoutDetalhes.setAtleta(atletaSelecionado);
		}
		this.scoutDetalhes.setGuidClube(timeMandante);

		System.out.println("Atleta: " + scoutDetalhes.getAtleta() + " - Ação: " + scoutDetalhes.getGuidAcao()
				+ " - Time: " + scoutDetalhes.getGuidClube() + " - Tempo do jogo: " + CronometroCtrl.TEMPO_AUXILIAR);
		
		//this.salvarScoutDetalhes();
		return null;
	}
	
	public void selecionaAtleta(){		
		atletaSelecionado = scoutAcao.getGuidAtleta();

		
	}

	 public List<ScoutAcao> completarAcao(String query) {  
	        List<ScoutAcao> suggestions = new ArrayList<ScoutAcao>();  
	          
	        for(ScoutAcao item : listaAcoes) {  
	            if(item.getSigla().startsWith(query))  
	                suggestions.add(item);  
	        }  
	          
	        return suggestions;  
	    }  
	 
	 public List<Atleta> completarAtleta(String query) {  
	        List<Atleta> suggestions = new ArrayList<Atleta>();  
	          
	        for(Atleta item : listaAtleta) {  
	            if(item.getNumeroPadrao().toString().startsWith(query))  
	            	if(item.getGuidClube().equals(timeMandante))
	            		suggestions.add(item);  
	        }  
	          
	        return suggestions;  
	    }  
	 
	public void salvarScout(){
		if(scout.getGuidScout() == null)
			scout.setGuidScout(UUID.randomUUID().toString());	
		operacao.salvar(scout, new ScoutDao(), "FormScout");
	}

	public List<Jogo> consultarJogos() throws ParseException {
		return new JogoDao().listaJogos(guidCompeticao);
	}
	
	public void testeClick(){
		System.out.print("teste do click");
	}
	
	public void testeevento(){
		System.out.print(scoutAcao.getNome());
	}
	

	public void setarClubes() {
		Jogo jogo = new Jogo();
		jogo = new JogoDao().buscarJogo(jogoSelecionado);
		timeMandante = jogo.getGuidClubeMandante();
		timeVisitante = jogo.getGuidClubeVisitante();
		
		scout.setClube(timeMandante);
		scout.setGuidJogo(jogoSelecionado);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		@SuppressWarnings("unused")
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		contexto.getExternalContext().getSessionMap().put("guidScout", scout.getGuidScout());
		contexto.getExternalContext().getSessionMap().put("jogoSelecionado", jogoSelecionado);
		

	}
	
	public void inserirScout(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext().getSession(false);
		String esquema = (String) sessao.getAttribute("esquema");
		
		scout.setGuidEsquemaTatico(esquema);
		
		this.salvarScout();
	}
	
	public void listarAtletasEscalados(){
		listaEscalcaoMandante = new EscalacaoDao().atletasPorClube(timeMandante, jogoSelecionado);
	}

	public List<Atleta> getListaAtletasMandante() {
		return listaAtletasMandante;
	}

	public void setListaAtletasMandante(List<Atleta> listaAtletasMandante) {
		this.listaAtletasMandante = listaAtletasMandante;
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
		
		}
		return comboJogos;
	}


	public void setComboJogos(List<SelectItem> comboJogos) {
		this.comboJogos = comboJogos;
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
			
		}
		return comboCompeticao;
	}


	public void setComboCompeticao(List<SelectItem> comboCompeticao) {
		this.comboCompeticao = comboCompeticao;
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

	public String getTimeMandante() {
		return timeMandante;
	}

	public void setTimeMandante(String timeMandante) {
		this.timeMandante = timeMandante;
	}

	public String getTimeVisitante() {
		return timeVisitante;
	}

	public void setTimeVisitante(String timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public List<Escalacao> getListaEscalcaoMandante() {
		return listaEscalcaoMandante;
	}

	public void setListaEscalcaoMandante(List<Escalacao> listaEscalcaoMandante) {
		this.listaEscalcaoMandante = listaEscalcaoMandante;
	}

	public Scout getScout() {
		return scout;
	}

	public void setScout(Scout scout) {
		this.scout = scout;
	}

	public List<ScoutAcao> getListaOperacoes() {
		listaOperacoes = new ScoutAcaoDao().listaOperacoes();
		return listaOperacoes;
	}

	public void setListaOperacoes(List<ScoutAcao> listaOperacoes) {
		this.listaOperacoes = listaOperacoes;
	}

	public ScoutAcao getAcao() {
		return acao;
	}

	public void setAcao(ScoutAcao acao) {
		this.acao = acao;
	}

	public SlotCampoAux getSoutAcao() {
		return scoutAcao;
	}

	public void setScoutAcao(SlotCampoAux scoutAcao) {
		this.scoutAcao = scoutAcao;
	}

	public String getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(String tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public ScoutDetalhes getScoutDetalhes() {
		return scoutDetalhes;
	}

	public void setScoutDetalhes(ScoutDetalhes scoutDetalhes) {
		this.scoutDetalhes = scoutDetalhes;
	}

	public String getAtletaSelecionado() {
		return atletaSelecionado;
	}

	public void setAtletaSelecionado(String atletaSelecionado) {
		this.atletaSelecionado = atletaSelecionado;
	}

}
