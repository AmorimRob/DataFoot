package br.com.alesil.datafoot.model;

import java.util.UUID;
import javax.persistence.*;

@Entity
@Table(name="DF_COMISSAO_TECNICA_JOGO")
public class ComissaoTecnicaJogo {
	
	@Id
	@Column(name="CTJ_GUID_COMISSAO_TECNICA")
	private UUID guidComissaoTecnica;
	
	@Id
	@Column(name="CTJ_GUID_CLUBE")
	private UUID clube;
	
	@Id
	@Column(name="CTJ_GUID_JOGO")
	private UUID guidJogo;

	@Column(name="CTJ_GUID_FUNCAO")
	private UUID guidFuncao;
}
