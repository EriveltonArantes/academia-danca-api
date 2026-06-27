package com.academiadancaapi.mapper;

import com.academiadancaapi.dto.TurmaRequestDTO;
import com.academiadancaapi.dto.TurmaResponseDTO;
import com.academiadancaapi.model.Turma;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TurmaMapper {

    @Mapping(target = "professor", ignore = true)
    Turma toEntity(TurmaRequestDTO dto);

    @Mapping(target = "professorId", source = "professor.id")
    TurmaResponseDTO toResponseDTO(Turma entity);
}
