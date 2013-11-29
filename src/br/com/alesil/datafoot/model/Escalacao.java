package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_escalacao")
public class Escalacao {
	
	@Id
	@Column(name="ES_GUID_JOGO")
	private String guidJogo;
	
	@Column(name="ES_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="ES_NUMERO")
	private int numero;
	
	@Column(name="ES_GUID_ATLETA")
	private String guidAtleta;
	
	@Column(name="ES_GUID_COMISSAO")
	private String guidComissao;
	
	public String getGuidJogo() {
		return guidJogo;
	}
	public void setGuidJogo(String guidJogo) {
		this.guidJogo = guidJogo;
	}
	public String getGuidClube() {
		return guidClube;
	}
	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getGuidAtleta() {
		return guidAtleta;
	}
	public void setGuidAtleta(String guidAtleta) {
		this.guidAtleta = guidAtleta;
	}
	public String getGuidComissao() {
		return guidComissao;
	}
	public void setGuidComissao(String guidComissao) {
		this.guidComissao = guidComissao;
	}
}
