package br.com.ekan.assessment.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import br.com.ekan.assessment.domain.Documento;
import br.com.ekan.assessment.dto.DocumentoDTO;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

	DocumentoMapper INSTANCE = Mappers.getMapper(DocumentoMapper.class);
	
	DocumentoDTO toDocumentoDTO(Documento documento);
	
	Documento toDocumento(DocumentoDTO documentoDTO);
	
	void merge(DocumentoDTO dto, @MappingTarget Documento documento);
}
