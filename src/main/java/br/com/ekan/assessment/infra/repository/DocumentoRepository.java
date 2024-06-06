package br.com.ekan.assessment.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ekan.assessment.infra.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {


}
