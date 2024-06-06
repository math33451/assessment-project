package br.com.ekan.assessment.infra.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class DocumentoDTO extends BaseDocumentDTO{

	private String tipoDocumento;
	private String descricao;

}
