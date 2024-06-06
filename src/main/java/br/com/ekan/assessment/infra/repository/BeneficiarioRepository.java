package br.com.ekan.assessment.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ekan.assessment.infra.domain.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

	Optional<Beneficiario> findByNome(String nome);

}
