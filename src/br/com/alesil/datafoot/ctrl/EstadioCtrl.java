package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import br.com.alesil.datafoot.dao.CidadeDao;
import br.com.alesil.datafoot.dao.EstadioDao;
import br.com.alesil.datafoot.model.Cidade;
import br.com.alesil.datafoot.model.Estadio;

@ManagedBean(name="estadioCtrl")
@ViewScoped
public class EstadioCtrl {
	private CtrlPadrao operacao;
	private Estadio estadio;
	private EstadioDao dao;
	
	private List<SelectItem>comboCidade;
	
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

}
