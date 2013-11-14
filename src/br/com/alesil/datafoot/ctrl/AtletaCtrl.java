package br.com.alesil.datafoot.ctrl;




import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.alesil.datafoot.dao.AtletaDao;
import br.com.alesil.datafoot.model.Atleta;

@ManagedBean(name="atletasCtrl")
@ViewScoped
public class AtletaCtrl {
	private Atleta atleta;
	private AtletaDao dao;

	public AtletaCtrl() {
		this.atleta = new Atleta();
		this.dao = new AtletaDao();
	}
	

	public String salvar() {
		try {
			dao.executaTransacao(atleta, 1);
			exibeMensagem("FormAtleta", "Atleta salvo/atualizado com sucesso!");
		} catch (Exception erro) {
			exibeMensagem("FormAtleta", "Erro ao salvar/atualizar, Verifique os campos de cadastro e tente novamente.");
		}

		return null;
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
}
