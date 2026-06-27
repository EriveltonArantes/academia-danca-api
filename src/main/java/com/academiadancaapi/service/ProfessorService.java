package com.academiadancaapi.service;

import com.academiadancaapi.dto.ProfessorRequestDTO;
import com.academiadancaapi.dto.ProfessorResponseDTO;
import com.academiadancaapi.exception.ResourceNotFoundException;
import com.academiadancaapi.mapper.ProfessorMapper;
import com.academiadancaapi.model.Professor;
import com.academiadancaapi.repository.ProfessorRepository;
import com.academiadancaapi.repository.AlunoRepository;
import com.academiadancaapi.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private ProfessorMapper mapper;

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public List<ProfessorResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfessorResponseDTO buscar(Long id) {
        Professor entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ProfessorResponseDTO criar(ProfessorRequestDTO dto) {
        Professor entity = mapper.toEntity(dto);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Professor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ProfessorResponseDTO atualizar(Long id, ProfessorRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + id);
        }
        Professor entity = mapper.toEntity(dto);
        entity.setId(id);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Professor salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Professor não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
