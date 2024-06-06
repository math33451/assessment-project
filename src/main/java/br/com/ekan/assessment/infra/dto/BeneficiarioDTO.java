package br.com.ekan.assessment.infra.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class BeneficiarioDTO extends BaseDocumentDTO{

	private String nome;
	private String telefone;
	private Date dataNascimento;
	private List<DocumentoDTO> documentos;
}
