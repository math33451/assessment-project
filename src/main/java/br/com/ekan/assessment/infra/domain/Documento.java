package br.com.ekan.assessment.infra.domain;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
public class Documento extends BaseDocument{

	private String tipoDocumento;
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name="beneficiario_id", nullable=false)
	private Beneficiario beneficiario;

}
