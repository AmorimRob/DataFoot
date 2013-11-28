package br.com.alesil.datafoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="df_comissao_tecnica")
public class ComissaoTecnica {

	@Id
	@Column(name="CT_GUID_COMISSAO_TECNICA")
	private String guidComissaoTecnica;
	
	@Column(name="CT_GUID_CLUBE")
	private String guidClube;
	
	@Column(name="CT_NOME")
	private String nome;
	
	@Column(name="CT_APELIDO")
	private String apelido;
	
	@Column(name="CT_GUID_FUNCAO")
	private String guidFuncao;
	
	@Column(name="CT_FOTO")
	private byte[] foto;
	
	public String getGuidComissaoTecnica() {
		return guidComissaoTecnica;
	}

	public void setGuidComissaoTecnica(String guidComissaoTecnica) {
		this.guidComissaoTecnica = guidComissaoTecnica;
	}

	public String getGuidClube() {
		return guidClube;
	}

	public void setGuidClube(String guidClube) {
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

	public String getGuidFuncao() {
		return guidFuncao;
	}

	public void setGuidFuncao(String guidFuncao) {
		this.guidFuncao = guidFuncao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
