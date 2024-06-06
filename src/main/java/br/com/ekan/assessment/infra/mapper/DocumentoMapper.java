package br.com.ekan.assessment.infra.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.ekan.assessment.infra.domain.Documento;
import br.com.ekan.assessment.infra.dto.DocumentoDTO;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

	DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);
	
	DocumentoDTO toDocumentoDTO(Documento documento);
	
	Documento toDocumento(DocumentoDTO documentoDTO);
	
	void merge(DocumentoDTO dto, @MappingTarget Documento documento);
}
