package br.com.ekan.assessment.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import br.com.ekan.assessment.infra.domain.Beneficiario;
import br.com.ekan.assessment.infra.dto.BeneficiarioDTO;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BeneficiarioMapper {

	@Mapping(target = "documentos", ignore = true)
	BeneficiarioDTO toBeneficiarioDTOSemDocumentos(Beneficiario beneficiario);
	
	BeneficiarioDTO toBeneficiarioDTOComDocumentos(Beneficiario beneficiario);
	
	Beneficiario toBeneficiario(BeneficiarioDTO beneficiarioDTO);
	
	void merge(BeneficiarioDTO dto, @MappingTarget Beneficiario beneficiario);
}
