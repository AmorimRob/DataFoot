package br.com.alesil.datafoot.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import br.com.alesil.datafoot.dao.ClubeDao;
import br.com.alesil.datafoot.dao.ComissaoTecnicaDao;
import br.com.alesil.datafoot.dao.FuncaoComissaoTecnicaDao;
import br.com.alesil.datafoot.model.Clube;
import br.com.alesil.datafoot.model.ComissaoTecnica;
import br.com.alesil.datafoot.model.FuncaoComissaoTecnica;
import br.com.alesil.datafoot.servlet.ImageAux;

@ManagedBean(name="comissaoCtrl")
@ViewScoped
public class ComissaoTecnicaCtrl {
	
	private  UploadedFile file;
	private String tipoImagem;
	
	private CtrlPadrao operacao;
	private ComissaoTecnica comissao;
	private ComissaoTecnicaDao dao;
	
	private List<SelectItem> comboFuncoes;
	private List<SelectItem>comboClubes;
	
	private List<ComissaoTecnica>listaComissao;
	
	public ComissaoTecnicaCtrl() {
		this.operacao = new CtrlPadrao();
		this.comissao = new ComissaoTecnica();
		this.dao = new ComissaoTecnicaDao();
	}
	
	public void salvar (){
		if(comissao.getGuidComissaoTecnica() == null)
			comissao.setGuidComissaoTecnica(UUID.randomUUID().toString());
		operacao.salvar(comissao, dao, "FormComissao");
	}
	
	public void excluir (){
		operacao.excluir(comissao, dao, "FormComissao");
	}
	
	public void consultar(){
		if(comissao.getGuidComissaoTecnica()!= null){
			comissao = dao.buscarComissao(comissao.getGuidComissaoTecnica());
			
		} else if(comissao.getApelido() != null || comissao.getGuidComissaoTecnica() != null){
			listaComissao = new ArrayList<ComissaoTecnica>();
			listaComissao = dao.pesquisarComissao(comissao.getApelido(), comissao.getGuidClube(), comissao.getGuidFuncao());
			if(listaComissao.isEmpty()) operacao.exibeMensagem("FormComissao", "Não foi possível localizar o staff com os dados informados."
					+ " Verifique as informações e tente novamente.");
		} else {
			operacao.exibeMensagem("FormComissao", "Não foi possível localizar o staff com os dados informados."
					+ " Verifique as informações e tente novamente.");
		}
	}
	
	public void novo(){
		this.comissao = new ComissaoTecnica();
	}
	
	 public String upload() throws IOException {
		 tipoImagem = "temp";
	     comissao.setFoto(file.getBytes());
	     ImageAux.novaImagem = file;
	     
	     return null;
	}
	 
	 public void trocaTipoImagem(){
		 tipoImagem = "comissao";
	 }

	//Gets e Sets
	public ComissaoTecnica getComissao() {
		return comissao;
	}

	public void setComissao(ComissaoTecnica comissao) {
		this.comissao = comissao;
	}

	public List<SelectItem> getComboFuncoes() {
		List<FuncaoComissaoTecnica> lista = new FuncaoComissaoTecnicaDao().listaFuncoes();
		comboFuncoes = new ArrayList<SelectItem>();
		for (FuncaoComissaoTecnica funcao: lista){
			comboFuncoes.add(new SelectItem(funcao.getGuidFuncao(), funcao.getNomeFuncao()));
		}
		return comboFuncoes;
	}

	public void setComboFuncoes(List<SelectItem> comboFuncoes) {
		this.comboFuncoes = comboFuncoes;
	}
	
	public List<SelectItem> getComboClubes() {
		List<Clube> lista = new ClubeDao().comboClubes();
		comboClubes = new ArrayList<SelectItem>();
		for (Clube clube: lista){
			comboClubes.add(new SelectItem(clube.getGuidClube(), clube.getNomeCurto()));
		}
		
		return comboClubes;
	}

	public void setComboClubes(List<SelectItem> comboClubes) {
		this.comboClubes = comboClubes;
	}

	public List<ComissaoTecnica> getListaComissao() {
		return listaComissao;
	}

	public void setListaComissao(List<ComissaoTecnica> listaComissao) {
		this.listaComissao = listaComissao;
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
