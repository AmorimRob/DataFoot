package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_CIDADE")
public class Cidade {
	
	@Id
	@Column(name="CI_GUID_CIDADE")
	private UUID guidCidade;
	
	@Column(name="CI_NOME_CIDADE")
	private String nomeCidade;
	
	@Column(name="CI_GUID_ESTADO")
	private UUID guidEstado;

	public UUID getGuidCidade() {
		return guidCidade;
	}

	public void setGuidCidade(UUID guidCidade) {
		this.guidCidade = guidCidade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public UUID getGuidEstado() {
		return guidEstado;
	}

	public void setGuidEstado(UUID guidEstado) {
		this.guidEstado = guidEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidCidade == null) ? 0 : guidCidade.hashCode());
		result = prime * result
				+ ((guidEstado == null) ? 0 : guidEstado.hashCode());
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
		if (guidEstado == null) {
			if (other.guidEstado != null)
				return false;
		} else if (!guidEstado.equals(other.guidEstado))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	} 
	
}
