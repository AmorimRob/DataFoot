package br.com.alesil.datafoot.components;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


public class SlotCampoAux {
	private String guidAtleta;
	private String nome;
	private int numero;
	private String posicao_campo;
	
	public SlotCampoAux(){}
	
	public SlotCampoAux(SlotCampoAux slotcampo){
		this.nome = slotcampo.getNome();
		this.numero = slotcampo.getNumero();
		this.posicao_campo = slotcampo.getPosicao_campo();
		this.guidAtleta = slotcampo.getGuidAtleta();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPosicao_campo() {
		return posicao_campo;
	}

	public void setPosicao_campo(String posicao_campo) {
		this.posicao_campo = posicao_campo;
	}

	public String getGuidAtleta() {
		return guidAtleta;
	}

	public void setGuidAtleta(String guidAtleta) {
		this.guidAtleta = guidAtleta;
	}
}
