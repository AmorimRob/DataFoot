package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="df_scout")
public class Scout {
	
	@Id
	@Column(name="SC_GUID_JOGO")
	private UUID guidJogo;
	
	@Column(name="SC_CLUBE")
	private String clube;
	
	
	@Column(name="SC_GUID_SCOUT_DETALHES")
	private UUID guidScoutDetalhes;

	public UUID getGuidJogo() {
		return guidJogo;
	}

	public void setGuidJogo(UUID guidJogo) {
		this.guidJogo = guidJogo;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public UUID getGuidScoutDetalhes() {
		return guidScoutDetalhes;
	}

	public void setGuidScoutDetalhes(UUID guidScoutDetalhes) {
		this.guidScoutDetalhes = guidScoutDetalhes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clube == null) ? 0 : clube.hashCode());
		result = prime * result
				+ ((guidJogo == null) ? 0 : guidJogo.hashCode());
		result = prime
				* result
				+ ((guidScoutDetalhes == null) ? 0 : guidScoutDetalhes
						.hashCode());
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
		Scout other = (Scout) obj;
		if (clube == null) {
			if (other.clube != null)
				return false;
		} else if (!clube.equals(other.clube))
			return false;
		if (guidJogo == null) {
			if (other.guidJogo != null)
				return false;
		} else if (!guidJogo.equals(other.guidJogo))
			return false;
		if (guidScoutDetalhes == null) {
			if (other.guidScoutDetalhes != null)
				return false;
		} else if (!guidScoutDetalhes.equals(other.guidScoutDetalhes))
			return false;
		return true;
	}
	
	
}
