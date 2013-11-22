package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DF_ESTADIO")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result + ((guidCidade == null) ? 0 : guidCidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((guidEstadio == null) ? 0 : guidEstadio.hashCode());
		result = prime * result
				+ ((nomeCompleto == null) ? 0 : nomeCompleto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadio other = (Estadio) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (guidCidade == null) {
			if (other.guidCidade != null)
				return false;
		} else if (!guidCidade.equals(other.guidCidade))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (guidEstadio == null) {
			if (other.guidEstadio != null)
				return false;
		} else if (!guidEstadio.equals(other.guidEstadio))
			return false;
		if (nomeCompleto == null) {
			if (other.nomeCompleto != null)
				return false;
		} else if (!nomeCompleto.equals(other.nomeCompleto))
			return false;
		return true;
	}
}
