package br.com.alesil.datafoot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_scout_detalhes")
public class ScoutDetalhes {
	
	@Id
	@Column(name="SDT_GUID_SCOUT_DETALHES")
	private String guidScoutDetalhes;
	
	@Column(name="SDT_GUID_SCOUT")
	private String guidScout;
	
	@Column(name="SDT_TEMPO_JOGO")
	private Date tempoJogo;
	
	@Column(name="SDT_GUID_ACAO")
	private String guidAcao;
	
	@Column(name="SDT_GUID_ATLETA")
	private String atleta;
	
	@Column(name="SDT_GUID_ATLETA2")
	private String atleta2;
	
	@Column(name="SDT_GUID_CLUBE")
	private String guidClube;

	public String getGuidScoutDetalhes() {
		return guidScoutDetalhes;
	}

	public void setGuidScoutDetalhes(String guidScoutDetalhes) {
		this.guidScoutDetalhes = guidScoutDetalhes;
	}

	public Date getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(Date tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public String getGuidAcao() {
		return guidAcao;
	}

	public void setGuidAcao(String guidAcao) {
		this.guidAcao = guidAcao;
	}

	public String getAtleta() {
		return atleta;
	}

	public void setAtleta(String atleta) {
		this.atleta = atleta;
	}

	public String getAtleta2() {
		return atleta2;
	}

	public void setAtleta2(String atleta2) {
		this.atleta2 = atleta2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atleta == null) ? 0 : atleta.hashCode());
		result = prime * result + ((atleta2 == null) ? 0 : atleta2.hashCode());
		result = prime * result
				+ ((guidAcao == null) ? 0 : guidAcao.hashCode());
		result = prime
				* result
				+ ((guidScoutDetalhes == null) ? 0 : guidScoutDetalhes
						.hashCode());
		result = prime * result
				+ ((tempoJogo == null) ? 0 : tempoJogo.hashCode());
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
		ScoutDetalhes other = (ScoutDetalhes) obj;
		if (atleta == null) {
			if (other.atleta != null)
				return false;
		} else if (!atleta.equals(other.atleta))
			return false;
		if (atleta2 == null) {
			if (other.atleta2 != null)
				return false;
		} else if (!atleta2.equals(other.atleta2))
			return false;
		if (guidAcao == null) {
			if (other.guidAcao != null)
				return false;
		} else if (!guidAcao.equals(other.guidAcao))
			return false;
		if (guidScoutDetalhes == null) {
			if (other.guidScoutDetalhes != null)
				return false;
		} else if (!guidScoutDetalhes.equals(other.guidScoutDetalhes))
			return false;
		if (tempoJogo == null) {
			if (other.tempoJogo != null)
				return false;
		} else if (!tempoJogo.equals(other.tempoJogo))
			return false;
		return true;
	}

	public String getGuidScout() {
		return guidScout;
	}

	public void setGuidScout(String guidScout) {
		this.guidScout = guidScout;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}
	
}
