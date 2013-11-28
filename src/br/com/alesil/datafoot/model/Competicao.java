package br.com.alesil.datafoot.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_competicao")
public class Competicao {
	
	@Id
	@Column(name="COMP_GUID_COMPETICAO")
	private String guidCompeticao;
	
	@Column(name="COMP_GUID_CATEGORIA")
	private String guidCategoria;
	
	@Column(name="COMP_NOME_COMPETICAO")
	private String nomeCompeticao;
	
	@Column(name="COMP_LOGO")
	private byte[]logo;
	
	@Column(name="COMP_DATA_INICIO")
	private Date dataInicio;
	
	public String getGuidCompeticao() {
		return guidCompeticao;
	}
	public void setGuidCompeticao(String guidCompeticao) {
		this.guidCompeticao = guidCompeticao;
	}
	public String getGuidCategoria() {
		return guidCategoria;
	}
	public void setGuidCategoria(String guidCategoria) {
		this.guidCategoria = guidCategoria;
	}
	public String getNomeCompeticao() {
		return nomeCompeticao;
	}
	public void setNomeCompeticao(String nomeCompeticao) {
		this.nomeCompeticao = nomeCompeticao;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result
				+ ((guidCategoria == null) ? 0 : guidCategoria.hashCode());
		result = prime * result
				+ ((guidCompeticao == null) ? 0 : guidCompeticao.hashCode());
		result = prime * result + Arrays.hashCode(logo);
		result = prime * result
				+ ((nomeCompeticao == null) ? 0 : nomeCompeticao.hashCode());
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
		Competicao other = (Competicao) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (guidCategoria == null) {
			if (other.guidCategoria != null)
				return false;
		} else if (!guidCategoria.equals(other.guidCategoria))
			return false;
		if (guidCompeticao == null) {
			if (other.guidCompeticao != null)
				return false;
		} else if (!guidCompeticao.equals(other.guidCompeticao))
			return false;
		if (!Arrays.equals(logo, other.logo))
			return false;
		if (nomeCompeticao == null) {
			if (other.nomeCompeticao != null)
				return false;
		} else if (!nomeCompeticao.equals(other.nomeCompeticao))
			return false;
		return true;
	}
	
	
}
