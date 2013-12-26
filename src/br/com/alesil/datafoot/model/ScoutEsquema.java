package br.com.alesil.datafoot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

class ScoutEsquemaID implements	Serializable{
	
	@Column(name="SCE_GUID_SCOUT")
	private String guidScout;
	
	@Column(name="SCE_GUID_ESQUEMA")
	private String guidEsquema;
	
	@Column(name="SCE_GUID_ATLETA")
	private String guidAtleta;
	
	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidAtleta == null) ? 0 : guidAtleta.hashCode());
		result = prime * result
				+ ((guidEsquema == null) ? 0 : guidEsquema.hashCode());
		result = prime * result
				+ ((guidScout == null) ? 0 : guidScout.hashCode());
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
		ScoutEsquemaID other = (ScoutEsquemaID) obj;
		if (guidAtleta == null) {
			if (other.guidAtleta != null)
				return false;
		} else if (!guidAtleta.equals(other.guidAtleta))
			return false;
		if (guidEsquema == null) {
			if (other.guidEsquema != null)
				return false;
		} else if (!guidEsquema.equals(other.guidEsquema))
			return false;
		if (guidScout == null) {
			if (other.guidScout != null)
				return false;
		} else if (!guidScout.equals(other.guidScout))
			return false;
		return true;
	}
	
}
@Entity
@IdClass(ScoutEsquemaID.class)
@Table(name="df_scout_esquema")
public class ScoutEsquema {
	
	@Id
	@Column(name="SCE_GUID_SCOUT")
	private String guidScout;
	
	@Id
	@Column(name="SCE_GUID_ESQUEMA")
	private String guidEsquema;
	
	@Id
	@Column(name="SCE_GUID_ATLETA")
	private String guidAtleta;

	@Column(name="SCE_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="SCE_POSICAO_CAMPO")
	private String posicao_campo;

	@Transient
	private String nomeAtleta;
	
	@Transient
	private int numeroAtleta;
	
	public String getGuidScout() {
		return guidScout;
	}

	public void setGuidScout(String guidScout) {
		this.guidScout = guidScout;
	}

	public String getGuidEsquema() {
		return guidEsquema;
	}

	public void setGuidEsquema(String guidEsquema) {
		this.guidEsquema = guidEsquema;
	}

	public String getGuidAtleta() {
		return guidAtleta;
	}

	public void setGuidAtleta(String guidAtleta) {
		this.guidAtleta = guidAtleta;
	}

	public String getPosicao_campo() {
		return posicao_campo;
	}

	public void setPosicao_campo(String posicao_campo) {
		this.posicao_campo = posicao_campo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidAtleta == null) ? 0 : guidAtleta.hashCode());
		result = prime * result
				+ ((guidEsquema == null) ? 0 : guidEsquema.hashCode());
		result = prime * result
				+ ((guidScout == null) ? 0 : guidScout.hashCode());
		result = prime * result
				+ ((posicao_campo == null) ? 0 : posicao_campo.hashCode());
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
		ScoutEsquema other = (ScoutEsquema) obj;
		if (guidAtleta == null) {
			if (other.guidAtleta != null)
				return false;
		} else if (!guidAtleta.equals(other.guidAtleta))
			return false;
		if (guidEsquema == null) {
			if (other.guidEsquema != null)
				return false;
		} else if (!guidEsquema.equals(other.guidEsquema))
			return false;
		if (guidScout == null) {
			if (other.guidScout != null)
				return false;
		} else if (!guidScout.equals(other.guidScout))
			return false;
		if (posicao_campo == null) {
			if (other.posicao_campo != null)
				return false;
		} else if (!posicao_campo.equals(other.posicao_campo))
			return false;
		return true;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}

	public int getNumeroAtleta() {
		return numeroAtleta;
	}

	public void setNumeroAtleta(int numeroAtleta) {
		this.numeroAtleta = numeroAtleta;
	}
	
}
