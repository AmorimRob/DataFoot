package br.com.alesil.datafoot.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.alesil.datafoot.dao.CategoriaDao;
import br.com.alesil.datafoot.dao.CompeticaoDao;
import br.com.alesil.datafoot.model.Categoria;
import br.com.alesil.datafoot.model.Competicao;
import br.com.alesil.datafoot.servlet.ImageAux;

@ManagedBean(name="compCtrl")
@ViewScoped
public class CompeticaoCtrl {
	private  UploadedFile file;
	private String tipoImagem;
	
	private CtrlPadrao operacao;
	private Competicao competicao;
	private CompeticaoDao dao;
	
	private List<SelectItem>comboCategoria;
	
	private List<Competicao> listaCompeticao;
	
	public CompeticaoCtrl() {
		this.operacao = new CtrlPadrao();
		this.competicao = new Competicao();
		this.dao = new CompeticaoDao();
	}
	
	public void salvar (){
		if(competicao.getGuidCompeticao() == null)
			competicao.setGuidCompeticao(UUID.randomUUID().toString());
		operacao.salvar(competicao, dao, "FormCompeticao");
	}
	
	public void excluir (){
		operacao.excluir(competicao, dao, "FormCompeticao");
	}
	
	public void consultar(){
		Date data = new Date();
		//SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		
		if(competicao.getNomeCompeticao() != null || competicao.getDataInicio() != null){
			listaCompeticao = new ArrayList<Competicao>();
			listaCompeticao = dao.pesquisarCompeticao(competicao.getNomeCompeticao(), data);
			if(listaCompeticao.isEmpty()) operacao.exibeMensagem("FormCompeticao", "Não foi possível localizar a competição com os dados informados.".concat(
					 " Verifique as informações e tente novamente."));
		} else {
			operacao.exibeMensagem("FormCompeticao", "Não foi possível localizar a competição com os dados informados."
					+ " Verifique as informações e tente novamente.");
		}
	}
	
	public void novo(){
		this.competicao = new Competicao();
	}
	
	 public String upload() throws IOException {
		 tipoImagem = "temp";
	     competicao.setLogo(file.getBytes());
	     ImageAux.novaImagem = file;
	     
	     return null;
	}
	 
	 public void trocaTipoImagem(){
		 tipoImagem = "competicao";
	 }

	public Competicao getCompeticao() {
		return competicao;
	}

	public void setCompeticao(Competicao competicao) {
		this.competicao = competicao;
	}
	
	public List<SelectItem> getComboCategoria() {
		try{
			List<Categoria> lista = new CategoriaDao().listaCategoria();
			comboCategoria = new ArrayList<SelectItem>();
			for (Categoria cat: lista){
				comboCategoria.add(new SelectItem(cat.getGuidCategoria(), cat.getNomeCategoria()));
			}
		}catch(Exception e){
			operacao.exibeMensagem("FormCadCategoria", "Problemas de conexão com banco");
		}
		
		return comboCategoria;
	}

	public void setComboCategoria(List<SelectItem> comboCategoria) {
		this.comboCategoria = comboCategoria;
	}

	public List<Competicao> getListaCompeticao() {
		return listaCompeticao;
	}

	public void setListaCompeticao(List<Competicao> listaCompeticao) {
		this.listaCompeticao = listaCompeticao;
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
