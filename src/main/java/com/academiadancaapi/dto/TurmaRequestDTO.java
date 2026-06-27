package com.academiadancaapi.dto;

import jakarta.validation.constraints.*;

public class TurmaRequestDTO {

    @NotNull(message = "ProfessorId é obrigatório")
    @Positive(message = "ProfessorId deve ser um ID válido (positivo)")
    private Long professorId;
    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "estilo não pode estar em branco")
    private String estilo;
    @NotBlank(message = "nivel não pode estar em branco")
    private String nivel;
    @NotBlank(message = "dias semana não pode estar em branco")
    private String diasSemana;
    @NotBlank(message = "horario não pode estar em branco")
    private String horario;
    @NotBlank(message = "duracao não pode estar em branco")
    private String duracao;
    @Min(value = 0, message = "vagas não pode ser negativo")
    @NotNull(message = "vagas não pode ser nulo")
    private Integer vagas;
    @DecimalMin(value = "0.0", message = "mensalidade não pode ser negativo")
    @NotNull(message = "mensalidade não pode ser nulo")
    private java.math.BigDecimal mensalidade;
    @NotNull(message = "ativa não pode ser nulo")
    private Boolean ativa;

    public Long getProfessorId() { return professorId; }
    public void setProfessorId(Long professorId) { this.professorId = professorId; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEstilo() { return estilo; }
    public void setEstilo(String estilo) { this.estilo = estilo; }
    public String getNivel() { return nivel; }
    public void setNivel(String nivel) { this.nivel = nivel; }
    public String getDiasSemana() { return diasSemana; }
    public void setDiasSemana(String diasSemana) { this.diasSemana = diasSemana; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getDuracao() { return duracao; }
    public void setDuracao(String duracao) { this.duracao = duracao; }
    public Integer getVagas() { return vagas; }
    public void setVagas(Integer vagas) { this.vagas = vagas; }
    public java.math.BigDecimal getMensalidade() { return mensalidade; }
    public void setMensalidade(java.math.BigDecimal mensalidade) { this.mensalidade = mensalidade; }
    public Boolean getAtiva() { return ativa; }
    public void setAtiva(Boolean ativa) { this.ativa = ativa; }
}
