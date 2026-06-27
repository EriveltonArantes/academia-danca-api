package com.academiadancaapi.controller;

import com.academiadancaapi.model.Professor;
import com.academiadancaapi.model.Aluno;
import com.academiadancaapi.model.Turma;
import com.academiadancaapi.model.Matricula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.academiadancaapi.repository.ProfessorRepository professorRepository;

    @Autowired
    private com.academiadancaapi.repository.AlunoRepository alunoRepository;

    @Autowired
    private com.academiadancaapi.repository.TurmaRepository turmaRepository;

    @Autowired
    private com.academiadancaapi.repository.MatriculaRepository matriculaRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalProfessor", professorRepository.count());
        resumo.put("totalAluno", alunoRepository.count());
        resumo.put("totalTurma", turmaRepository.count());
        resumo.put("somaVagasTurma", turmaRepository.findAll().stream().filter(e -> e.getVagas() != null).mapToInt(e -> e.getVagas()).sum());
        resumo.put("totalMatricula", matriculaRepository.count());
        resumo.put("somaMensalidadeMatricula", matriculaRepository.findAll().stream().map(e -> e.getMensalidade()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoMatricula", matriculaRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
