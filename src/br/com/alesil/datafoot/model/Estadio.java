package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_estadio")
public class Estadio {

	@Id
	@Column(name="EST_GUID_ESTADIO")
	private String guidEstadio;
	
	@Column(name="EST_NOME_COMPLETO")
	private String nomeCompleto;
	
	@Column(name="EST_APELIDO")
	private String apelido;
	
	@Column(name="EST_ESTADO")
	private String estado;
	
	@Column(name="EST_GUID_CIDADE")
	private String guidCidade;
	
	@Column(name="EST_FOTO")
	private byte[] foto;

	public String getGuidEstadio() {
		return guidEstadio;
	}

	public void setGuidEstadio(String guidEstadio) {
		this.guidEstadio = guidEstadio;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
