package br.com.alesil.datafoot.ctrl;

import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.alesil.datafoot.dao.FuncaoComissaoTecnicaDao;
import br.com.alesil.datafoot.model.FuncaoComissaoTecnica;

@ManagedBean(name="funcaoCtrl")
@ViewScoped
public class FuncaoComissaoTecnicaCtrl {
	private CtrlPadrao operacao;
	private FuncaoComissaoTecnica funcao;
	private FuncaoComissaoTecnicaDao dao;
	
	private List<FuncaoComissaoTecnica> listaFuncao;
	
	public FuncaoComissaoTecnicaCtrl() {
		this.operacao = new CtrlPadrao();
		this.funcao = new FuncaoComissaoTecnica();
		this.dao = new FuncaoComissaoTecnicaDao();
	}
	
	public void salvar (){
		if(funcao.getGuidFuncao() == null){
			funcao.setGuidFuncao(dao.buscarFuncao(funcao.getNomeFuncao()));
			if(funcao.getGuidFuncao() == null){
				funcao.setGuidFuncao(UUID.randomUUID().toString());
				operacao.salvar(funcao, dao, "FormDialogFuncao");
			} else {
				operacao.exibeMensagem("FormDialogFuncao", "Função já cadastrada.");
			}
		} else {
			operacao.salvar(funcao, dao, "FormDialogFuncao");
		}
	}
	
	public void excluir (){
		operacao.excluir(funcao, dao, "FormDialogFuncao");
	}
	
	public void consultar(){
		listaFuncao = dao.listaFuncoes();
	}

	public FuncaoComissaoTecnica getFuncao() {
		return funcao;
	}

	public void setFuncao(FuncaoComissaoTecnica funcao) {
		this.funcao = funcao;
	}

	public List<FuncaoComissaoTecnica> getListaFuncao() {
		return listaFuncao;
	}

	public void setListaFuncao(List<FuncaoComissaoTecnica> listaFuncao) {
		this.listaFuncao = listaFuncao;
	}
}
