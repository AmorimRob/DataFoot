package br.com.alesil.datafoot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_jogo")
public class Jogo {

	@Id
	@Column(name="JG_GUID_JOGO")
	private String guidJogo;
	
	@Column(name="JG_DATA")
	private Date data;
	
	@Column(name="JG_GUID_ESTADIO")
	private String guidEstadio;
	
	@Column(name="JG_GUID_CLUBE_MANDANTE")
	private String guidClubeMandante;
	
	@Column(name="JG_GOLS_MANDANTE")
	private int golsMandante;
	
	@Column(name="JG_GUID_CLUBE_VISITANTE")
	private String guidClubeVisitante;
	
	@Column(name="JG_GOLS_VISITANTE")
	private int golsVisitante;
	
	@Column(name="JG_GUID_COMPETICAO")
	private String competicao;
	
	@Column(name="JG_HORARIO")
	private String horario;

	public String getGuidJogo() {
		return guidJogo;
	}

	public void setGuidJogo(String guidJogo) {
		this.guidJogo = guidJogo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getGuidEstadio() {
		return guidEstadio;
	}

	public void setGuidEstadio(String guidEstadio) {
		this.guidEstadio = guidEstadio;
	}

	public String getGuidClubeMandante() {
		return guidClubeMandante;
	}

	public void setGuidClubeMandante(String guidClubeMandante) {
		this.guidClubeMandante = guidClubeMandante;
	}

	public int getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}

	public String getGuidClubeVisitante() {
		return guidClubeVisitante;
	}

	public void setGuidClubeVisitante(String guidClubeVisitante) {
		this.guidClubeVisitante = guidClubeVisitante;
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	public String getCompeticao() {
		return competicao;
	}

	public void setCompeticao(String competicao) {
		this.competicao = competicao;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competicao == null) ? 0 : competicao.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + golsMandante;
		result = prime * result + golsVisitante;
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
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
		if (golsMandante != other.golsMandante)
			return false;
		if (golsVisitante != other.golsVisitante)
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
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}

	
}
