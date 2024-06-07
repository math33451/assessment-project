package br.com.ekan.assessment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.ekan.assessment.domain.Beneficiario;
import br.com.ekan.assessment.dto.BeneficiarioDTO;

@Mapper(componentModel = "spring")
public interface BeneficiarioMapper {
	
	BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);

	BeneficiarioDTO toBeneficiarioDTO(Beneficiario beneficiario);
	
	Beneficiario toBeneficiario(BeneficiarioDTO beneficiarioDTO);
	
	@Mapping(target = "dataAtualizacao", ignore = true)
	@Mapping(target = "dataInclusao", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "documentos", ignore = true)
	Beneficiario merge(BeneficiarioDTO dto, @MappingTarget Beneficiario beneficiario);
}
