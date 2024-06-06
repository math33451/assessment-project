package br.com.ekan.assessment.infra.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.assessment.infra.domain.Beneficiario;
import br.com.ekan.assessment.infra.dto.BeneficiarioDTO;
import br.com.ekan.assessment.infra.dto.DocumentoDTO;
import br.com.ekan.assessment.infra.exception.BeneficiarioException;
import br.com.ekan.assessment.infra.mapper.BeneficiarioMapper;
import br.com.ekan.assessment.infra.repository.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioMapper beneficiarioMapper;
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private DocumentoService documentoService;
	
	public List<BeneficiarioDTO> findAll() {
		List<Beneficiario> beneficiarioDomain = beneficiarioRepository.findAll();
		List<BeneficiarioDTO> beneficiarioDTO = beneficiarioDomain.stream().map(b -> 
		beneficiarioMapper.toBeneficiarioDTO(b)
		).collect(Collectors.toList());
		
		return beneficiarioDTO;
		
	}

	public BeneficiarioDTO findDocumentosById(Long id) {
		BeneficiarioDTO beneficiarioDTO = null;
		Beneficiario beneficiarioDomain = findById(id);
		List<DocumentoDTO> documentos = documentoService.findByBeneficiario(beneficiarioDomain);
		beneficiarioDTO = beneficiarioMapper.toBeneficiarioDTO(beneficiarioDomain);
		beneficiarioDTO.setDocumentos(documentos);
		return beneficiarioDTO;
	}
	
	public void save(BeneficiarioDTO dto) {
		realizaValidacoes(dto);
		Beneficiario domain = beneficiarioMapper.toBeneficiario(dto);
		domain.setDataInclusao(new Date());
		domain.setDataAtualizacao(new Date());
		domain.getDocumentos().stream().forEach(doc ->{
			doc.setDataInclusao(new Date());
			doc.setDataAtualizacao(new Date());
			doc.setBeneficiario(domain);
		});
		beneficiarioRepository.save(domain);
	}

	public void editarBeneficiario(Long id, BeneficiarioDTO beneficiario) {
		Beneficiario beneficiarioDomain = findById(id);
		beneficiarioMapper.merge(beneficiario, beneficiarioDomain);
		documentoService.adicionaNovoDocumento(beneficiario, beneficiarioDomain);
		beneficiarioDomain.setDataAtualizacao(new Date());
		beneficiarioRepository.save(beneficiarioDomain);
	}
	
	public void excluiBeneficiario(Long id) {
		beneficiarioRepository.deleteById(id);
	}

	private void realizaValidacoes(BeneficiarioDTO dto) {
		if(dto.getNome().isBlank() || dto.getNome().isEmpty()) {
			throw new BeneficiarioException("É necessário preencher o nome completo do beneficiário.");
		}
		if(dto.getTelefone().isBlank() || dto.getTelefone().isEmpty()) {
			throw new BeneficiarioException("É necessário preencher o telefone do beneficiário.");
		}
	}
	
	private Beneficiario findById(Long id) {
		Optional<Beneficiario> beneficiarioOpt = beneficiarioRepository.findById(id);
		if(beneficiarioOpt.isEmpty()) {
			throw new BeneficiarioException("Beneficiario não encontrado para este id.");
		}
		
		return beneficiarioOpt.get();
	}
}
