package br.com.alesil.datafoot.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.alesil.datafoot.dao.CidadeDao;
import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.model.Cidade;
import br.com.alesil.datafoot.model.Estadio;
import br.com.alesil.datafoot.servlet.ImageAux;

@ManagedBean(name="estadioCtrl")
@ViewScoped
public class EstadioCtrl {
	private CtrlPadrao operacao;
	private Estadio estadio;
	private EstadioDao dao;
	
	private UploadedFile file;
	private String tipoImagem;
	
	private List<SelectItem>comboCidade;
	
	private List<Estadio>listaEstadio;
	public EstadioCtrl() {
		this.operacao = new CtrlPadrao();
		this.estadio = new Estadio();
		this.dao = new EstadioDao();
	}
	
	public void salvar (){
		if(estadio.getGuidEstadio() == null)
			estadio.setGuidEstadio(UUID.randomUUID().toString());
		operacao.salvar(estadio, dao, "FormEstadio");
	}
	
	public void excluir (){
		operacao.excluir(estadio, dao, "FormEstadio");
	}
	
	public void consultar(){
	
		if(estadio.getApelido() != null || estadio.getEstado() != null){
			listaEstadio = new ArrayList<Estadio>();
			listaEstadio = dao.pesquisarEstadio(estadio.getApelido(), estadio.getEstado());
			if(listaEstadio.isEmpty()) operacao.exibeMensagem("FormEstadio", "Não foi possível localizar a competição com os dados informados.".concat(
					 " Verifique as informações e tente novamente."));
		} else {
			operacao.exibeMensagem("FormEstadio", "Não foi possível localizar a competição com os dados informados."
					+ " Verifique as informações e tente novamente.");
		}
	}
	
	public void novo(){
		this.estadio = new Estadio();
	}
	
	 public String upload() throws IOException {
		 tipoImagem = "temp";
	     estadio.setFoto(file.getBytes());
	     ImageAux.novaImagem = file;
	     
	     return null;
	}
	 
	 public void trocaTipoImagem(){
		 tipoImagem = "estadio";
	 }

	//Gets e sets
	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<SelectItem> getComboCidade() {
		try{
			List<Cidade> lista = new CidadeDao().listaCidade();
			comboCidade = new ArrayList<SelectItem>();
			for (Cidade cidade: lista){
				comboCidade.add(new SelectItem(cidade.getGuidCidade(), cidade.getNomeCidade()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormClube", "Problemas de conexão com banco");
		}
		return comboCidade;
	}

	public void setComboCidade(List<SelectItem> comboCidade) {
		this.comboCidade = comboCidade;
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

	public List<Estadio> getListaEstadio() {
		return listaEstadio;
	}

	public void setListaEstadio(List<Estadio> listaEstadio) {
		this.listaEstadio = listaEstadio;
	}

}
