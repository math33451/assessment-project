package br.com.ekan.assessment.infra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ekan.assessment.infra.domain.Beneficiario;
import br.com.ekan.assessment.infra.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

	Optional<Documento> findByDescricao(String descricao);

	List<Documento> findAllByBeneficiario(Beneficiario beneficiario);
}
