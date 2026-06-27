package com.academiadancaapi.mapper;

import com.academiadancaapi.dto.ProfessorRequestDTO;
import com.academiadancaapi.dto.ProfessorResponseDTO;
import com.academiadancaapi.model.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    @Mapping(target = "aluno", ignore = true)
    Professor toEntity(ProfessorRequestDTO dto);

    @Mapping(target = "alunoId", source = "aluno.id")
    ProfessorResponseDTO toResponseDTO(Professor entity);
}
