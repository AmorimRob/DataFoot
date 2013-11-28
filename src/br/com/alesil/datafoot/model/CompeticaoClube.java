package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="df_competicao_clube")
public class CompeticaoClube {

	@Id
	@Column(name="COMPCL_GUID_COMPETICAO")
	private UUID guidCompeticao;
	
	@Id
	@Column(name="COMPCL_GUID_CLUBE")
	private UUID guidClube;

	public UUID getGuidCompeticao() {
		return guidCompeticao;
	}

	public void setGuidCompeticao(UUID guidCompeticao) {
		this.guidCompeticao = guidCompeticao;
	}

	public UUID getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(UUID guidClube) {
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
