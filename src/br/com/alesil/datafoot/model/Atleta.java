package br.com.alesil.datafoot.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DF_ATLETA")
public class Atleta  {
	
	@Id
	@Column(name="ATL_GUID_ATLETA")
	private String guidAtleta;
	
	@Column(name="ATL_NOME")
	private String nome;
	
	@Column(name="ATL_APELIDO")
	private String apelido;
	
	@Column(name="ATL_GUID_CATEGORIA")
	private String guidCategoria;
	
	@Column(name="ATL_FOTO")
	private byte[] foto;
	
	@Column(name="ATL_DATA_NASC")
	private Date dataNasc;
	
	@Column(name="ATL_NACIONALIDADE")
	private String nacionalidade;
	
	@Column(name="ATL_GUID_POSICAO_ORIGINAL")
	private String guidPosicao;
	
	@Column(name="ATL_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="ATL_NUMERO_PADRAO")
	private Integer numeroPadrao;

	public String getGuidAtleta() {
		return guidAtleta;
	}

	public void setGuidAtleta(String guidAtleta) {
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

	public String getGuidPosicao() {
		return guidPosicao;
	}

	public void setGuidPosicao(String guidPosicao) {
		this.guidPosicao = guidPosicao;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
		this.guidClube = guidClube;
	}

	public Integer getNumeroPadrao() {
		return numeroPadrao;
	}

	public void setNumeroPadrao(Integer numeroPadrao) {
		this.numeroPadrao = numeroPadrao;
	}

	public String getGuidCategoria() {
		return guidCategoria;
	}

	public void setGuidCategoria(String guidCategoria) {
		this.guidCategoria = guidCategoria;
	}

}
