package br.com.ekan.assessment.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.ekan.assessment.infra.domain.Beneficiario;
import br.com.ekan.assessment.infra.dto.BeneficiarioDTO;

@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {
	
	BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);

	BeneficiarioDTO toBeneficiarioDTO(Beneficiario beneficiario);
	
	Beneficiario toBeneficiario(BeneficiarioDTO beneficiarioDTO);
	
	Beneficiario merge(BeneficiarioDTO dto, @MappingTarget Beneficiario beneficiario);
}
