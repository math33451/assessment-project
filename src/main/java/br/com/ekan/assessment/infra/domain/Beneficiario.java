package br.com.ekan.assessment.infra.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Beneficiario extends BaseDocument{

	private String nome;
	private String telefone;
	private Date dataNascimento;
	
	@OneToMany(mappedBy="beneficiario")
	private List<Documento> documentos;

}
