package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_posicao")
public class Posicao {
	
	@Id
	@Column(name="POS_GUID_POSICAO")
	private String guidPosicao;
	
	@Column(name="POS_NOME_POSICAO")
	private String nome_posicao;

	public String getGuidPosicao() {
		return guidPosicao;
	}

	public void setGuidPosicao(String guidPosicao) {
		this.guidPosicao = guidPosicao;
	}

	public String getNome_posicao() {
		return nome_posicao;
	}

	public void setNome_posicao(String nome_posicao) {
		this.nome_posicao = nome_posicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidPosicao == null) ? 0 : guidPosicao.hashCode());
		result = prime * result
				+ ((nome_posicao == null) ? 0 : nome_posicao.hashCode());
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
		Posicao other = (Posicao) obj;
		if (guidPosicao == null) {
			if (other.guidPosicao != null)
				return false;
		} else if (!guidPosicao.equals(other.guidPosicao))
			return false;
		if (nome_posicao == null) {
			if (other.nome_posicao != null)
				return false;
		} else if (!nome_posicao.equals(other.nome_posicao))
			return false;
		return true;
	}
	
}
