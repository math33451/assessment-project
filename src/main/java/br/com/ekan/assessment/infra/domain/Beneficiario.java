package br.com.ekan.assessment.infra.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Beneficiario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String telefone;
	private Date dataNascimento;
	private Date dataInclusao;
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy="beneficiario", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Documento> documentos;

}
