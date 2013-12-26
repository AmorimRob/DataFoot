package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_scout")
public class Scout {
	
	@Id
	@Column(name="SC_GUID_JOGO")
	private String guidJogo;
	
	@Column(name="SC_CLUBE")
	private String clube;
	
	@Column(name="SC_GUID_SCOUT")
	private String guidScout;
	
	@Column(name="SC_GUID_ESQUEMA")
	private String guidEsquemaTatico;

	
	public String getGuidJogo() {
		return guidJogo;
	}

	public void setGuidJogo(String guidJogo) {
		this.guidJogo = guidJogo;
	}

	public String getClube() {
		return clube;
	}

	public void setClube(String clube) {
		this.clube = clube;
	}

	public String getGuidScout() {
		return guidScout;
	}

	public void setGuidScout(String guidScout) {
		this.guidScout = guidScout;
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
				+ ((guidScout == null) ? 0 : guidScout
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
		if (guidScout == null) {
			if (other.guidScout != null)
				return false;
		} else if (!guidScout.equals(other.guidScout))
			return false;
		return true;
	}

	public String getGuidEsquemaTatico() {
		return guidEsquemaTatico;
	}

	public void setGuidEsquemaTatico(String guidEsquemaTatico) {
		this.guidEsquemaTatico = guidEsquemaTatico;
	}
	
}
