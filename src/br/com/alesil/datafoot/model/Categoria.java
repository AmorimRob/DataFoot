package br.com.alesil.datafoot.model;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_CATEGORIAS")
public class Categoria {

	@Id
	@Column(name="CAT_GUID_CATEGORIA")
	private UUID guidCategoria;
	
	@Column(name="CAT_NOME_CATEGORIA")
	private String nomeCategoria;
	
	@Column(name="CAT_DESCRICAO")
	private String descricao;
	
	public UUID getGuidCategoria() {
		return guidCategoria;
	}
	public void setGuidCategoria(UUID guidCategoria) {
		this.guidCategoria = guidCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((guidCategoria == null) ? 0 : guidCategoria.hashCode());
		result = prime * result
				+ ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (guidCategoria == null) {
			if (other.guidCategoria != null)
				return false;
		} else if (!guidCategoria.equals(other.guidCategoria))
			return false;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		return true;
	}
	
	
}
