package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_CLUBE")
public class Clube {

	@Id
	@Column(name="CL_GUID_CLUBE")
	private UUID guidClube;
	
	@Column(name="CL_NOME_CLUBE")
	private String nomeClube;
	
	@Column(name="CL_NOME_CURTO")
	private String nomeCurto;
	
	@Column(name="CL_ESTADO")
	private String estado;
	
	@Column(name="CL_CIDADE")
	private String cidade;
	
	@Column(name="CL_GUID_ESTADIO")
	private UUID estadio;
	
	@Column(name="CL_WEBSITE")
	private String website;

	public UUID getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(UUID guidClube) {
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UUID getEstadio() {
		return estadio;
	}

	public void setEstadio(UUID estadio) {
		this.estadio = estadio;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((estadio == null) ? 0 : estadio.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime * result
				+ ((nomeClube == null) ? 0 : nomeClube.hashCode());
		result = prime * result
				+ ((nomeCurto == null) ? 0 : nomeCurto.hashCode());
		result = prime * result + ((website == null) ? 0 : website.hashCode());
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
		Clube other = (Clube) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (estadio == null) {
			if (other.estadio != null)
				return false;
		} else if (!estadio.equals(other.estadio))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (nomeClube == null) {
			if (other.nomeClube != null)
				return false;
		} else if (!nomeClube.equals(other.nomeClube))
			return false;
		if (nomeCurto == null) {
			if (other.nomeCurto != null)
				return false;
		} else if (!nomeCurto.equals(other.nomeCurto))
			return false;
		if (website == null) {
			if (other.website != null)
				return false;
		} else if (!website.equals(other.website))
			return false;
		return true;
	}
	
}
