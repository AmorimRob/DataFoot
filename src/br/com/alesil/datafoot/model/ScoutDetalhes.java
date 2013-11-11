package br.com.alesil.datafoot.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_SCOUT_DETALHES")
public class ScoutDetalhes {
	
	@Id
	@Column(name="SDT_GUID_SCOUT_DETALHES")
	private UUID guidScoutDetalhes;
	
	@Column(name="SDT_TEMPO_JOGO")
	private Date tempoJogo;
	
	@Column(name="SDT_GUID_ACAO")
	private UUID guidAcao;
	
	@Column(name="SDT_GUID_ATLETA")
	private UUID atleta;
	
	@Column(name="SDT_GUID_ATLETA2")
	private UUID atleta2;

	public UUID getGuidScoutDetalhes() {
		return guidScoutDetalhes;
	}

	public void setGuidScoutDetalhes(UUID guidScoutDetalhes) {
		this.guidScoutDetalhes = guidScoutDetalhes;
	}

	public Date getTempoJogo() {
		return tempoJogo;
	}

	public void setTempoJogo(Date tempoJogo) {
		this.tempoJogo = tempoJogo;
	}

	public UUID getGuidAcao() {
		return guidAcao;
	}

	public void setGuidAcao(UUID guidAcao) {
		this.guidAcao = guidAcao;
	}

	public UUID getAtleta() {
		return atleta;
	}

	public void setAtleta(UUID atleta) {
		this.atleta = atleta;
	}

	public UUID getAtleta2() {
		return atleta2;
	}

	public void setAtleta2(UUID atleta2) {
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
	
}
