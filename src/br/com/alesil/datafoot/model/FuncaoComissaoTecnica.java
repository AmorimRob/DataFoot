package br.com.alesil.datafoot.model;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="DF_FUNCAO_COMISSAO_TECNICA")
public class FuncaoComissaoTecnica {
	
	@Id
	@Column(name="FCT_GUID_FUNCAO")
	private UUID guidFuncao;
	
	@Column(name="FCT_NOME_FUNCAO")
	private String nomeFuncao;
	
	public UUID getGuidFuncao() {
		return guidFuncao;
	}
	public void setGuidFuncao(UUID guidFuncao) {
		this.guidFuncao = guidFuncao;
	}
	public String getNomeFuncao() {
		return nomeFuncao;
	}
	public void setNomeFuncao(String nomeFuncao) {
		this.nomeFuncao = nomeFuncao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((guidFuncao == null) ? 0 : guidFuncao.hashCode());
		result = prime * result
				+ ((nomeFuncao == null) ? 0 : nomeFuncao.hashCode());
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
		FuncaoComissaoTecnica other = (FuncaoComissaoTecnica) obj;
		if (guidFuncao == null) {
			if (other.guidFuncao != null)
				return false;
		} else if (!guidFuncao.equals(other.guidFuncao))
			return false;
		if (nomeFuncao == null) {
			if (other.nomeFuncao != null)
				return false;
		} else if (!nomeFuncao.equals(other.nomeFuncao))
			return false;
		return true;
	}
	
}
