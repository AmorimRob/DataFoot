package br.com.alesil.datafoot.model;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="DF_JOGO")
public class Jogo {

	@Id
	@Column(name="JG_GUID_JOGO")
	private UUID guidJogo;
	
	@Column(name="JG_DATA")
	private Date data;
	
	@Column(name="JG_GUID_ESTADIO")
	private UUID guidEstadio;
	
	@Column(name="JG_GUID_CLUBE_MANDANTE")
	private UUID guidClubeMandante;
	
	@Column(name="JG_GOLS_MANDANTE")
	private Integer golsMandante;
	
	@Column(name="JG_GUID_CLUBE_VISITANTE")
	private UUID guidClubeVisitante;
	
	@Column(name="JG_GOLS_VISITANTE")
	private Integer golsVisitante;
	
	@Column(name="JG_GUID_COMPETICAO")
	private UUID competicao;
	
	
	public UUID getGuidJogo() {
		return guidJogo;
	}
	public void setGuidJogo(UUID guidJogo) {
		this.guidJogo = guidJogo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public UUID getGuidEstadio() {
		return guidEstadio;
	}
	public void setGuidEstadio(UUID guidEstadio) {
		this.guidEstadio = guidEstadio;
	}
	public UUID getGuidClubeMandante() {
		return guidClubeMandante;
	}
	public void setGuidClubeMandante(UUID guidClubeMandante) {
		this.guidClubeMandante = guidClubeMandante;
	}
	public Integer getGolsMandante() {
		return golsMandante;
	}
	public void setGolsMandante(Integer golsMandante) {
		this.golsMandante = golsMandante;
	}
	public UUID getGuidClubeVisitante() {
		return guidClubeVisitante;
	}
	public void setGuidClubeVisitante(UUID guidClubeVisitante) {
		this.guidClubeVisitante = guidClubeVisitante;
	}
	public Integer getGolsVisitante() {
		return golsVisitante;
	}
	public void setGolsVisitante(Integer golsVisitante) {
		this.golsVisitante = golsVisitante;
	}
	public UUID getCompeticao() {
		return competicao;
	}
	public void setCompeticao(UUID competicao) {
		this.competicao = competicao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competicao == null) ? 0 : competicao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((golsMandante == null) ? 0 : golsMandante.hashCode());
		result = prime * result
				+ ((golsVisitante == null) ? 0 : golsVisitante.hashCode());
		result = prime
				* result
				+ ((guidClubeMandante == null) ? 0 : guidClubeMandante
						.hashCode());
		result = prime
				* result
				+ ((guidClubeVisitante == null) ? 0 : guidClubeVisitante
						.hashCode());
		result = prime * result
				+ ((guidEstadio == null) ? 0 : guidEstadio.hashCode());
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
		Jogo other = (Jogo) obj;
		if (competicao == null) {
			if (other.competicao != null)
				return false;
		} else if (!competicao.equals(other.competicao))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (golsMandante == null) {
			if (other.golsMandante != null)
				return false;
		} else if (!golsMandante.equals(other.golsMandante))
			return false;
		if (golsVisitante == null) {
			if (other.golsVisitante != null)
				return false;
		} else if (!golsVisitante.equals(other.golsVisitante))
			return false;
		if (guidClubeMandante == null) {
			if (other.guidClubeMandante != null)
				return false;
		} else if (!guidClubeMandante.equals(other.guidClubeMandante))
			return false;
		if (guidClubeVisitante == null) {
			if (other.guidClubeVisitante != null)
				return false;
		} else if (!guidClubeVisitante.equals(other.guidClubeVisitante))
			return false;
		if (guidEstadio == null) {
			if (other.guidEstadio != null)
				return false;
		} else if (!guidEstadio.equals(other.guidEstadio))
			return false;
		if (guidJogo == null) {
			if (other.guidJogo != null)
				return false;
		} else if (!guidJogo.equals(other.guidJogo))
			return false;
		return true;
	}
	
	
}
