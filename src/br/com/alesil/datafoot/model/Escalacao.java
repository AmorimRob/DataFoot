package br.com.alesil.datafoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

class EscalacaoID implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="ES_GUID_JOGO")
	private String guidJogo;
	
	@Column(name="ES_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="ES_GUID_ATLETA")
	private String guidAtleta;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidAtleta == null) ? 0 : guidAtleta.hashCode());
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
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
		EscalacaoID other = (EscalacaoID) obj;
		if (guidAtleta == null) {
			if (other.guidAtleta != null)
				return false;
		} else if (!guidAtleta.equals(other.guidAtleta))
			return false;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
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
@IdClass(EscalacaoID.class)
@Table(name="df_escalacao")
public class Escalacao {
	
	@Id
	@Column(name="ES_GUID_JOGO")
	private String guidJogo;
	
	@Id
	@Column(name="ES_GUID_CLUBE")
	private String guidClube;
	
	@Id
	@Column(name="ES_GUID_ATLETA")
	private String guidAtleta;
	
	@Column(name="ES_NUMERO")
	private int numero;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidAtleta == null) ? 0 : guidAtleta.hashCode());
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime * result
				+ ((guidComissao == null) ? 0 : guidComissao.hashCode());
		result = prime * result
				+ ((guidJogo == null) ? 0 : guidJogo.hashCode());
		result = prime * result + numero;
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
		Escalacao other = (Escalacao) obj;
		if (guidAtleta == null) {
			if (other.guidAtleta != null)
				return false;
		} else if (!guidAtleta.equals(other.guidAtleta))
			return false;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidComissao == null) {
			if (other.guidComissao != null)
				return false;
		} else if (!guidComissao.equals(other.guidComissao))
			return false;
		if (guidJogo == null) {
			if (other.guidJogo != null)
				return false;
		} else if (!guidJogo.equals(other.guidJogo))
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
}
