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
	private Integer golsMandante;
	
	@Column(name="JG_GUID_CLUBE_VISITANTE")
	private String guidClubeVisitante;
	
	@Column(name="JG_GOLS_VISITANTE")
	private Integer golsVisitante;
	
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

	public Integer getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(Integer golsMandante) {
		this.golsMandante = golsMandante;
	}

	public String getGuidClubeVisitante() {
		return guidClubeVisitante;
	}

	public void setGuidClubeVisitante(String guidClubeVisitante) {
		this.guidClubeVisitante = guidClubeVisitante;
	}

	public Integer getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(Integer golsVisitante) {
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

	
}
