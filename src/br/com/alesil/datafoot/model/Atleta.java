package br.com.alesil.datafoot.model;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="DF_ATLETA")
public class Atleta {
	
	@Id
	@Column(name="ATL_GUID_ATLETA")
	private UUID guidAtleta;
	
	@Column(name="ATL_NOME")
	private String nome;
	
	@Column(name="ATL_APELIDO")
	private String apelido;
	
	@Column(name="ATL_FOTO")
	private byte[]foto;
	
	@Column(name="ATL_DATA_NASC")
	private Date dataNasc;
	
	@Column(name="ATL_NACIONALIDADE")
	private String nacionalidade;
	
	@Column(name="ATL_GUID_POSICAO")
	private UUID guidPosicao;
	
	@Column(name="ATL_GUID_CLUBE")
	private UUID guidClube;
	
	@Column(name="ATL_NUMERO_PADRAO")
	private Integer numeroPadrao;

	public UUID getGuidAtleta() {
		return guidAtleta;
	}

	public void setGuidAtleta(UUID guidAtleta) {
		this.guidAtleta = guidAtleta;
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public UUID getGuidPosicao() {
		return guidPosicao;
	}

	public void setGuidPosicao(UUID guidPosicao) {
		this.guidPosicao = guidPosicao;
	}

	public UUID getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(UUID guidClube) {
		this.guidClube = guidClube;
	}

	public Integer getNumeroPadrao() {
		return numeroPadrao;
	}

	public void setNumeroPadrao(Integer numeroPadrao) {
		this.numeroPadrao = numeroPadrao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apelido == null) ? 0 : apelido.hashCode());
		result = prime * result
				+ ((dataNasc == null) ? 0 : dataNasc.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result
				+ ((guidAtleta == null) ? 0 : guidAtleta.hashCode());
		result = prime * result
				+ ((guidClube == null) ? 0 : guidClube.hashCode());
		result = prime * result
				+ ((guidPosicao == null) ? 0 : guidPosicao.hashCode());
		result = prime * result
				+ ((nacionalidade == null) ? 0 : nacionalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((numeroPadrao == null) ? 0 : numeroPadrao.hashCode());
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
		Atleta other = (Atleta) obj;
		if (apelido == null) {
			if (other.apelido != null)
				return false;
		} else if (!apelido.equals(other.apelido))
			return false;
		if (dataNasc == null) {
			if (other.dataNasc != null)
				return false;
		} else if (!dataNasc.equals(other.dataNasc))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (guidAtleta == null) {
			if (other.guidAtleta != null)
				return false;
		} else if (!guidAtleta.equals(other.guidAtleta))
			return false;
		if (guidClube == null) {
			if (other.guidClube != null)
				return false;
		} else if (!guidClube.equals(other.guidClube))
			return false;
		if (guidPosicao == null) {
			if (other.guidPosicao != null)
				return false;
		} else if (!guidPosicao.equals(other.guidPosicao))
			return false;
		if (nacionalidade == null) {
			if (other.nacionalidade != null)
				return false;
		} else if (!nacionalidade.equals(other.nacionalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroPadrao == null) {
			if (other.numeroPadrao != null)
				return false;
		} else if (!numeroPadrao.equals(other.numeroPadrao))
			return false;
		return true;
	}
}
