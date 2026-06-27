package com.academiadancaapi.mapper;

import com.academiadancaapi.dto.AlunoRequestDTO;
import com.academiadancaapi.dto.AlunoResponseDTO;
import com.academiadancaapi.model.Aluno;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "turma", ignore = true)
    Aluno toEntity(AlunoRequestDTO dto);

    @Mapping(target = "turmaId", source = "turma.id")
    AlunoResponseDTO toResponseDTO(Aluno entity);
}
