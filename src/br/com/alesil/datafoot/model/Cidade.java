package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DF_CIDADE")
public class Cidade {
	
	@Id
	@Column(name="CI_GUID_CIDADE")
	private String guidCidade;
	
	@Column(name="CI_NOME_CIDADE")
	private String nomeCidade;
	
	@Column(name="CI_ESTADO")
	private String estado;

	public String getGuidCidade() {
		return guidCidade;
	}

	public void setGuidCidade(String guidCidade) {
		this.guidCidade = guidCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidCidade == null) ? 0 : guidCidade.hashCode());
		result = prime * result
				+ ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		Cidade other = (Cidade) obj;
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
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	} 
	
}
