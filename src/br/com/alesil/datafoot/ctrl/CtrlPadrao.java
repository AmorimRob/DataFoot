package br.com.alesil.datafoot.ctrl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.alesil.datafoot.dao.HibernateDAO;

public class CtrlPadrao{

	
	public String salvar(Object model, HibernateDAO dao, String form) {
		try {
			dao.executaTransacao(model, 1);
			exibeMensagem(form, "Registro salvo/atualizado com sucesso!");
		} catch (Exception erro) {
			exibeMensagem(form, "Erro ao salvar/atualizar, Verifique os campos de cadastro e tente novamente.");
		}

		return null;
	}

	public String excluir(Object model, HibernateDAO dao, String form) {
		try {
			dao.executaTransacao(model, 2);
			exibeMensagem(form, "Exclusão Realizada!");
		} catch (Exception erro) {
			exibeMensagem(form, "Erro ao Excluir!");
		}

		return null;
	}

	public void exibeMensagem(String form, String msn) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagem = new FacesMessage(msn);
		contexto.addMessage(form, mensagem);
	}
}
