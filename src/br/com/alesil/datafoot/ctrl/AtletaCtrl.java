package br.com.alesil.datafoot.ctrl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.dao.CategoriaDao;
import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.PosicaoDao;
import br.com.alesil.datafoot.model.Atleta;
import br.com.alesil.datafoot.model.Categoria;
import br.com.alesil.datafoot.model.Clube;
import br.com.alesil.datafoot.model.Posicao;
import br.com.alesil.datafoot.servlet.ImageAux;


@ManagedBean(name="atletasCtrl")
@ViewScoped
public class AtletaCtrl {
	
	private UploadedFile file;
	private String tipoImagem;
	
	private Atleta atleta;	
	private AtletaDao dao;

	private List<Atleta> listaAtletas;
	
	private List<SelectItem>comboPosicao;
	private List<SelectItem>comboClubes;
	private List<SelectItem>comboCategoria;
	

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
			if(atleta.getGuidAtleta()==null)
				atleta.setGuidAtleta(UUID.randomUUID().toString());
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
	
	public void novo(){
		this.atleta = new Atleta(); 
	}

	 public String upload() throws IOException {
		 tipoImagem = "temp";
	     atleta.setFoto(file.getBytes());
	     ImageAux.novaImagem = file;
	     
	     return null;
	}
	 
	 public void trocaTipoImagem(){
		 tipoImagem = "atleta";
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
		try{
			List<Posicao> lista = new PosicaoDao().listaPosicao();
			comboPosicao = new ArrayList<SelectItem>();
			for (Posicao pos: lista){
				comboPosicao.add(new SelectItem(pos.getGuidPosicao(), pos.getNome_posicao()));
			}
		}catch(Exception e){
			comboClubes = null;
			exibeMensagem("FormAtleta", "Problemas de conexão com banco");
		}
		return comboPosicao;
	}


	public void setComboPosicao(List<SelectItem> comboPosicao) {
		this.comboPosicao = comboPosicao;
	}

	public List<SelectItem> getComboClubes() {
		try{
			List<Clube> lista = new ClubeDao().comboClubes();
			comboClubes = new ArrayList<SelectItem>();
			for (Clube clube: lista){
				comboClubes.add(new SelectItem(clube.getGuidClube(), clube.getNomeCurto()));
			}
		}catch(Exception e){
			comboClubes = null;

		}
		
		return comboClubes;
	}

	public void setComboClubes(List<SelectItem> comboClubes) {
		this.comboClubes = comboClubes;
	}
	
	public List<SelectItem> getComboCategoria() {
		try{
			List<Categoria> lista = new CategoriaDao().listaCategoria();
			comboCategoria = new ArrayList<SelectItem>();
			for (Categoria cat: lista){
				comboCategoria.add(new SelectItem(cat.getGuidCategoria(), cat.getNomeCategoria()));
			}
		}catch(Exception e){
			comboCategoria = null;
		
		}
		
		return comboCategoria;
	}

	public void setComboCategoria(List<SelectItem> comboCategoria) {
		this.comboCategoria = comboCategoria;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(String tipoImagem) {
		this.tipoImagem = tipoImagem;
	}

}
