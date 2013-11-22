package br.com.alesil.datafoot.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.DragDropEvent;

import br.com.alesil.datafoot.model.Atleta;
import br.com.alesil.datafoot.model.Esquema;

@ManagedBean(name="scoutCtrll")
@ViewScoped
public class Scout{

	private List<SelectItem>comboEsquema;
	private Esquema esquema = new Esquema();
	private Atleta atl = new Atleta();
	private int numeroTeste;
	
	private String ocultaFoto = "1";
	
	private String abc;
	
	public Scout(){

		criaAtletaTeste();
	}
	
	public void criaAtletaTeste(){
		atl.setApelido("Kaká");
		atl.setNumeroPadrao(22);
//	/	atl.setFoto("messi.PNG");
	}
		
	public List<Esquema> criaListaEsquemaTatico(){
		List<Esquema> lista = new ArrayList<Esquema>();
		
		esquema.setEsquema("4-4-2");
		
		esquema.setA1("visible");
		esquema.setB1("hidden");
		esquema.setC1("visible");
		
		esquema.setA2("hidden");
		esquema.setB2("hidden");
		esquema.setC2("hidden");
		
		esquema.setA3("visible");
		esquema.setB3("hidden");
		esquema.setC3("hidden");
		esquema.setD3("visible");
		
		esquema.setA4("visible");
		esquema.setB4("hidden");
		esquema.setC4("visible");
		
		esquema.setA5("visible");
		esquema.setB5("hidden");
		esquema.setC5("visible");
		
		esquema.setA6("visible");
		esquema.setB6("hidden");
		esquema.setC6("visible");
		
		lista.add(esquema);
		return lista;
	}

	public void onDrop(DragDropEvent event) {  
		//Atleta player = (Atleta) event.getData(); 
		numeroTeste = atl.getNumeroPadrao();
		ocultaFoto = "0,4";
        //player.setFoto("");
       System.out.print("passei aqui");
       System.out.print(event.getData());
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(player.getName() + " added", "Position:" + event.getDropId()));  
       
	} 
	
	public String login(){
		return "a";
	}
	
	
	public List<SelectItem> getComboEsquema() {
		List<Esquema> lista = criaListaEsquemaTatico();
		comboEsquema = new ArrayList<SelectItem>();
		for (Esquema esquema: lista){
			comboEsquema.add(new SelectItem(esquema.getEsquema()));
		}

		return comboEsquema;
	}
	public void setComboEsquema(List<SelectItem> comboEsquema) {
		this.comboEsquema = comboEsquema;
	}

	public Esquema getEsquema() {
		return esquema;
	}

	public void setEsquema(Esquema esquema) {
		this.esquema = esquema;
	}

	public Atleta getAtl() {
		return atl;
	}

	public void setAtl(Atleta atl) {
		this.atl = atl;
	}

	public int getNumeroTeste() {
		return numeroTeste;
	}

	public void setNumeroTeste(int numeroTeste) {
		this.numeroTeste = numeroTeste;
	}

	public String getAbc() {
		System.out.print("passei string");
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}

	public String getOcultaFoto() {
		return ocultaFoto;
	}

	public void setOcultaFoto(String ocultaFoto) {
		this.ocultaFoto = ocultaFoto;
	}

}
