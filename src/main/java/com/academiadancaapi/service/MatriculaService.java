package com.academiadancaapi.service;

import com.academiadancaapi.dto.MatriculaRequestDTO;
import com.academiadancaapi.dto.MatriculaResponseDTO;
import com.academiadancaapi.exception.ResourceNotFoundException;
import com.academiadancaapi.mapper.MatriculaMapper;
import com.academiadancaapi.model.Matricula;
import com.academiadancaapi.repository.MatriculaRepository;
import com.academiadancaapi.repository.AlunoRepository;
import com.academiadancaapi.model.Aluno;
import com.academiadancaapi.repository.TurmaRepository;
import com.academiadancaapi.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MatriculaService {

    @Autowired
    private MatriculaRepository repository;

    @Autowired
    private MatriculaMapper mapper;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(readOnly = true)
    public List<MatriculaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MatriculaResponseDTO buscar(Long id) {
        Matricula entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Matricula não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public MatriculaResponseDTO criar(MatriculaRequestDTO dto) {
        Matricula entity = mapper.toEntity(dto);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public MatriculaResponseDTO atualizar(Long id, MatriculaRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        Matricula entity = mapper.toEntity(dto);
        entity.setId(id);
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
            .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + dto.getAlunoId()));
        entity.setAluno(aluno);
        Turma turma = turmaRepository.findById(dto.getTurmaId())
            .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrado com id: " + dto.getTurmaId()));
        entity.setTurma(turma);
        Matricula salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
