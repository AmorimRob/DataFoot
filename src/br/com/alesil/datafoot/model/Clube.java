package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_clube")
public class Clube {

	@Id
	@Column(name="CL_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="CL_NOME_CLUBE")
	private String nomeClube;
	
	@Column(name="CL_NOME_CURTO")
	private String nomeCurto;
	
	@Column(name="CL_ESTADO")
	private String estado;
	
	@Column(name="CL_GUID_CIDADE")
	private String guidCidade;
	
	@Column(name="CL_GUID_ESTADIO")
	private String estadio;
	
	@Column(name="CL_WEBSITE")
	private String website;
	
	@Column(name="CL_ESCUDO")
	private byte[] escudo;

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}

	public String getNomeClube() {
		return nomeClube;
	}

	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getGuidCidade() {
		return guidCidade;
	}

	public void setGuidCidade(String cidade) {
		this.guidCidade = cidade;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public byte[] getEscudo() {
		return escudo;
	}

	public void setEscudo(byte[] escudo) {
		this.escudo = escudo;
	}

}
