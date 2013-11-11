package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_COMISSAO_TECNICA")
public class ComissaoTecnica {

	@Id
	@Column(name="CT_GUID_COMISSAO_TECNICA")
	private UUID guidComissaoTecnica;
	
	@Column(name="CT_GUID_CLUBE")
	private UUID guidClube;
	
	@Column(name="CT_NOME")
	private String nome;
	
	@Column(name="CT_APELIDO")
	private String apelido;
	
	@Column(name="CT_GUID_FUNCAO")
	private UUID guidFuncao;

	public UUID getGuidComissaoTecnica() {
		return guidComissaoTecnica;
	}

	public void setGuidComissaoTecnica(UUID guidComissaoTecnica) {
		this.guidComissaoTecnica = guidComissaoTecnica;
	}

	public UUID getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(UUID guidClube) {
		this.guidClube = guidClube;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public UUID getGuidFuncao() {
		return guidFuncao;
	}

	public void setGuidFuncao(UUID guidFuncao) {
		this.guidFuncao = guidFuncao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime
				* result
				+ ((guidComissaoTecnica == null) ? 0 : guidComissaoTecnica
						.hashCode());
		result = prime * result
				+ ((guidFuncao == null) ? 0 : guidFuncao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		ComissaoTecnica other = (ComissaoTecnica) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidComissaoTecnica == null) {
			if (other.guidComissaoTecnica != null)
				return false;
		} else if (!guidComissaoTecnica.equals(other.guidComissaoTecnica))
			return false;
		if (guidFuncao == null) {
			if (other.guidFuncao != null)
				return false;
		} else if (!guidFuncao.equals(other.guidFuncao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}