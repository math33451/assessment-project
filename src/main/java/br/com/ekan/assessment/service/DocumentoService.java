package br.com.ekan.assessment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.assessment.domain.Beneficiario;
import br.com.ekan.assessment.domain.Documento;
import br.com.ekan.assessment.dto.BeneficiarioDTO;
import br.com.ekan.assessment.dto.DocumentoDTO;
import br.com.ekan.assessment.exception.BeneficiarioException;
import br.com.ekan.assessment.exception.DocumentoException;
import br.com.ekan.assessment.mapper.DocumentoMapper;
import br.com.ekan.assessment.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
@Transactional
public class DocumentoService {

	@Autowired
	private DocumentoRepository documentoRepository;
	
	@Autowired
	private DocumentoMapper documentoMapper;
	
	public void salvarTodosDocumentos(BeneficiarioDTO beneficiarioDTO, Beneficiario beneficiario) {
		validaDocumentos(beneficiarioDTO);
		List<Documento> listaDomain = new ArrayList<>();
		for(DocumentoDTO dto : beneficiarioDTO.getDocumentos()) {
			Documento domain = documentoMapper.toDocumento(dto);
			domain.setBeneficiario(beneficiario);
			domain.setDataAtualizacao(new Date());;
			domain.setDataInclusao(new Date());
			listaDomain.add(domain);
		}
		
		documentoRepository.saveAll(listaDomain);
	}
	
	public List<DocumentoDTO> findByBeneficiario(Beneficiario beneficiario) {
		List<Documento> listaDomain = documentoRepository.findAllByBeneficiario(beneficiario);
		List<DocumentoDTO> listaDTO = listaDomain.stream().map(d -> 
		documentoMapper.toDocumentoDTO(d)
		).collect(Collectors.toList());
		
		return listaDTO;
	}
	
	public void adicionaNovoDocumento(BeneficiarioDTO beneficiario, Beneficiario beneficiarioDomain) {
		List<DocumentoDTO> listaDocumentoDTO = beneficiario.getDocumentos();
		if(listaDocumentoDTO != null) {
			List<Documento> listaDocDomain = documentoRepository.findAllByBeneficiario(beneficiarioDomain);
			
			listaDocumentoDTO.stream().forEach(doc ->{
				for(Documento docDomain : listaDocDomain) {
					if(doc.getTipoDocumento().equals(docDomain.getTipoDocumento())) {
						if(!doc.getDescricao().equals(docDomain.getDescricao())){
							docDomain.setDataAtualizacao(new Date());
							docDomain.setDescricao(doc.getDescricao());
							documentoRepository.save(docDomain);
							return;
						}else {
							return;
						}
					}else {
						doc.setDataInclusao(new Date());
						doc.setDataAtualizacao(new Date());
						Documento domainToSave = documentoMapper.toDocumento(doc);
						domainToSave.setBeneficiario(beneficiarioDomain);
						documentoRepository.save(domainToSave);
						return;
					}
				}
			});
		}
	}

	private void validaDocumentos(BeneficiarioDTO beneficiarioDTO) {
		List<DocumentoDTO> documentos = beneficiarioDTO.getDocumentos();
		if(documentos == null || documentos.isEmpty()) {
			throw new BeneficiarioException("É necessário preencher pelo menos um documento do beneficiário.");
		}
		for(DocumentoDTO dto : documentos) {
			if(dto.getTipoDocumento().isBlank() || dto.getTipoDocumento().isEmpty()) {
				throw new DocumentoException("O tipo do documento precisa ser informado.");
			}
			if(dto.getDescricao().isBlank() || dto.getDescricao().isEmpty()) {
				throw new DocumentoException("O número do documento precisa ser informado na descrição.");
			}
			Optional<Documento> domain = documentoRepository.findByDescricao(dto.getDescricao());
			if(domain.isPresent()) {
				if(domain.get().getBeneficiario().getNome().equals(beneficiarioDTO.getNome())) {
					throw new DocumentoException(dto.getTipoDocumento() + " já está cadastrado para este beneficiário.");
				}
				throw new DocumentoException(dto.getTipoDocumento() + " já está cadastrado para outro beneficiário.");
			}
		}
	}
}
