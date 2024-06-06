package br.com.ekan.assessment.infra.domain;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipoDocumento;
	private String descricao;
	private Date dataInclusao;
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="beneficiario_id", nullable=false)
	private Beneficiario beneficiario;

}
