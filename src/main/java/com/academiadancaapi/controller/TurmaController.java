package com.academiadancaapi.controller;

import com.academiadancaapi.dto.TurmaRequestDTO;
import com.academiadancaapi.dto.TurmaResponseDTO;
import com.academiadancaapi.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Turma", description = "Gerenciamento de turmas")
@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @Operation(summary = "Listar todos os Turma")
    @GetMapping
    public List<TurmaResponseDTO> listar(@RequestParam(required = false) String nome, @RequestParam(required = false) Long professorId) {
        List<TurmaResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (professorId != null) {
            resultado = resultado.stream().filter(item -> professorId.equals(item.getProfessorId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Turma por ID")
    @GetMapping("/{id}")
    public TurmaResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Turma")
    @PostMapping
    public ResponseEntity<TurmaResponseDTO> criar(@Valid @RequestBody TurmaRequestDTO turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(turma));
    }

    @Operation(summary = "Atualizar Turma")
    @PutMapping("/{id}")
    public TurmaResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody TurmaRequestDTO turma) {
        return service.atualizar(id, turma);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Turma")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
