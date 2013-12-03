package br.com.alesil.datafoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

class CompeticaoClubeID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="COMPCL_GUID_COMPETICAO")
	private String guidCompeticao;

	@Column(name="COMPCL_GUID_CLUBE")
	private String guidClube;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime * result
				+ ((guidCompeticao == null) ? 0 : guidCompeticao.hashCode());
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
		CompeticaoClubeID other = (CompeticaoClubeID) obj;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidCompeticao == null) {
			if (other.guidCompeticao != null)
				return false;
		} else if (!guidCompeticao.equals(other.guidCompeticao))
			return false;
		return true;
	}	
	
}

@Entity
@IdClass(CompeticaoClubeID.class)
@Table(name="df_competicao_clube")
public class CompeticaoClube {
	@Id
	@Column(name="COMPCL_GUID_COMPETICAO")
	private String guidCompeticao;
	
	@Id
	@Column(name="COMPCL_GUID_CLUBE")
	private String guidClube;

	public String getGuidCompeticao() {
		return guidCompeticao;
	}

	public void setGuidCompeticao(String guidCompeticao) {
		this.guidCompeticao = guidCompeticao;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime * result
				+ ((guidCompeticao == null) ? 0 : guidCompeticao.hashCode());
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
		CompeticaoClube other = (CompeticaoClube) obj;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidCompeticao == null) {
			if (other.guidCompeticao != null)
				return false;
		} else if (!guidCompeticao.equals(other.guidCompeticao))
			return false;
		return true;
	}
}
