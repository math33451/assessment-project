package br.com.ekan.assessment.infra.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
public class Documento extends BaseDocument{

	private String tipoDocumento;
	private String descricao;

}
