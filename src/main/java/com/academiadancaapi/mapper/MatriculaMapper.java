package com.academiadancaapi.mapper;

import com.academiadancaapi.dto.MatriculaRequestDTO;
import com.academiadancaapi.dto.MatriculaResponseDTO;
import com.academiadancaapi.model.Matricula;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    @Mapping(target = "aluno", ignore = true)
    @Mapping(target = "turma", ignore = true)
    Matricula toEntity(MatriculaRequestDTO dto);

    @Mapping(target = "alunoId", source = "aluno.id")
    @Mapping(target = "turmaId", source = "turma.id")
    MatriculaResponseDTO toResponseDTO(Matricula entity);
}
