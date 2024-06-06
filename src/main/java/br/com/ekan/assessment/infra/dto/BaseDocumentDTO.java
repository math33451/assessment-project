package br.com.ekan.assessment.infra.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BaseDocumentDTO {

	private Long id;
	private Date dataInclusao;
	private Date dataAtualizacao;

}
