package br.com.alesil.datafoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

class ComissaoTecnicaJogoID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="CTJ_GUID_COMISSAO_TECNICA")
	private String guidComissaoTecnica;
	
	@Column(name="CTJ_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="CTJ_GUID_JOGO")
	private String guidJogo;

	@Column(name="CTJ_GUID_FUNCAO")
	private String guidFuncao;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime
				* result
				+ ((guidComissaoTecnica == null) ? 0 : guidComissaoTecnica
						.hashCode());
		result = prime * result
				+ ((guidFuncao == null) ? 0 : guidFuncao.hashCode());
		result = prime * result
				+ ((guidJogo == null) ? 0 : guidJogo.hashCode());
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
		ComissaoTecnicaJogoID other = (ComissaoTecnicaJogoID) obj;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidComissaoTecnica == null) {
			if (other.guidComissaoTecnica != null)
				return false;
		} else if (!guidComissaoTecnica.equals(other.guidComissaoTecnica))
			return false;
		if (guidFuncao == null) {
			if (other.guidFuncao != null)
				return false;
		} else if (!guidFuncao.equals(other.guidFuncao))
			return false;
		if (guidJogo == null) {
			if (other.guidJogo != null)
				return false;
		} else if (!guidJogo.equals(other.guidJogo))
			return false;
		return true;
	}
	
	
}

@Entity
@IdClass(ComissaoTecnicaJogoID.class)
@Table(name="df_comissao_tecnica_jogo")
public class ComissaoTecnicaJogo {
	
	@Id
	@Column(name="CTJ_GUID_COMISSAO_TECNICA")
	private String guidComissaoTecnica;
	
	@Id
	@Column(name="CTJ_GUID_CLUBE")
	private String guidClube;
	
	@Id
	@Column(name="CTJ_GUID_JOGO")
	private String guidJogo;

	@Id
	@Column(name="CTJ_GUID_FUNCAO")
	private String guidFuncao;

	public String getGuidComissaoTecnica() {
		return guidComissaoTecnica;
	}

	public void setGuidComissaoTecnica(String guidComissaoTecnica) {
		this.guidComissaoTecnica = guidComissaoTecnica;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}

	public String getGuidJogo() {
		return guidJogo;
	}

	public void setGuidJogo(String guidJogo) {
		this.guidJogo = guidJogo;
	}

	public String getGuidFuncao() {
		return guidFuncao;
	}

	public void setGuidFuncao(String guidFuncao) {
		this.guidFuncao = guidFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime
				* result
				+ ((guidComissaoTecnica == null) ? 0 : guidComissaoTecnica
						.hashCode());
		result = prime * result
				+ ((guidFuncao == null) ? 0 : guidFuncao.hashCode());
		result = prime * result
				+ ((guidJogo == null) ? 0 : guidJogo.hashCode());
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
		ComissaoTecnicaJogo other = (ComissaoTecnicaJogo) obj;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidComissaoTecnica == null) {
			if (other.guidComissaoTecnica != null)
				return false;
		} else if (!guidComissaoTecnica.equals(other.guidComissaoTecnica))
			return false;
		if (guidFuncao == null) {
			if (other.guidFuncao != null)
				return false;
		} else if (!guidFuncao.equals(other.guidFuncao))
			return false;
		if (guidJogo == null) {
			if (other.guidJogo != null)
				return false;
		} else if (!guidJogo.equals(other.guidJogo))
			return false;
		return true;
	}
}
