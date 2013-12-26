package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_scout_acao")
public class ScoutAcao {

	@Id
	@Column(name="SCA_GUID_ACAO")
	private String guidAcao;
	
	@Column(name="SCA_DESCRICAO")
	private String descricao;
	
	@Column(name="SCA_SIGLA")
	private String sigla;
	
	@Column(name="SCA_ATALHO")
	private String atalho;
	
	@Column(name="SCA_ATLETA2")
	private boolean atleta2;

	public String getGuidAcao() {
		return guidAcao;
	}

	public void setGuidAcao(String guidAcao) {
		this.guidAcao = guidAcao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public boolean isAtleta2() {
		return atleta2;
	}

	public void setAtleta2(boolean atleta2) {
		this.atleta2 = atleta2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (atleta2 ? 1231 : 1237);
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((guidAcao == null) ? 0 : guidAcao.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		ScoutAcao other = (ScoutAcao) obj;
		if (atleta2 != other.atleta2)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (guidAcao == null) {
			if (other.guidAcao != null)
				return false;
		} else if (!guidAcao.equals(other.guidAcao))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	public String getAtalho() {
		return atalho;
	}

	public void setAtalho(String atalho) {
		this.atalho = atalho;
	}
	
}
