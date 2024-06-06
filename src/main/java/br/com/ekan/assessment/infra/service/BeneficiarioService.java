package br.com.ekan.assessment.infra.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ekan.assessment.infra.domain.Beneficiario;
import br.com.ekan.assessment.infra.dto.BeneficiarioDTO;
import br.com.ekan.assessment.infra.exception.BeneficiarioException;
import br.com.ekan.assessment.infra.mapper.BeneficiarioMapper;
import br.com.ekan.assessment.infra.repository.BeneficiarioRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BeneficiarioService {
	
	@Autowired
	private BeneficiarioMapper beneficiarioMapper;
	
	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	public List<BeneficiarioDTO> findAll() {
		List<Beneficiario> beneficiarioDomain = beneficiarioRepository.findAll();
		List<BeneficiarioDTO> beneficiarioDTO = beneficiarioDomain.stream().map(b -> 
		beneficiarioMapper.toBeneficiarioDTOSemDocumentos(b)
		).collect(Collectors.toList());
		
		return beneficiarioDTO;
		
	}

	public BeneficiarioDTO findById(Long id) {
		Optional<Beneficiario> beneficiarioDomain = beneficiarioRepository.findById(id);
		BeneficiarioDTO beneficiarioDTO = null;
		if(beneficiarioDomain.isPresent()) {
			Beneficiario b = beneficiarioDomain.get();
			beneficiarioDTO = beneficiarioMapper.toBeneficiarioDTOComDocumentos(b);
		}
		 
		return beneficiarioDTO;
	}
	
	public void save(BeneficiarioDTO dto) {
		Beneficiario domain = beneficiarioMapper.toBeneficiario(dto);
		beneficiarioRepository.save(domain);
	}
	
	public void editarBeneficiario(Long id, BeneficiarioDTO beneficiario) {
		Optional<Beneficiario> domainOpt = beneficiarioRepository.findById(id);
		if(domainOpt.isEmpty()) {
			throw new BeneficiarioException("Não encontrado beneficiário com este id.");
		}
	}
	
	public void excluiBeneficiario(Long id) {
		beneficiarioRepository.deleteById(id);
	}

}
