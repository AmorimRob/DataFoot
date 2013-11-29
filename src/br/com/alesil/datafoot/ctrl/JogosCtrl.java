package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.alesil.datafoot.converters.ClubeConverter;
import br.com.alesil.datafoot.converters.CompeticaoConverter;
import br.com.alesil.datafoot.converters.EstadioConverter;
import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.dao.JogoDao;
import br.com.alesil.datafoot.model.Clube;
import br.com.alesil.datafoot.model.Competicao;
import br.com.alesil.datafoot.model.Estadio;
import br.com.alesil.datafoot.model.Jogo;

@ManagedBean(name="jogoCtrl")
@ViewScoped
public class JogosCtrl {
	private CtrlPadrao operacao;
	private Jogo jogo;
	private JogoDao dao;
	
	private List<SelectItem> comboCompeticao;
	private List<SelectItem> comboEstadio;
	private List<SelectItem> comboClube;

	private List<Jogo> lstJogos;
	private List<Clube>listaClube;
	private List<Estadio>listaEstadio;
	private List<Competicao>listaCompeticao;

	
	public JogosCtrl() {
		this.operacao = new CtrlPadrao();
		this.jogo = new Jogo();
		this.dao = new JogoDao();
		
		this.listaClube = ClubeConverter.lstClube;
		this.listaCompeticao = CompeticaoConverter.lstCompeticao;
		this.listaEstadio = EstadioConverter.lstEstadio;
	}
	
    public List<Clube> completarClube(String query) {  
        List<Clube> suggestions = new ArrayList<Clube>();  
          
        for(Clube item : listaClube) {  
            if(item.getNomeCurto().startsWith(query))  
                suggestions.add(item);  
        }  
          
        return suggestions;  
    }  
    
    public List<Estadio> completarEstadio(String query) {  
        List<Estadio> suggestions = new ArrayList<Estadio>();  
          
        for(Estadio item : listaEstadio) {  
            if(item.getApelido().startsWith(query))  
                suggestions.add(item);  
        }  
          
        return suggestions;  
    }  
    
    public List<Competicao> completarCompeticao(String query) {  
        List<Competicao> suggestions = new ArrayList<Competicao>();  
          
        for(Competicao item : listaCompeticao) {  
            if(item.getNomeCompeticao().startsWith(query))  
                suggestions.add(item);  
        }  
          
        return suggestions;  
    }  
	
	
	public void salvar (){
		if(jogo.getGuidJogo() == null)
			jogo.setGuidJogo(UUID.randomUUID().toString());
		operacao.salvar(jogo, dao, "FormCadJogo");
	}
	
	public void excluir (){
		operacao.excluir(jogo, dao, "FormCadJogo");
	}
	
	public void consultar(){
		if(jogo.getGuidJogo()!= null){
			jogo = dao.buscarJogo(jogo.getGuidJogo());			
		} else {
			lstJogos = new ArrayList<Jogo>();
			lstJogos = dao.listaJogos(jogo.getCompeticao());
			if(lstJogos.isEmpty()) operacao.exibeMensagem("FormJogo", "Não foi possível localizar o jogo com os dados informados."
					+ " Verifique as informações e tente novamente.");
		} 
	}
	
	public void novo(){
		this.jogo = new Jogo();
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
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

	public List<Jogo> getLstJogos() {
		return lstJogos;
	}

	public void setLstJogos(List<Jogo> listaJogos) {
		this.lstJogos = listaJogos;
	}

	public List<SelectItem> getComboEstadio() {
		try{
			List<Estadio> lista = new EstadioDao().listaEstadio();
			comboEstadio = new ArrayList<SelectItem>();
			for (Estadio estadio : lista){
				comboEstadio.add(new SelectItem(estadio.getGuidEstadio(), estadio.getApelido()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormEditarJogo", "Problemas de conexão com banco");
		}
		return comboEstadio;
	}

	public void setComboEstadio(List<SelectItem> comboEstadio) {
		this.comboEstadio = comboEstadio;
	}

	public List<SelectItem> getComboClube() {
		try{
			List<Clube> lista = new ClubeDao().comboClubes();
			comboClube = new ArrayList<SelectItem>();
			for (Clube clube : lista){
				comboClube.add(new SelectItem(clube.getGuidClube(), clube.getNomeCurto()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormEditarJogo", "Problemas de conexão com banco");
		}
		return comboClube;
	}

	public void setComboClube(List<SelectItem> comboClube) {
		this.comboClube = comboClube;
	}
}
