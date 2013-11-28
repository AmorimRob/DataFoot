package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

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

	private List<Jogo> lstJogos;

	
	public JogosCtrl() {
		this.operacao = new CtrlPadrao();
		this.jogo = new Jogo();
		this.dao = new JogoDao();
	}
	
	public List<SelectItem> completarEstadio(String query) {  
		List<SelectItem> resultado = new ArrayList<SelectItem>();
		
        List<Estadio> estadios = new ArrayList<Estadio>();  
        estadios = new EstadioDao().listaEstadio();
        for (Estadio lista : estadios) {  
        	resultado.add(new SelectItem(lista.getGuidEstadio(), lista.getApelido()));  
        }  
          
        return resultado;  
    }  
	
	
	public List<String> completarClube(String query) {  
		List<String> resultado = new ArrayList<String>();
		
        List<Clube> clube = new ArrayList<Clube>();  
        clube = new ClubeDao().comboClubes();
        for (Clube lista : clube) {  
        	resultado.add(lista.getNomeCurto());  
        }  
          
        return resultado;  
    }  
	
	public List<String> completarCampeonato(String query) {  
		List<String> resultado = new ArrayList<String>();
		
        List<Competicao> comp = new ArrayList<Competicao>();  
        comp = new CompeticaoDao().comboCompeticao();
        for (Competicao lista : comp) {  
        	resultado.add(lista.getNomeCompeticao());  
        }  
          
        return resultado;  
    }  
	
	public void salvar (){
		if(jogo.getGuidJogo() == null)
			jogo.setGuidJogo(UUID.randomUUID().toString());
		operacao.salvar(jogo, dao, "FormJogo");
	}
	
	public void excluir (){
		operacao.excluir(jogo, dao, "FormJogo");
	}
	
	public void consultar(){
		if(jogo.getGuidJogo()!= null){
			jogo = dao.buscarJogo(jogo.getGuidJogo());			
		} else {
			lstJogos = new ArrayList<Jogo>();
			lstJogos = dao.listaJogos(jogo.getCompeticao(), jogo.getGuidClubeMandante(), jogo.getGuidEstadio());
			if(lstJogos.isEmpty()) operacao.exibeMensagem("FormJogo", "Não foi possível localizar o jogo com os dados informados."
					+ " Verifique as informações e tente novamente.");
		} 
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
}
